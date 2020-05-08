package day06;

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Test2 {
    /**
     * 7ms  动态规划
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int ans = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    //边界处理  i==0或者j==0
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        ans++;
                    } else {
                        //递推公式
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                        ans += dp[i][j];
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 7ms
     * 暴力解法
     */
    public int countSquares2(int[][] matrix){
        int ans=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return  ans;
        int r=matrix.length,c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==1){
                    ans++;
                    //以（i,j）为左上角 能构成最大正方形的长度
                    int curMaxSide=Math.min(r-i, c-j);
                    for(int k=1;k<curMaxSide;k++){
                        boolean flag=true;
                        //先判断对角线  该点其实是多出一行 一列的公共点
                        if(matrix[i+k][j+k]==0){
                            break;
                        }
                        //边长增加1 判断多出来的一行 一列 的元素值 是否为 1
                        for(int m=0;m<k;m++){
                            if(matrix[i+k][j+m]==0||matrix[i+m][j+k]==0){
                                flag=false;
                                break;
                            }
                        }
                        if(flag){
                            ans++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
