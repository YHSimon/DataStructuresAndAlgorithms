package competiton11.test05;

import java.util.Scanner;

/**
 * 【问题描述】
 * 小明有一串很长的英文字母，可能包含大写和小写。
 * 在这串字母中，有很多连续的是重复的。小明想了一个办法将这串字达得更短：将连续的几个相同字母写成字母 + 出现次数的形式。
 * 例如，连续的 5 个 a，即 aaaaa，小明可以简写成 a5（也可能简写aa3a 等）。对于这个例子：HHHellllloo，小明可以简写成 H3el5o2。
 * 为了方达，小明不会将连续的超过 9 个相同的字符写成简写的形式。
 * 现在给出简写后的字符串，请帮助小明还原成原来的串。
 * 【输入格式】
 * 输入一行包含一个字符串。
 * 【输出格式】
 * 输出一个字符串，表示还原后的串。
 * 【样例输入】
 * H3el5o2
 * 【样例输出】
 * HHHellllloo
 * 【评测用例规模与约定】
 * 对于所有评测用例，字符串由大小写英文字母和数字组成，长度不100。
 * 请注意原来的串长度可能超过 100。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        int len=str.length();
        char now=str.charAt(0);
        for(int i=0;i<len;i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                System.out.print(str.charAt(i));
                now=str.charAt(i);
            }
            int x=0;
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                x=(int)(str.charAt(i)-'0');
                for(int j=i+1;j<len;j++){
                    if(str.charAt(j)>='0'&&str.charAt(j)<='9'){
                        x=x*10+(int)(str.charAt(j)-'0');
                    }else{
                        break;
                    }
                }
                for(int j=0;j<x-1;j++){
                    System.out.print(now);
                }
            }
        }

    }
}
