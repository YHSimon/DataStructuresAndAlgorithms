package day01;

/**
 * 45ms
 * 动态规划
 */
public class Solution3 {
    public int findLength(int[] A,int[] B){
        int max=0;
        int[][] dp=new int[A.length][B.length];
        //初始化dp[0][i]  第一行
        for(int i=0;i<B.length;i++){
            if(A[0]==B[i]){
                dp[0][i]=1;
            }
        }
        //初始化dp[i][0] 第一列
        for(int i=0;i<A.length;i++){
            if(A[i]==B[0]){
                dp[i][0]=1;
            }
        }
        for(int i=1;i<A.length;i++){
            for(int j=1;j<B.length;j++){
                if(A[i]==B[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
