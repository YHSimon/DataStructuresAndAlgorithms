package day08;

/**
 * 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return helper(root)!=-1;
    }
    public int helper(TreeNode node){
        if(node==null) return 0;
        int left=helper(node.left);
        if(left==-1) return -1;
        int right=helper(node.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

