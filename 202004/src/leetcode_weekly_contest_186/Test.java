package leetcode_weekly_contest_186;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();

        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        List<Integer> n3 = new ArrayList<>();
        List<Integer> n4 = new ArrayList<>();
        n1.add(1);
        n1.add(2);
        n1.add(3);
        n2.add(4);
        n2.add(5);
        n2.add(6);
        n3.add(7);
        n3.add(8);
        n3.add(9);
        n4.add(10);
        n4.add(11);
        n4.add(12);
        nums.add(n1);
        nums.add(n2);
        nums.add(n3);
        nums.add(n4);
//        System.out.println(nums.toString());
        System.out.println(Arrays.toString(t.findDiagonalOrder(nums)));


//        String s="1111";
//        System.out.println(t.maxScore(s));

    }


    /**
     * 解题思路
     *根据矩形的特点，设行的标号为i，列的标号为j。则对于每一条对角线而言，i + j的值是唯一的。
     * 知道这一点之后，就可以按照对角线对nums中的值进行聚类。聚类完毕后，将所有的数值生成一个数组即可。
     * 需补充Map类型的区别
     *
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder2(List<List<Integer>> nums){
        int len=0;
        Map<Integer,List<Integer>> map=new TreeMap<>();  //默认对可以进行排序   可指定排序依据
        for(int i=0;i<nums.size();i++){
            len+=nums.get(i).size();
            for(int j=0;j<nums.get(i).size();j++){
                if(map.containsKey(i+j)){
                    map.get(i+j).add(nums.get(i).get(j));
                }else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i+j, list);
                }
            }
        }

        int[] ans=new int [len];
        int index=0;
        for(int key:map.keySet()){
            List<Integer> list=map.get(key);
            for(int j=list.size()-1;j>=0;j--){
                ans[index]=list.get(j);
                index++;
            }
        }
        return ans;
    }

    /**
     * 对角线遍历
     *
     * 结果: 超出内存  通过  52/56
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int r = nums.size();
        int c = 0;
        //集合元素的数量
        int count = 0;
        Integer[][] res = new Integer[r][];
        for (int i = 0; i < r; i++) {
            Integer[] t2 = new Integer[nums.get(i).size()];
            nums.get(i).toArray(t2);
            res[i] = t2;
            int temp = res[i].length;
            count += temp;
            if (temp > c) {
                c = temp;
            }
        }
        //设置行遍历终点
        int max = Math.max(r, c);
        Integer[][] res2=new Integer[max][max];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
               res2[i][j]=res[i][j];
            }
        }
        res=null;
        int[] a = new int[count];
        //数组a标记
        int index = 0;

        for (int i = 0; i <= max - 1; i++) {
            int temp = i;
            for (int n = 0; n <= i&&temp>=0; n++) {
                if (res2[temp][n] != null) {
                    a[index++] = res2[temp][n];
                }
                temp--;
            }
        }
        for(int j=1;j<=max-1;j++){
            int temp=j;
            for(int i=max-1;i>=j;i--){
                if (res2[i][temp] != null) {
                    if(index>=count){
                        return a;
                    }
                    a[index++] = res2[i][temp];
                }
                temp++;
            }
        }
        return a;
    }

    public int maxScore(String s) {
        int max = 0;
        int len = s.length();
        int i = 0;
        while (i < len - 1) {
            int temp = 0;
            for (int m = 0; m <= i; m++) {
                if (s.charAt(m) == '0') {
                    temp++;
                }
            }
            for (int n = i + 1; n < len; n++) {
                if (s.charAt(n) == '1') {
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
            }
            i++;
        }
        return max;
    }
}
