package day01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 迭代方式
 * 1ms
 */
public class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode u,TreeNode v){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(u);
        queue.add(v);
        while(!queue.isEmpty()){
            u=queue.poll();
            v=queue.poll();
            if(u==null&&v==null){
                continue;
            }
            if((u==null||v==null)||(u.val!=v.val)){
                return false;
            }
            queue.add(u.left);
            queue.add(v.right);

            queue.add(u.right);
            queue.add(v.left);
        }
        return true;
    }
}
