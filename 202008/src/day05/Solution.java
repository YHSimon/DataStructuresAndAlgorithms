package day05;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        dfs(root1, l1);
        List<Integer> l2=new ArrayList<>();
        dfs(root2, l2);
//        if(l1.size()!=l2.size()) return false;
//        for(int i=0;i<l1.size();i++){
//            if(!l1.get(i).equals(l2.get(i))){
//                return false;
//            }
//        }
//        return true;
        return l1.equals(l2);
    }
    public void dfs(TreeNode node,List<Integer> list){
        if(node==null) return;
        if(node.left==null&&node.right==null) list.add(node.val);
        dfs(node.left, list);
        dfs(node.right,list);
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