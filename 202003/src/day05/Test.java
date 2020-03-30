package day05;

/**
 * 递归理解得不够透彻
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        Test test = new Test();
        System.out.println(test.HasSubtree(root, t1));
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

//        preList(root1);
//        char[] r1 =stringBuilder.toString().toCharArray();
//        stringBuilder.setLength(0);
//        preList(root2);
//        char[] r2=stringBuilder.toString().toCharArray();
//        int l1=r1.length;
//        int l2=r2.length;
//        if(l2>l1){
//            return  false;
//        }
//        int index=0;
//        for(int i=0;i<l1;i++){
//            if(r1[i]==r2[0]){
//                index=i;
//                int count=0;
//                for(int j=0;j<l2;j++){
//                    int index2=j;
//                    while(index<l1&&index2<l2&&r1[index++]==r2[index2++]){
//                        count++;
//                    }
//                }
//                if(count==l2){
//                    System.out.println("---"+count);
//                    return true;
//                }
//            }
//        }
        boolean flag = false;
        if (root2 != null && root1 != null) {
            //若找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为起点判断是否包含Tree2
                flag = isSubTree(root1, root2);
            }
            if (!flag) {
                //若找不到，那么就从root的左节点当做起点，去判断是否包含Tree2
                flag = isSubTree(root1.left, root2);
            }

            if (!flag) {
                //若依旧找不到，那么就从root的右节点当做起点，去判断是否包含Tree2
                flag = isSubTree(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了 都能匹配得到，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没遍历完 ，Tree1已经遍历完了，返回false
        if (node1 == null) {
            return false;
        }
        //如果有一个点不相等，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上 ，那么分别去子节点里进行比较
        return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }


}