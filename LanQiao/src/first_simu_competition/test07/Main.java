package first_simu_competition.test07;

import java.util.Scanner;

/**
 * 问题描述：
 * 小明对类似于hello这种单词非常感兴趣，这种单词可以正好分为四段，
 * 第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，
 * 第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
 * 给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。（元音字母包括a,e,i,o,u，共五个，其他均为辅音字母。）
 * 输入格式：
 *        输入一行，包含一个单词，单词中只包含小写英文字母。
 *
 * 输出格式：
 *        输出答案，或者为yes，或者为no。
 *
 * 样例输入：lanqiao
 * 样例输出：yes
 *
 * 样例输入：world
 * 样例输出：no
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();in.close();
        //flag false 表示辅音  true 表示元音
        char first=str.charAt(0);int count=0;boolean flag=false;
        if(first=='a'||first=='e'||first=='i'||first=='o'||first=='u'){
            System.out.println("no");
        }else{
            for(int i=1;i<str.length();i++){
                if(count>2){
                    break;
                }
                char c=str.charAt(i);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    if(!flag){
                        flag=true;
                        count++;
                    }
                }else{
                    if(flag){
                        flag=false;
                    }
                }
            }
            System.out.println(count);
            if(count==2&&flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

    }
}
