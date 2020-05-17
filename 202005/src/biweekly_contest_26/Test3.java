package biweekly_contest_26;

/**
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 t=new Test3();
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(1);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(1);
        TreeNode n6=new TreeNode(5);

        n1.left=n2;n1.right=n3;
        n2.left=n4;
        n3.left=n5;n3.right=n6;
        System.out.println(t.goodNodes(n1));
    }


    int ans = 0;
    public int goodNodes2(TreeNode root){
        dfs2(root,Integer.MIN_VALUE);
        return ans;
    }
    public void dfs2(TreeNode root,int cur_max){
        if(root==null) return;
        cur_max=Math.max(cur_max, root.val);
        if(root.val==cur_max) ans++;
        dfs2(root.left, cur_max);
        dfs2(root.right, cur_max);
    }

    /**
      *  2ms
      */
    public int goodNodes(TreeNode root) {
        int max=root.val;
        TreeNode pre=root;
        dfs(root, max,pre,root);
        return ans;
    }

    public void dfs(TreeNode node,int max,TreeNode pre,TreeNode root){
        max=Math.max(node.val,max);
        if(node.val==max){
            ans++;
        }
        if(node.left!=null){
            pre=node;
            if(pre==root) max=root.val;
            dfs(node.left,max,pre,root);
        }
        if(node.right!=null){
            pre=node;
            if(pre==root) max=root.val;
            dfs(node.right, max,pre,root);
        }
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
        return String.valueOf(val);
    }
}