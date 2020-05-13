package day10;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历  DFS (递归)
 */
public class Test2 {
    /**
     *1ms DFS
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root!=null){
            dfs(ans,root,0);
        }

        return ans;
    }

    public void dfs(List<List<Integer>> ans,TreeNode node,int level){
        if(ans.size()-1<level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        if(node.left!=null){
            dfs(ans,node.left,level+1);
        }
        if(node.right!=null){
            dfs(ans,node.right,level+1);
        }
    }
}
