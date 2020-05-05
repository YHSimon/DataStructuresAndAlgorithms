package day03;

/**
 *给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        TreeNode root=new TreeNode(10);
        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(15);
        TreeNode n3=new TreeNode(6);
        TreeNode n4=new TreeNode(10);
        root.left=n1;
        root.right=n2;
        n2.left=n3;
        n2.right=n4;
        System.out.println(t.isValidBST(root));
    }

    /**
     * 优解  中序遍历
     * @param root
     * @return
     */
    long pre=Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root){
        if(root==null){
            return  true;
        }
        //访问左子树
        if (!isValidBST2(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if(root.val<=pre){
            return false;
        }
        pre=root.val;

        //访问右子树
        return isValidBST2(root.right);
    }

    /**
     *
     */
    public boolean isValidBST(TreeNode root) {
        boolean ans =true;
        if(root==null) return true;
        if (root.left == null && root.right == null) return true;

        if(root.left!=null){
            if(root.left.val>=root.val) return false;
            ans=isLeftSubValid(root.left,root);
        }
        if(root.right!=null){
            if(root.right.val<=root.val) return false;
            ans=isRightSubValid(root.right,root);
        }
        return ans;
    }

    public boolean isLeftSubValid(TreeNode node,TreeNode pre){
        if(node.left!=null){
            if(node.left.val>=node.val||(node!=pre&&node.left.val>=pre.val)){
                return false;
            }
            pre=node;
           isLeftSubValid(node.left,pre);
        }
        if(node.right!=null){
            if(node.right.val<=node.val||(node!=pre&&node.right.val>=pre.val)){
                return false;
            }
            pre=node;
            isLeftSubValid(node.right,pre);
        }
        return true;
    }

    public boolean isRightSubValid(TreeNode node,TreeNode pre){
        if(node.left!=null){
            if(node.left.val>=node.val||(node!=pre&&node.left.val<=pre.val)){
                return false;
            }
            pre=node;
            isRightSubValid(node.left,pre);
        }
        if(node.right!=null){
            if(node.right.val<=node.val||(node!=pre&&node.right.val<=pre.val)){
                return false;
            }
            pre=node;
            isRightSubValid(node.right,pre);
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
}