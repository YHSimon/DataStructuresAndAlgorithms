package day03;

import java.util.Arrays;

/**面试题29，顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 1ms  O(mn)
     * 空间复杂度 O(1)
     */
    public static int[] spiralOrder2(int[][] matrix){
        if(matrix.length == 0) return new int[0];
        //定义  l r t b 四个边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res=new int[(r+1)*(b+1)];
        while(true){
            for(int i=1;i<=r;i++) res[x++]=matrix[t][i];
            if(++t>b) break;
            for(int i=1;i<=b;i++) res[x++]=matrix[i][r];
            if(l>--r) break;
            for(int i=r;i>=l;i--) res[x++]=matrix[b][i];
            if(t>--b) break;
            for(int i=b;i>=t;i--) res[x++]=matrix[i][l];
            if(++l>r) break;
        }
        return res;
    }

    /**
     * 2ms O(mn)
     * 空间复杂度 O(mn)
     */
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0) return new int[0];
        int r = matrix.length,count=0,c = matrix[0].length,sum=r*c;
        int[] ans=new int[sum];
        int[][] record= new int[r][c];
        int i=0,j=0;
        while(count<sum){
            while(j<c&&record[i][j]==0){
                ans[count]=matrix[i][j];
                record[i][j]=1;
                count++;
                j++;
            }
            j--;
            i++;

            while(i<r&&record[i][j]==0){
                ans[count]=matrix[i][j];
                record[i][j]=1;
                count++;
                i++;
            }
            i--;
            j--;

            while(j>=0&&record[i][j]==0){
                ans[count]=matrix[i][j];
                record[i][j]=1;
                count++;
                j--;
            }
            j++;
            i--;

            while(i>=0&&record[i][j]==0){
                ans[count]=matrix[i][j];
                record[i][j]=1;
                count++;
                i--;
            }
            i++;
            j++;
        }
        return ans;
    }
}
