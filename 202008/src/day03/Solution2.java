package day03;

public class Solution2 {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root){
        TreeNode ans=new TreeNode(-1);
        cur=ans;
        inOrder(root);
        return ans.right;
    }
    public void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        node.left=null;
        cur.right=node;
        cur=node;
        inOrder(node.right);
    }
}
