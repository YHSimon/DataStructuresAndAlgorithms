package weekly_contest_188;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 题目
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 一个节点也可以是它自己的祖先
 */
public class Test2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(4);
        root.left=n1;root.right=n2;
        n1.left=n3;n1.right=n4;
        n4.left=n7;n4.right=n8;
        n2.left=n5;n2.right=n6;


        Test2 t=new Test2();
        System.out.println(t.lowestCommonAncestor2(root, n7, n8).val);
    }
//    static Map<Integer,TreeNode> parent=new HashMap<>();
    //map记录每个节点的父节点
    Map<Integer,TreeNode> parent=new HashMap<>();
    //Set集合记录以访问过的祖先节点
    Set<Integer> visited=new HashSet<>();

    //遍历整棵二叉树，用哈希表记录每个节点的父节点
    public void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    /**
     * 方法一
     * 12ms  31%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p!=null){
            visited.add(p.val);
            p=parent.get(p.val);
        }
        while(q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q=parent.get(q.val);
        }
        return  null;
    }

    /**
     * 递归
     */
    public  TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p,TreeNode q){
        if(root==null||root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor2(root.left, p, q);
        TreeNode right=lowestCommonAncestor2(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
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

    public void prelist(){
        System.out.print(this.val+" ");
        if(this.left!=null){
            this.left.prelist();
        }
        if(this.right!=null){
            this.right.prelist();
        }
    }
    static String flag="";
    public void prelist(int target){
        if(target==this.val){
            System.out.println(flag);
            return;
        }
        if(this.left!=null){
            flag="left";
            this.left.prelist(target);
        }
        if(this.right!=null){
            flag="right";
            this.right.prelist(target);
        }
    }

    public void postlist(){

        if(this.left!=null){
            this.left.postlist();
        }
        if(this.right!=null){
            this.right.postlist();
        }
        System.out.print(this.val+" ");
    }
}