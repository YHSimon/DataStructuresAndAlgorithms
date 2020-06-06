package day04;

import java.util.*;

/**
 * 128.最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}));
    }


    //2ms
    public static int longestConsecutive2(int[] nums){
        int max=0;
        if(nums==null||nums.length==0) return max;
        Arrays.sort(nums);
        int curLen=1;max=1;
        for(int i=1,len=nums.length;i<len;i++){
            if(nums[i]-nums[i-1]==1){
                curLen++;
            }else if(nums[i]==nums[i-1]){
                continue;
            }else{
                max=Math.max(max,curLen);
                curLen=1;
            }
        }
        return Math.max(max, curLen);
    }

    /**
     * 5ms
     *
     * 若Set的实现类改成LinkedHashSet(保证插入顺序 和遍历取出顺序一致)  7ms
     */
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        if (nums.length == 1) return 1;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int[] nums2=new int[set.size()];
        int count=0;
        for(int num:set){
            nums2[count++]=num;
        }
        if(nums2.length==1) return 1;
        Arrays.sort(nums2);
        int len = nums2.length, start = 0, end = 1;
        while (end < len) {
            if (start == end) {
                ans = Math.max(ans, 1);
            } else {
                if(nums2[end]-nums2[end-1]!=1){
                    ans = Math.max(ans, end - start);
                    start = end;
                    ans = Math.max(ans, 1);
                }else{
                    ans=Math.max(ans, end-start+1);
                }
            }
            end++;
        }
        return ans;
    }
}
