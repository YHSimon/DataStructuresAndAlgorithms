package day01;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个字符串的非空子串是指字符串中长度至少为1 的连续的一段字符组成
 * 的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共7 个。
 * 注意在计算时，只算本质不同的串的个数。
 * 请问，字符串0100110001010001 有多少个不同的非空子串？
 */
public class Solution {
    public static void main(String[] args) {
        String s="aaab";
//        String s="0100110001010001";
        int len=s.length();
        Set<String> set=new HashSet<>();
        for(int i=1;i<=len;i++){
            String str;
            for(int j=0;j<len;j++){
                if(j+i>len) break;
                str=s.substring(j,j+i);
                set.add(str);
            }
        }
        System.out.println(set.toString());
        System.out.println(set.size());
    }
}
