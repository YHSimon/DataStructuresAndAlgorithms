package day01;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.lengthOfLongestSubstring3("abcdaaxczxcvnm123456789"));
    }

    /**
     * 使用滑动窗口  O(n)
     * 6ms   85%
     * 40M    5%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int ans=0;
        int len=s.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int start=0,end=0;end<len;end++){
            char c=s.charAt(end);
            if(map.containsKey(c)){
                start=Math.max(map.get(c), start);
            }
            ans=Math.max(ans, end-start+1);
            map.put(s.charAt(end), end+1);
        }
        return ans;
    }

    /**
     * 引用HashMap 进行contains比较  O(n^2)
     * 140ms  11%
     * 40M    5%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        int ans=0;
        char[] chars = s.toCharArray();
        int len=chars.length;
        for(int i=0;i<len;i++){
            Map<Character,Integer> map=new HashMap<>();
            for(int j=i;j<len;j++){
                if(map.containsKey(chars[j])){
                    break;
                }else{
                    map.put(chars[j],1);
                    ans=Math.max(ans, map.size());
                }
            }
        }
        return ans;
    }
    /**
     * 暴力求解
     * 261ms   7%
     * 40M     5%
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        int ans=0;
        for(int i=0;i<s.length();i++){
            String sub="";
            for(int j=i;j<s.length();j++){
                if(sub.contains(String.valueOf(s.charAt(j)))){
                    break;
                }else{
                    sub= s.substring(i, j+1);
                    ans=Math.max(ans, sub.length());
                }
            }
        }
        return ans;
    }
}
