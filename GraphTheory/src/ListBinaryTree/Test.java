package ListBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(9);
        TreeNode n9 = new TreeNode(10);

        root.left = n1;
        root.right = n5;
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n5.right = n6;
        n6.left = n7;
        n7.left = n8;
        n7.right = n9;

        Test t = new Test();
        System.out.println("DFS遍历二叉树：");
        t.dfs(root);
        System.out.println();
        System.out.println("BFS遍历二叉树：");
        t.bfs(root);

    }

    /**
     * dfs遍历二叉树
     * 递归
     */
    public void dfs(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        dfs(node.left);
        dfs(node.right);
    }

    /**
     * bfs遍历二叉树
     * 队列
     */
    public void bfs(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.val+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
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