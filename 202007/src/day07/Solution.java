package day07;

/**
 * 108.将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=(left+right)/2;
        TreeNode root =new TreeNode(nums[mid]);
        root.left=helper(nums, left, mid-1);
        root.right=helper(nums, mid+1, right);
        return root;
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