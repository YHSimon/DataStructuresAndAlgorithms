package q1;

import java.util.Scanner;

/**
 * 数字三角形问题
 *       7
 *      3 8
 *     8 1 0
 *    2 7 4 4
 *   4 5 2 6 5
 *
 *   在上面的数字三角形中找出一条从顶部到底部的路径，使得路径上所经过的数字之和最大。路径上
 *   的每一步只能往左下或右下走。
 *
 *   三角形的行数大于1小于等于100
 */


public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] arr=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                arr[i][j]=in.nextInt();
            }
        }
        show(arr);
        System.out.println(getMax(arr, n));
        System.out.println(dpSolution(arr, n));
    }

    public static int getMax(int[][] arr,int c){
        int i=0,j=0;
        return recur(arr,c,i,j);
    }

    public static int dpSolution(int[][] arr,int n){
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[n][i]=arr[n][i];
        }
        for (int i = n-1; i >=0 ; i--) {
            for(int j=0;j<i;j++){
                dp[i][j]=Math.max(dp[i+1][j],dp[i+1][j+1]);
            }

        }
        return dp[0][0];
    }
    //若使用递归方式
    public static int recur(int[][] arr,int n,int i,int j){
        if(i==n){
            return arr[i][j];
        }
        int x=recur(arr, n, i+1, j);
        int y=recur(arr, n, i+1, j+1);
        return Math.max(x, y)+arr[i][j];
    }

    public  static void show(int[][] arrs){
        for (int i = 0; i < arrs.length; i++) {
            for(int j=0;j<arrs[i].length;j++){
                System.out.print(arrs[i][j]+" ");
            }
            System.out.println();
        }
    }
}
