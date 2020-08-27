package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403 非递增顺序的最小子序列
 * <p>
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * <p>
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 */
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum=0,len=nums.length;
        for(int num:nums){
            sum+=num;
        }

        List<Integer> list=new ArrayList<>();
        int tmp=0;
        for(int i=len-1;i>=0;i--){
            tmp+=nums[i];
            list.add(nums[i]);

//            if(tmp>sum-nums[i]){
//                return list;
//            }
//            sum-=nums[i];

            //优化
            if(tmp>sum/2){
                return list;
            }
        }
        return list;
    }
}
