package day2;

public class Main {
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
