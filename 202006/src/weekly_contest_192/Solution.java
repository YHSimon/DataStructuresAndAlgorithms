package weekly_contest_192;

import java.util.Arrays;

/**5428 重新排列数组
 *
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 * 提示
 *  1 <= n <= 500
 *  nums.length == 2n
 *  1 <= nums[i] <= 10^3
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle2(new int[]{1,2,3,4,5,6}, 3)));
    }

    //优化  0ms
    public static int[] shuffle2(int[] nums, int n) {
        if(nums==null||nums.length==0) return new int[0];
        int[] ans=new int[nums.length];
        for(int i=0,left=0,right=n;i<nums.length;i+=2,left++,right++){
            ans[i]=nums[left];
            ans[i+1]=nums[right];
        }
        return ans;
    }

    public int[] shuffle(int[] nums, int n) {
        if(nums==null||nums.length==0) return new int[0];
        int[] ans=new int[nums.length];
        int[] tmp=new int[n];int count=0;
        for(int i=n;i<nums.length;i++){
            tmp[count++]=nums[i];
        }
        for(int i=0,j=0;i<nums.length;i+=2,j++){
                ans[i]=nums[j];
                ans[i+1]=tmp[j];

        }
        return ans;
    }
}
