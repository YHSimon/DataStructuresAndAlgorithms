package day02;

/**
 * 翻转二叉树
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return root;
        invert(root.left);
        invert(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        return root;
    }
    public void invert(TreeNode node){
        if(node==null) return;
        if(node.left==null&&node.right==null) return;
        TreeNode tmp=node.left;
        node.left=node.right;
        node.right=tmp;
        invert(node.left);
        invert(node.right);

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}