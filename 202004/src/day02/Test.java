package day02;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
//        t1.right=t4;
        t2.left = t5;
        t2.right = t6;
        Test t = new Test();

        TreeNode root1 = null;
        ArrayList<Integer> list = t.PrintFromTopToBottom(root1);
        System.out.println(list);
    }

    /**
     * 学习 用ArrayList模拟一个队列来存储相应的TreeNode
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     */
    static ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        list.clear();
        if (root == null) {
            return list;//尽量不要写成 return null (最好与返回类型一致)
        }
        list.add(root.val);
        f(root);
        return list;
    }

    public static void f(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            list.add(node.left.val);
        }
        if (node.right != null) {
            list.add(node.right.val);
        }
        f(node.left);
        f(node.right);
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