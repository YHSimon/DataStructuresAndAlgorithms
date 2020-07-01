package day01;

//动态规划
public class Solution2 {
    public static void main(String[] args) {
        Solution2 s=new Solution2();
        System.out.println(s.findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
    //70ms
    public int findLength(int[] A,int[] B){
        int max=0;
        int[][] dp=new int[A.length+1][B.length+1];
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
