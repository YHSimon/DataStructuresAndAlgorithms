package biweekly_contest_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.maxDiff(9288));
//        System.out.println(t.kidsWithCandies(new int[]{4,2,1,1,2}, 1).toString());
    }

    /**
     * 10ms
     */
    public boolean checkIfCanBreak2(String s1, String s2) {
        boolean ans=false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(chars1[i]>=chars2[i]){
                ans=true;
                count++;
            }else{
                ans=false;
                break;
            }
        }
        if(count==s1.length()){
            return true;
        }
        for(int i=0;i<s1.length();i++){
            if(chars1[i]<=chars2[i]){
                ans=true;
            }else{
                ans=false;
                break;
            }
        }
        return ans;
    }



    /**
     * 5386. 检查一个字符串是否可以打破另一个字符串
     *
     * 给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
     *
     * 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
     *
     *  164 ms
     */
    public boolean checkIfCanBreak(String s1, String s2) {
        boolean ans=false;
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        List<Character> l1= new ArrayList<>();
        List<Character> l2= new ArrayList<>();
        for(char c:chars){
            l1.add(c);
        }
        for(char c:chars1){
            l2.add(c);
        }
        Collections.sort(l1);
        Collections.sort(l2);
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(l1.get(i)>=l2.get(i)){
                ans=true;
                count++;
            }else{
                ans=false;
                break;
            }
        }
        if(count==s1.length()){
            return true;
        }
        for(int i=0;i<s1.length();i++){
            if(l1.get(i)<=l2.get(i)){
                ans=true;
            }else{
                ans=false;
                break;
            }
        }
        return ans;
    }

    /**
     *
         给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：

            选择一个数字 x (0 <= x <= 9).
            选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
            将 num 中所有出现 x 的数位都用 y 替换。
            得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
            令两次对 num 的操作得到的结果分别为 a 和 b 。

            请你返回 a 和 b 的 最大差值 。
     *
     *  14ms
     */
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int len= s.length();
        char[] chars = s.toCharArray();
        String s1="";
        String s2="";

        int max=0,min=0;
        if(len<=1) return 8;
        int index=0;
        //寻找最大数
        while(index<len&&s.charAt(index)=='9'){
            index++;
        }
        s1=s.substring(0,index);
        char c=s.charAt(index);
        for(int i=index;i<len;i++){
            if(chars[i]==c){
                chars[i]='9';
            }
            s1+=chars[i];
        }
        max=Integer.parseInt(s1);
        index=0;
//        System.out.println("max:"+max);

        //寻找最小数
        chars=s.toCharArray();
        if(s.charAt(0)!='1'){
            c=s.charAt(0);
            for(int i=index;i<len;i++){
                if(chars[i]==c){
                    chars[i]='1';
                }
                s2+=chars[i];
            }
            min=Integer.parseInt(s2);
        }else{
            index=1;
            while(index<len&&(s.charAt(index)=='0'||s.charAt(index)=='1')){
                index++;
            }
            //例如 1000  此时index会越界 需要对index进行处理
            index=Math.min(index,len-1);
            c=s.charAt(index);
            s2=s.substring(0,index);
            for(int i=index;i<len;i++){
                if(chars[i]==c){
                    chars[i]='0';
                }
                s2+=chars[i];
            }
            min=Integer.parseInt(s2);
        }
//        System.out.println("min:"+min);
        return max-min;
    }

    /**
     * 2
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans=new ArrayList<>();
        int max=0;
        for(int candy:candies){
            max=Math.max(max, candy);
        }
        for(int candy:candies){
            if((candy+extraCandies)>=max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}
