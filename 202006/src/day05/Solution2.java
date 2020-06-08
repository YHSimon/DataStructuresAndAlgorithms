package day05;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
//        String[] equations=new String[]{"c==c","b==d","x!=z","x==z"};
//        String[] equations=new String[]{"a!=a"};
        String[] equations=new String[]{"a==b","e==c","b==c","a!=e"};
        System.out.println(equationsPossible(equations));
    }



    public static boolean equationsPossible(String[] equations) {
        Map<Character, Set<Character>> map =new HashMap<>();
        for(String equation:equations){
           if(equation.charAt(1)=='='){
               char c1=equation.charAt(0),c2=equation.charAt(3);
               if(map.containsKey(c1)){
                   map.get(c1).add(c2);
               }else{
                   Set<Character> set=new HashSet<>();
                   set.add(c2);
                   map.put(c1, set);
               }
               if(map.containsKey(c2)){
                   map.get(c2).add(c1);
               }else{
                   Set<Character> set=new HashSet<>();
                   set.add(c1);
                   map.put(c2, set);
               }
           }
        }
        for(Map.Entry<Character,Set<Character>> entry:map.entrySet()){
            Set<Character> tmp=entry.getValue();
            for(Character c:entry.getValue()){
                if(map.containsKey(c)){
                    tmp.addAll(map.get(c));
                }
            }
            map.put(entry.getKey(), tmp);
        }
        System.out.println(map.toString());
        for (String equation : equations) {
            if(equation.charAt(1)=='!'){
                char c1=equation.charAt(0),c2=equation.charAt(3);
                if(c1==c2) return false;
                if(map.get(c1)!=null&&map.get(c2)!=null){
                    for(Character c:map.get(c1)){
                        if(map.get(c2).contains(c)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
