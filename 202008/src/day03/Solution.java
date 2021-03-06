package day03;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode ans=new TreeNode(-1),cur=ans;
        for(Integer v:list){
            cur.right=new TreeNode(v);
            cur=cur.right;
        }
        return ans.right;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}