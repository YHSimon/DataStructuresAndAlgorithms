package day06;

public class Solution {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;
        n4.left=n6;n4.right=n7;

        Solution s=new Solution();
        s.isBalanced(n1);

    }
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(Math.abs(left-right)>1){
            flag=false;
        }
        //返回本结点所在树的深度
        return Math.max(left, right)+1;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}