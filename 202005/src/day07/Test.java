package day07;

public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.mySqrt3(2147483647));
//        System.out.println(t.mySqrt(2147483647));
//        System.out.println(Math.sqrt(2147483647));
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt3(int x){
        if(x==0) return 0;

        double C=x,x0=x;
        while(true){
            double xi=0.5*(x0+C/x0);
            if(Math.abs(x0-xi)<1e-7){
                break;
            }
            x0=xi;
        }
        return (int) x0;
    }

    /**
     * 袖珍计算器
     */
    public int mySqrt2(int x){
        if(x==0) return 0;
        int ans=(int)Math.exp(0.5*Math.log(x));
        return (long)(ans+1)*(ans+1)<=x?ans+1:ans;
    }

    /**
     * 1ms 二分法
     * @param x
     * @return
     */
    public int mySqrt(int x){
        int start=0,end=x,ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if((long)mid*mid<=x){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return  ans;
    }

}
