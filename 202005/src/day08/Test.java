package day08;

/**
 *   计算 pow(x,n);
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.myPow2(0.00000, 77));
    }


    public double myPow2(double x, int n) {
        long N=n;
        return N>=0?quickMul2(x, N):1.0/(quickMul2(x, -N));
    }

    /**
     * 时间复杂度 O(log n) 递归的层数
     * 空间复杂度 O(log n) 递归的层数  这是由于递归的函数调用会使用栈空间。
     * 快速幂 递归
     */
     public double quickMul2(double x,long N){
         if(N==0) return 1.0;
         double y=quickMul2(x, N/2);
         return N%2==0?y*y:y*y*x;
     }
    /**
     * 时间 O(n)
     * 空间 O(1)
     * 快速幂   迭代
     */
//    public double quickMul(double x,long N){
//        double ans=1.0;
//        double x_c=x;
//        while(N>0){
//            if(N%2==1){
//                ans*=x_c;
//            }
//            x_c*=x_c;
//            N/=2;
//        }
//        return ans;
//    }

    /**
     * 肯定超时
     */
    public double myPow(double x, int n) {
        double ans = 1;
        if (n == 0 || x == 1) return ans;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ans *= x;
            }
        } else {
            for (int i = 0; i < -n; i++) {
                ans /= x;
            }
        }
        return ans;
    }
}
