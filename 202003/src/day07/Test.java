package day07;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        TreeNode t1=new TreeNode(6);
        TreeNode t2=new TreeNode(10);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(7);
        TreeNode t5=new TreeNode(9);
        TreeNode t6=new TreeNode(11);
        root.left=t1;
        t1.left=t3;
        t1.right=t4;
        root.right=t2;
        t2.left=t5;
        t2.right=t6;
        Mirror(root);

        int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(m);

    }


    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;

            Mirror(root.left);
            Mirror(root.right);
        }
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int row=matrix.length;
        int col=matrix[0].length;
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[i].length;j++){
//                col++;
//            }
//            break;
//        }
        System.out.println(col);
        int sum=row*col;
        int[][] record=new int[row][col];

        int count=0;
        int i=0,j=0;
        while(count<sum){
            //向右
            while(j<col&&record[i][j]==0){
                list.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
                record[i][j]=1;
                count++;
                j++;
            }
            j--;
            //向下
            i++;
            while(i<row&&record[i][j]==0){
                list.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
                record[i][j]=1;
                count++;
                i++;
            }
            i--;
            //向左
            j--;
            while(j>=0&&record[i][j]==0){
                list.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
                record[i][j]=1;
                count++;
                j--;
            }
            j++;
            //向上
            i--;
            while(i>=0&&record[i][j]==0){
                list.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
                record[i][j]=1;
                count++;
                i--;
            }
            i++;
            j++;
        }
        return list;
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}