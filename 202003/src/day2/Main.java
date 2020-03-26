package day2;

public class Main {
    public static void main(String[] args) {
        Main m=new Main();
//        System.out.println(m.JumpFloor(5));

        System.out.println(m.JumpFloorII(5));
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * 从后往前看  （横*竖）一块1*2竖着放 （2*（n-1））  或者 两块2*1叠着放 （2*（n-2））  两种方案相加
     */
    public int RectCover(int target){
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int a=1,b=2,sum=0;
        for(int i=3;i<=target;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    /**
     *一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * 距离目标还剩n~1层，因而形成了n种方法，当然还有一种情况是从0层直接跳到目标，所以总方案数是（前n-1项和）+1
     */
    public int JumpFloorII(int target) {
        if(target <=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        if(target==3){
            return 4;
        }
        int sum=0;
        //记录前n-1项和
        int preSum=7;
        for(int i=4;i<=target;i++){
            sum=preSum+1;
            preSum=preSum+sum;
        }
        return sum;
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

}
