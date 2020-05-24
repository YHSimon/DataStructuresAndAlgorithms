package path;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathDemo {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n6;

        List<Integer> path = new ArrayList<>();
        getPathToNode(n1, path, 3);
        System.out.println(path);

    }


    //记录根节点到叶子结点的所有路径
    public static void getPath(TreeNode node, List<String> paths, String s) {
        if (node.left == null && node.right == null) { //叶子结点
            paths.add(s);
            return;
        }
        if (node.left != null) {
            getPath(node.left, paths, s);
        }
        if (node.right != null) {
            getPath(node.right, paths, s);
        }
    }

    //寻找根节点到某一特定子节点路径
    public static boolean getPathToNode(TreeNode node, List<Integer> path, int target) {
        path.add(node.val);
        if (node.val == target) return true;
        boolean flag = false;
        if (node.left != null) {
            flag = getPathToNode(node.left, path, target);
        }
        if (!flag&&node.right != null) {
            flag = getPathToNode(node.right, path, target);
        }
        if (!flag) path.remove(path.size() - 1);//当前节点及其子树 都未找到target 需要在返回父节点之前，在路径上删除当前节点
        return flag;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}