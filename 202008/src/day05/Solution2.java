package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * n叉树的最大深度
 */
public class Solution2 {
    public int maxDepth(Node root) {
        if(root ==null) return 0;
        else if(root.children.isEmpty()) return 1;
        else{
            List<Integer> heights=new ArrayList<>();
            for(Node node:root.children){
                heights.add(maxDepth(node));
            }
            return Collections.max(heights)+1;
        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};