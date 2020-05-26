package day19;

import java.util.HashMap;
import java.util.Map;

/**
 * 287 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 *
 *  1.不能更改原数组（假设数组是只读的）。
 *  2. 只能使用额外的 O(1) 的空间。
 *  3. 时间复杂度小于 O(n2) 。
 *  4. 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Test {
    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }


    /**
     * 快慢指针 (Floyd判圈算法（龟兔赛跑算法）)
     *
     * 0ms ....
     */
    public int findDuplicate4(int[] nums){
        int slow=0,fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
           slow=0;
           while(slow!=fast){
               slow=nums[slow];
               fast=nums[fast];
           }
       return slow;
    }

    /**
     * 2ms  但不满足要求 1
     *
     * 非重复的数字只会改一次正数变成负数，之后就不会访问了，
     * 重复的数字会在第二次索引看到之前变为负数的值
     */
    public int findDuplicate3(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])]<0) return Math.abs(nums[i]);
            nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
        }
        return -1;
    }

    /**
     * 二分法  抽屉原理 （用时间换空间）
     */
    public int findDuplicate2(int[] nums){
        int len=nums.length;
        int left=1;
        int right=len-1;
        while(left<right){
            int mid=(left+right)>>>1;
            int cnt=0;
            for(int num:nums){
                if(num<=mid){
                    cnt++;
                }
            }

            if(cnt>mid){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    /**
     * 使用HashMap   2ms  但不能满足 要求2
     */
    public static int findDuplicate(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return ans;
    }
}
