package day08;


/**
 * 计算 pow（x,n）
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 t=new Test2();
        System.out.println(t.myPow(2, 35));
    }
    public double myPow(double x,int n){
        int N=n;
        return N>=0?quickMul2(x, N):quickMul2(x, -N);
    }

    /**
     * 快速幂+递归
     */
    public double quickMul(double x,int N){
        //递归结束条件
        if(N==0) return 1.0;
        double y=quickMul(x,N/2);
        return N%2==1?y*y*x:y*y;
    }

    /**
     * 快速幂+迭代
     */
    public double quickMul2(double x, int N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

}
