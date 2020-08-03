package day01;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        String s="aaab";
        Set<String> set=new HashSet<>();
        int[] dp=new int[s.length()];
        String pre=s.substring(0,1);
        set.add(pre);
        dp[0]=1;
        for(int i=1;i<s.length();i++){
            String tmp=String.valueOf(s.charAt(i));

            if(!set.contains(tmp)){

            }
        }
    }
}
