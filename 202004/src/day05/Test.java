package day05;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.right = t5;
        root.infixOrder(root);

        Test t = new Test();
        t.Convert(root);
        System.out.println(t.Sum_Solution(5));

        t.Permutation2("abbc");
    }

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int Sum_Solution(int n) {
        int res = n;
        boolean flag = (n > 0) && ((res += Sum_Solution(n - 1)) > 0);
        return res;
    }

    /**
     * 方法二  递归
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * <p>
     * 固定第一个字符，递归取得首位后面的各种字符串组合；
     * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
     * 递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
     */
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) return list;
        PermutationHelper(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j = i, len = chars.length; j < len; j++) {
                //固定第一个字符，递归取得收尾后面的各种字符串的组合
                if (j == i || !set.contains(chars[j])) {
                    set.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);//返回递归前的状态
                }
            }
        }
    }

    /**
     * 方法一 字典排序法  理解
     * <p>
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */
    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) return list;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while (true) {
            int lIndex = len - 1;
            int rIndex;
            while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex]) {
                lIndex--;
            }
            if (lIndex == 0) {
                break;
            }
            rIndex = lIndex;
            while (rIndex < len && chars[rIndex] > chars[lIndex - 1]) {
                rIndex++;
            }
            swap(chars, lIndex - 1, rIndex - 1);
            reverse(chars, lIndex);

            list.add(String.valueOf(chars));
        }
        return list;
    }

    private void reverse(char[] chars, int k) {
        if (chars == null || chars.length <= k) return;
        int len = chars.length;
        for (int i = 0; i < (len - k) / 2; i++) {
            int m = k + i;
            int n = len - 1 - i;
            if (m < n) {
                swap(chars, m, n);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */

    /**
     * 方法二  直接中序遍历
     */
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode root) {
        ConvertSub(root);
        return realHead;
    }

    private void ConvertSub(TreeNode root) {
        if (root == null) return;
        ConvertSub(root.left);
        if (head == null) {
            head = root;
            realHead = root;
        } else {
            head.right = root;
            root.left = head;
            head = root;
        }
        ConvertSub(root.right);
    }

    /**
     * 方法一

     public TreeNode Convert(TreeNode root) {
     if(root==null) return null;
     ArrayList<TreeNode> list=new ArrayList<>();
     Convert(list,root);
     return Convert(list);
     }


     public void Convert(ArrayList<TreeNode> list,TreeNode root){
     if(root!=null){
     Convert(list,root.left);
     list.add(root);
     Convert(list,root.right);
     }
     }

     public TreeNode Convert(ArrayList<TreeNode> list) {
     TreeNode head=list.get(0);
     TreeNode cur=head;
     for(int i=1,len=list.size();i<len;i++){
     TreeNode node=list.get(i);
     node.left=cur;
     cur.right=node;
     cur=node;
     }
     return head;
     }
     **/

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public void infixOrder(TreeNode node) {
        if (node != null) {
            infixOrder(node.left);
            System.out.print(node.val + " ");
            infixOrder(node.right);
        }
    }
}