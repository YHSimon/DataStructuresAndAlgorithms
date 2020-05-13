package day10;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层序遍历
 * BFS （队列）
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.left = n1;
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
//        TreeNode root = new TreeNode(3);
//        TreeNode n1 = new TreeNode(9);
//        TreeNode n2 = new TreeNode(20);
//        TreeNode n3 = new TreeNode(15);
//        TreeNode n4 = new TreeNode(7);
//        TreeNode n5 = new TreeNode(1);
//        TreeNode n6 = new TreeNode(2);
//        root.left = n1;
//        root.right = n2;
//        n1.left = n5;
//        n1.right = n6;
//        n2.left = n3;
//        n2.right = n4;
        System.out.println(t.levelOrder(root).toString());
    }


    /**
     * BFS
     * 1ms
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int flag = queue.size();
            for (int i = 0; i < flag; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) {
                    temp.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}