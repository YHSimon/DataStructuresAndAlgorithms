package weekly_contest_190;

import java.util.ArrayList;
import java.util.List;


/**5418.二叉树中的伪回文路径
 *
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，
 * 当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 *  
 */
public class Test3 {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(1);
        TreeNode n3=new TreeNode(1);
        TreeNode n4=new TreeNode(1);
        TreeNode n5=new TreeNode(3);
        TreeNode n6=new TreeNode(1);

        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;
        n5.right=n6;
        Test3 t=new Test3();
        t.pseudoPalindromicPaths(n1);
        System.out.println(t.pseudoPalindromicPaths(n1));
    }


    /**
     * 优化
     * 通过位运算 判定是否为 伪回文路径
     * 2ms
     */
    private int count;
    public int pseudoPalindromicPaths2(TreeNode root){
        count=0;
        if(root==null) return count;
        dfs(root,0);
        return count;
    }

    private void dfs(TreeNode node, int v) {
        v^=(1<<node.val);//node节点的val为几就左移几位
        if(node.left==null&&node.right==null){
            if(v==0||(v&(v-1))==0){//判断是否为回文
                count++;
            }
            return;
        }
        if(node.left!=null){
            dfs(node.left, v);
        }
        if(node.right!=null){
            dfs(node.right, v);
        }
    }

    /**方法一
     *
     * 53ms
     *
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        List<String> paths=new ArrayList<>();
        int ans=0;
        getPath(root,paths,root.val+"");

        for(String path:paths){
            if(check(path)){
                ans++;
            }
        }
        return ans;
    }

    public boolean check(String path){
        int[] counts=new int[10];
        boolean flag=true;
        int len=path.length();
        for(char c:path.toCharArray()){
            counts[c-'0']+=1;
        }
        //长度为偶数
        if(len%2==0){
            for(int i=1;i<=9;i++){
                if(counts[i]%2!=0){
                    flag=false;
                    break;
                }
            }
        }else{
            int oddCount=0;
            for(int i=1;i<=9;i++){
                if(oddCount>1){
                    flag=false;
                    break;
                }
                if(counts[i]%2==1){
                    oddCount++;
                }
            }
        }
        return flag;
    }

    public void getPath(TreeNode node,List<String> paths,String s) {
       if(node.left==null&&node.right==null){
           paths.add(s);
           return;
       }
       if(node.left!=null){
           getPath(node.left, paths, s+node.left.val);
       }
       if(node.right!=null){
           getPath(node.right, paths, s+node.right.val);
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
}