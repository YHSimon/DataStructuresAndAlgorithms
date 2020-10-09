package competiton11.test01;


import java.util.Date;

/**
 * 【问题描述】
 * 7 月 1 日是建党日，从 1921 年到 2020 年，中国共产党已经带领中国人民
 * 走过了 99 年。
 * 请计算：7 ^ 2020 mod 1921，其中 A mod B 表示 A 除以 B 的余数。
 * 【答案提交】
 * 这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
 * 整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 【问题描述】
 * 2020 年 7 月 1 日是中国 共 产 党 成立 99 周年纪念日。
 * 中国 共 产 党 成立于 1921 年 7 月 23 日。
 * 请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包含多少分钟？
 */
public class Main {
    public static void main(String[] args) {
//        int sum=1;
//        for(int i=0;i<2020;i++){
//            sum*=7;
//            sum=sum%1921;
//        }
//        System.out.println(sum);
        System.out.println(interval(1921, 2020)-22);
    }

    public static int interval(int start,int end){
        int sum=0;
        for (int i = start; i <end ; i++) {
            if((i%100!=0&&i%4==0)||(i%400==0)){
                sum+=366;
            }else{
                sum+=365;
            }
        }

        return sum;
    }
}
