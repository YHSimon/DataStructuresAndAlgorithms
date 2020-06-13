package day10;

/** 70.爬楼梯
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int a=1,b=2,count=3;
        while(count<=n){
            int tmp=a+b;
            a=b;
            b=tmp;
            count++;
        }
        return b;
    }
}
