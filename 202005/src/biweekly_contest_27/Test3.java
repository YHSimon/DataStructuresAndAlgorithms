package biweekly_contest_27;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


public class Test3 {
    public static void main(String[] args) {
        int n=7;
//        int[][] prerequisites={{1,1},{1,2},{2,3},{3,4}};
//        int[][] prerequisites={{1,2},{1,0},{2,0}};
        int[][] prerequisites={{2,3},{2,1},{2,0},{3,4},{3,6},{5,1},{5,0},{1,4},{1,0},{4,0},{0,6}};
        int[][] queries={{3,0},{6,4},{5,6},{2,6},{2,3},{5,6},{4,0},{2,6},{3,5},{5,3},{1,6},{1,0},{3,5},{6,5},{2,3},{3,0},{3,4},{3,4},{2,5},{0,3},{4,0},{6,4},{5,0},{6,5},{5,6},{6,5},{1,0},{3,4},{1,5},{1,4},{3,6},{0,1},{1,2},{5,1},{5,3},{5,3},{3,4},{5,4},{5,4},{5,3}};

        checkIfPrerequisite(n, prerequisites, queries);
    }

    /**
     * 超时
     */
    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> list=new ArrayList<>();
        if(prerequisites==null||prerequisites.length==0){
            for(int i=0;i<queries.length;i++){
                list.add(true);
            }
            return list;
        }
        Map<Integer, Set<Integer>> relations=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            Set<Integer> set=new CopyOnWriteArraySet<>();
            if(relations.containsKey(prerequisites[i][0])){
                set=relations.get(prerequisites[i][0]);
                set.add(prerequisites[i][1]);
                relations.put(prerequisites[i][0],set);
            }else{
                set.add(prerequisites[i][1]);
                relations.put(prerequisites[i][0],set);
            }
        }
        for(Map.Entry<Integer,Set<Integer>> entry:relations.entrySet()){
            Iterator<Integer> it=entry.getValue().iterator();
            Set<Integer> tmp = entry.getValue();
            while(it.hasNext()){
                add(tmp,it.next(),relations);
            }
        }

//        System.out.println(relations.toString());

        for(int i=0;i<queries.length;i++){
           Set<Integer> tmp=relations.get(queries[i][0]);
           if(tmp!=null&&tmp.contains(queries[i][1])){
               list.add(true);
           }else{
               list.add(false);
           }
        }
        return list;
    }
    public static void add(Set<Integer> set,int i,Map<Integer,Set<Integer>> relations){
        if(!relations.containsKey(i)){
            return;
        }
        for(int j:relations.get(i)){
            set.add(j);
            add(set, j, relations);
        }
    }
}
