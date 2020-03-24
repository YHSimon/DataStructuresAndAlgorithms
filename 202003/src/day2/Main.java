package day2;

public class Main {
    public static void main(String[] args) {
        Main m=new Main();
        System.out.println(m.JumpFloor(5));
    }
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int temp=0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>array[i+1]){
                temp=array[i+1];
                break;
            }
        }
        return temp;
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }else if(n==1||n==2){
            return 1;
        }
        int[] a=new int[2];
        a[0]=1;
        a[1]=1;
        int res=0;
        for(int i=3;i<=n;i++){
            res=a[0]+a[1];
            a[0]=a[1];
            a[1]=res;
        }
        return  res;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * 递归思想
     *
     */
    public int JumpFloor(int target) {
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = one+ two;
            one = two;
            two = result;
        }
        return result;
    }

}
