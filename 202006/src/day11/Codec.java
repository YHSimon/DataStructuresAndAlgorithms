package day11;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        StringBuilder str=new StringBuilder("[");
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                str.append("null,");
            }else{
                str.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        str.setLength(str.length()-1);
        str.append("]");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.substring(1,data.length()-1).split(",");
        TreeNode root=reverseTreeNode(nodes[0]);
        Queue<TreeNode> parents=new LinkedList<>();
        TreeNode parent=root;
        boolean isLeft=true;
        for(int i=1;i<nodes.length;i++){
            TreeNode cur=reverseTreeNode(nodes[i]);
            if(isLeft){
                parent.left=cur;
            }else{
                parent.right=cur;
            }
            if(cur!=null){
                parents.add(cur);
            }
            isLeft=!isLeft;
            if(isLeft){
                parent=parents.poll();
            }
        }
        return root;
    }

    public TreeNode reverseTreeNode(String val){
        if("null".equals(val)){
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }