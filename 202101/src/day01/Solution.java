package day01;

/** 239.滑动窗口的最大值
 *  给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *  你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
public class Solution {
    /**
     * 思路
     *  1.从首元素开始确定第一个滑动窗口的最值
     *  2.依次像后移动
     *     若为比最大值还要大，则更新
     *     若最值已不在窗口中，遍历窗口，求得最值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length];
        //ans计数器
        int count=0;int start=0,end=start+k-1;
        //初始化
        int tmp=nums[0];
        for (int i = start; i < k&&i<nums.length; i++) {
            tmp=Math.max(tmp, nums[i]);
        }
        ans[count++]=tmp;
        start++;end++;
        while(start<=nums.length-k&&end<nums.length){
            if(nums[start-1]<tmp&&nums[end]<=tmp){
                ans[count++]=tmp;
            }else if(nums[start-1]<tmp&&nums[end]>tmp){
                tmp=nums[end];
                ans[count++]=tmp;
            }else{
                for(int i=start;i<=end;i++){
                    tmp=Math.max(tmp, nums[i]);
                }
                ans[count++]=tmp;
            }
            start++;end++;
        }
        return ans;
    }
}
