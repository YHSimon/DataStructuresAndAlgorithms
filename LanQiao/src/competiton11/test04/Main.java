package competiton11.test04;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 试题 F: 整除序列
 * 时间限制: 1.0s 内存限制: 256.0MB 本题总分：15 分
 * 【问题描述】
 * 有一个序列，序列的第一个数是 n，后面的每个数是前一个数整除 2，请输
 * 出这个序列中值为正数的项。
 * 【输入格式】
 * 输入一行包含一个整数 n。
 * 【输出格式】
 * 输出一行，包含多个整数，相邻的整数之间用一个空格分隔，表示答案。
 * 【样例输入】
 * 20
 * 【样例输出】
 * 20 10 5 2 1
 * 【评测用例规模与约定】
 * 对于 80% 的评测用例，1 ≤ n ≤ 109。
 * 对于所有评测用例，1 ≤ n ≤ 1018。
 *
 * 注：
 * 对于100%的数据是1 ≤ n ≤ 10^18，所以无论用int还是long都会报错，所以需要用Java的BigInteger类。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        BigInteger a=in.nextBigInteger();
        while (a.compareTo(BigInteger.ZERO)!=0){
            System.out.print(a+" ");
            a=a.divide(BigInteger.valueOf(2));
        }
    }
}
