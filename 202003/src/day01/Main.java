package day01;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        System.out.println(printListFromTailToHead(l1));


        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * @param pre
     * @param in
     * @return
     */

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        int len = pre.length;
        if (len == 1) {
            return root;
        }
        int i;
        for (i = 0; i < len; i++) {
            if (in[i] == root.val) {
                break;
            }
        }

        if (i > 0) {
            int[] pr = new int[i];
            int[] ino = new int[i];
            for (int j = 0; j < i; j++) {
                pr[j] = pre[j + 1];
                ino[j] = in[j];
            }
            root.left = reConstructBinaryTree(pr, ino);
        } else {
            root.left = null;
        }

        if (len - 1 - i > 0) {
            int[] pr = new int[len - 1 - i];
            int[] ino = new int[len - 1 - i];
            for (int j = i + 1; j < len; j++) {
                pr[j - i - 1] = pre[j];
                ino[j - i - 1] = in[j];
            }
            root.right = reConstructBinaryTree(pr, ino);
        } else {
            root.right = null;
        }
        return root;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> lists = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        if (listNode == null) {
            return lists;
        }
        while (true) {
            s.push(listNode.val);
            listNode = listNode.next;
            if (listNode == null) {
                break;
            }
        }
        while (s.size() > 0) {
            lists.add(s.pop());
        }
        return lists;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}
