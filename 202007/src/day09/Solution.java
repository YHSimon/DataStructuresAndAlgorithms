package day09;

import java.util.LinkedList;
import java.util.Queue;

/**  111.二叉树的最小深度
 *  给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class Solution {
    class QueueNode{
        TreeNode node;
        int dept;

        public QueueNode(TreeNode node,int dept){
            this.node=node;
            this.dept=dept;
        }
    }

    // bfs
    public int minDepth(TreeNode root) {
       if(root==null) return 0;
       Queue<QueueNode> queue=new LinkedList<>();
       queue.add(new QueueNode(root,1));
       while(!queue.isEmpty()){
          QueueNode qNode=queue.poll();
          TreeNode node=qNode.node;
          int dept=qNode.dept;
          if(node.left==null&&node.right==null){
              return dept;
          }
          if(node.left!=null){
              queue.add(new QueueNode(node.left, dept+1));
          }

          if(node.right!=null){
              queue.add(new QueueNode(node.right, dept+1));
          }
       }

       return 0;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}