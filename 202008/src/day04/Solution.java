package day04;

/** 201 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(5&6&7);
        Solution s=new Solution();
        long start = System.currentTimeMillis();
        System.out.println(s.rangeBitwiseAnd2(0, 2147483647));
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(start-end));
    }

    // 7ms  位移
    public int rangeBitwiseAnd(int m, int n) {  //0  2147483647
        int shift=0;
        while(m<n){
            m>>=1;
            n>>=1;
            ++shift;
        }
        return m<<shift;
    }

    // 6ms
    public int rangeBitwiseAnd2(int m,int n){
        while(m<n){
            n=n&(n-1);
        }
        return n;
    }
}
