package second_simu_competiton11.test03;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 递归实现
 *
 * 思想：每次从字符串选择一个字母作为首字母，其余的字母进行全排列，该过程是递归的
 * 递归结束标志是遍历到最后一个字符
 */
public class Solution {
    static List<String> list=new ArrayList<>();
    public static void main(String[] args) {
        String str="LAN";
        finishFullPermutation(str.toCharArray());
        System.out.println(list.size());
    }
    public static void finishFullPermutation(char[] chars){
        permutation(chars, 0, chars.length);
    }
    public static void permutation(char[] chars,int start,int end){
        if(end<0){
            return;
        }
        if(start==end){
            list.add(String.valueOf(chars));
        }else{
            for(int i=start;i<end;i++){
                //更换前缀
                swap(chars,i,start);
                //递归将剩余元素全排列
                permutation(chars, start+1, end);
                //将前缀换回，以便进行上一个前缀的全排列
                swap(chars,start,i);
            }
        }
    }

    public static void swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
