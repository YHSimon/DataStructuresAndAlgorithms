package second_simu_competiton11.test07;

import java.util.Scanner;

//递归 数据比较大时 容易超时
public class Main2 {
    static int mod=10000;
    static int ans=0;
    static Scanner in=new Scanner(System.in);
    static int m=in.nextInt(),n=in.nextInt();
    public static void f(int k,int loc){//k用于保存前一项的值，loc为位置
        if(loc==m+1){//递归出口
            ans++;
            return;
        }
        if(loc%2==0){ //偶数位 比前一位小
            for(int i=k-1;i>=1;i--){
                f(i,loc+1);
            }
        }else{//奇数位 比前一位大
            for(int i=k+1;i<=n;i++){
                f(i,loc+1);
            }
        }
    }

    public static void main(String[] args) {
        if(m==1) System.out.println(n);
        else{
            for(int i=1;i<=n;i++){
                f(i,2);
            }
        }
        System.out.println("ans="+ans%mod);
    }

}
