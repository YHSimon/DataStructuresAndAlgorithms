package day05;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树。
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(0);

        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t4.left = t5;
        System.out.println(t.isSubtree2(root, n1));
    }

    /**
     * 7ms
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree3(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSame(s, t) || isSubtree3(s.left, t) || isSubtree3(s.right, t);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) {
            return true;
        } else {
            return isSubtree2(s.left, t) || isSubtree2(s.right, t);
        }
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        if (q.val != p.val) {
            return false;
        } else {
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean ans = true;
        if (t == null || s == null) return false;
        if (s.val == t.val) {
            ans = isValid(s, t);
            if (!ans) return false;
        }

        if (s.left != null) {
            isSubtree(s.left, t);
        }
        if (s.right != null) {
            isSubtree(s.left, t);
        }
        return ans;
    }

    public boolean isValid(TreeNode s, TreeNode t) {
        if (s == null && t != null || (s != null && t == null)) return false;
        if (s.val != t.val) {
            return false;
        }
        if (t.left != null) {
            isValid(s.left, t.left);
        }
        if (t.right != null) {
            isValid(s.right, t.right);
        }
        return true;
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
        return this.val + "";
    }
}