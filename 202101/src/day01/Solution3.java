package day01;

import java.util.LinkedList;

//双向队列
/*
    遍历数组，将 数 存放在双向队列中，并用 L,R 来标记窗口的左边界和右边界。队列中保存的并不是真的 数，而是该数值对应的数组下标位置，
    并且数组中的数要从大到小排序。如果当前遍历的数比队尾的值大，则需要弹出队尾值，直到队列重新满足从大到小的要求。
    刚开始遍历时，L 和 R 都为 0，有一个形成窗口的过程，此过程没有最大值，L 不动，R 向右移。
    当窗口大小形成时，L 和 R 一起向右移，每次移动时，判断队首的值的数组下标是否在 [L,R] 中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。
 */
public class Solution3 {
    public int[] maxSlidingWindow(int[] nums,int k){
        if(nums==null||nums.length<2) return nums;
        //双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值递减
        LinkedList<Integer> queue = new LinkedList<>();





        int[] ans=new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            //保证递减 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            //添加当前值对应的数组下标
            queue.addLast(i);
            //判断当前队列中队首的值是否有效
            if(queue.peek()<=i-k){
                queue.poll();
            }
            //当窗口长度为k时 保存当前窗口中最大值
            if(i+1>=k){
                ans[i+1-k]=nums[queue.peek()];
            }
        }
        return ans;
    }
}
