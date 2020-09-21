package second_simu_competiton.test07;

import java.util.Scanner;

/**
 * 问题描述
 *
 * 　　如果一个序列的奇数项都比前一项大，偶数项都比前一项小，则称为一个摆动序列。即 a[2i]<a[2i-1], a[2i+1]>a[2i]。
 * 　　小明想知道，长度为 m，每个数都是 1 到 n 之间的正整数的摆动序列一共有多少个。
 *
 * 输入格式
 *
 * 　　输入一行包含两个整数 m，n。
 *
 * 输出格式
 *
 * 　　输出一个整数，表示答案。答案可能很大，请输出答案除以10000的余数。
 *
 * 样例输入
 *
 * 3 4
 *
 * 样例输出
 *
 * 14
 *
 * 样例说明
 *
 * 　　以下是符合要求的摆动序列：
 * 　　2 1 2
 * 　　2 1 3
 * 　　2 1 4
 * 　　3 1 2
 * 　　3 1 3
 * 　　3 1 4
 * 　　3 2 3
 * 　　3 2 4
 * 　　4 1 2
 * 　　4 1 3
 * 　　4 1 4
 * 　　4 2 3
 * 　　4 2 4
 * 　　4 3 4
 *
 * 评测用例规模与约定
 *
 * 　　对于 20% 的评测用例，1 <= n, m <= 5；
 * 　　对于 50% 的评测用例，1 <= n, m <= 10；
 * 　　对于 80% 的评测用例，1 <= n, m <= 100；
 * 　　对于所有评测用例，1 <= n, m <= 1000。
 */

//动态规划
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt(),n=in.nextInt();
        in.close();
        int[][] dp=new int[m+2][n+2];

        for(int i=1;i<=n;i++){
            dp[1][i]=n-i+1;
        }

        for(int i=2;i<=n;i++){
            if(i%2==1){
                for(int j=n;j>=1;j--){
                    dp[i][j]=(dp[i-1][j-1]+dp[i][j+1])%10000;
                }
            }else{
                for(int j=1;j<=n;j++){
                    dp[i][j]=(dp[i-1][j+1]+dp[i][j-1])%10000;
                }
            }
        }

        int result=(m&1)==1? dp[m][1]:dp[m][n];
        System.out.println(result);
    }
}
