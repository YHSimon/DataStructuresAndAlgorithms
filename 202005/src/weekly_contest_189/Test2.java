package weekly_contest_189;

import java.util.*;

/**
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 */
public class Test2 {
    public static void main(String[] args) {

        Test2 t = new Test2();
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        List<String> l4 = new ArrayList<>();
        List<String> l5 = new ArrayList<>();

        l1.add("a");
        l1.add("b");
        l1.add("c");
        l2.add("b");
        l2.add("d");
        l3.add("b");
        l3.add("c");
        l4.add("b");
        l5.add("e");
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(l1);
        favoriteCompanies.add(l2);
        favoriteCompanies.add(l3);
        favoriteCompanies.add(l4);
        favoriteCompanies.add(l5);
        System.out.println(t.peopleIndexes2(favoriteCompanies).toString());

    }

    /**
     * 216 ms
     *
     * List转Set优化  150ms
     *
     */
    public List<Integer> peopleIndexes3(List<List<String>> favoriteCompanies) {
        List<Integer> ans=new ArrayList<>();
        List<Set<String>> list=new ArrayList<>();
//        for(List<String> fa:favoriteCompanies){
//            Set<String> set=new HashSet<>(fa);
//            list.add(set);
//        }
        for(List<String> fa:favoriteCompanies){
            Set<String> set=new HashSet<>();
            for(String str:fa){
                set.add(str);
            }
            list.add(set);
        }
        for(int i=0;i<favoriteCompanies.size();i++){
            Set<String> one=list.get(i);
            boolean flag=true;
            for(int j=0;j<favoriteCompanies.size();j++){
                Set<String> two = list.get(j);
                if(two.size()>=one.size()&&i!=j){
                    if(two.containsAll(one)){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag) ans.add(i);
        }
        return ans;
    }

    /**
     * 使用 containsAll 优化代码
     * 超时
     */
    public List<Integer> peopleIndexes2(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        int size = favoriteCompanies.size();
        boolean[] record = new boolean[size];
        for (int i = 0; i < size ; i++) {
            List<String> one = favoriteCompanies.get(i);
            boolean flag =true;
            for (int j = 0; j < size; j++) {
                List<String> two = favoriteCompanies.get(j);
                if(i!=j&&two.size()>=one.size()){
                    if(two.containsAll(one)){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag) ans.add(i);
        }
        return ans;
    }

    /**
     *超时
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int size = favoriteCompanies.size();
        boolean[] record = new boolean[size];
        for (int i = 0; i < size - 1; i++) {
            List<String> l1 = favoriteCompanies.get(i);
            for (int j = i + 1; j < size; j++) {
                List<String> l2 = favoriteCompanies.get(j);
                int count = 0;
                if (record[i] || record[j]) {
                    continue;
                }
                if (l1.size() >= l2.size()) {
                    for (int k = 0; k < l2.size(); k++) {
                        if (!l1.contains(l2.get(k))) {
                            break;
                        }
                        count++;
                        if (count == l2.size()) {
                            record[j] = true;
                        }
                    }
                } else {
                    for (int k = 0; k < l1.size(); k++) {
                        if (!l2.contains(l1.get(k))) {
                            break;
                        }
                        count++;
                        if (count == l1.size()) {
                            record[i] = true;
                        }
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (!record[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
