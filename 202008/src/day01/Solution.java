package day01;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个二叉树，检查它是否是镜像对称的。
 *
 *  192/195
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(2);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(3);
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;
        n3.left=n6;n3.right=n7;
        Solution s=new Solution();
        System.out.println(s.isSymmetric(n1));
    }
    public boolean isSymmetric(TreeNode root) {

        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        List<Integer> list=new ArrayList<>();
        inOrder(root, list);
        for(int i=0;i<list.size()/2;i++){
            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }
        return true;
    }
    public void inOrder(TreeNode node,List<Integer> list){
        if(node!=null) {
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}