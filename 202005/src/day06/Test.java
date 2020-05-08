package day06;

/**题目：
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        char[][] matrix = {{'1', '0', '1', '0','0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        t.list(matrix);
        System.out.println(t.maximalSquare2(matrix));
    }

    /**
     * 6ms 动态规划
     * @param matrix
     * @return
     */
    public int maximalSquare3(char[][] matrix){
        int maxSide=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return maxSide;
        int rows=matrix.length,columns=matrix[0].length;
        int[][] dp=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]=='1'){
                    if(i==0||j==0){
                        dp[i][j]=0;
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
                    }
                    maxSide=Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
    public int maximalSquare2(char[][] matrix){
        int maxSide=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return maxSide;
        int r=matrix.length,c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]=='1'){
                    //一个值为1的点 可以构成一个边长为1的正方形
                    maxSide=Math.max(maxSide, 1);
                    //以当前点  作为 正方形的左上角顶点，计算能构成正方形的最大边长
                    int curMaxSide=Math.min(r-i, c-j);
                    for(int k=1;k<curMaxSide;k++){
                        boolean flag=true;
                        //判断正方形的右下角顶点是否为1  (对角线上)
                        if(matrix[i+k][j+k]=='0'){
                            break;
                        }
                        //新增一行一列 判断多出来的点是否为 '1' 不包含右下角顶点
                        for(int m=0;m<k;m++){
                            if(matrix[i+k][j+m]=='0'||matrix[i+m][j+k]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide=Math.max(maxSide, k+1);
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return maxSide*maxSide;
    }

    /**
     * 暴力解决
     * 4ms
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0) return maxSide;
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') {
                    maxSide=Math.max(maxSide, 1);
                    //计算可能的最大正方形的边长
                    int curMaxSide = Math.min(r - i, c - j);
                    for(int k=1;k<curMaxSide;k++){
                        boolean flag=true;
                        if(matrix[i+k][j+k]=='0'){
                            break;
                        }
                        for(int m=0;m<k;m++){
                            if(matrix[i+k][j+m]=='0'||matrix[i+m][j+k]=='0'){
                                flag=false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide=Math.max(maxSide, k+1);
                        }else {
                            break;
                        }
                    }

                }
            }
        }
        return maxSide * maxSide;
    }

    //遍历数组
    public void list(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
