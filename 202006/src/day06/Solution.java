package day06;

//找到问题的子结构，做好状态定义，并导出转移方程

/**
 * 面试题46.把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 *          0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 */
public class Solution {

    public int translateNum2(int num){
        int a=1,b=1,x,y=num%10;
        while(num!=0){
            num/=10;
            x=num%10;
            int tmp=x*10+y;
            int c=(tmp>=10&&tmp<=25)?a+b:a;
            b=a;
            a=c;
            y=x;
        }
        return a;
    }
    public int translateNum(int num) {
       String s=String.valueOf(num);
       int a=1,b=1;
       for(int i=2;i<=s.length();i++){
           String tmp=s.substring(i-2,i);
           int c=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
           b=a;
           a=c;

       }
       return a;
    }

}
