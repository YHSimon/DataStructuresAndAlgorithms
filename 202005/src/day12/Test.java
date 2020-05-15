package day12;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class Test {
    /**
     * 22ms
     * 前缀和  哈希表优化
     */
    public int subarraySum2(int[] nums,int k){
        int count=0,pre=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }

    /**
     *  375ms
     *  暴力题解
     */
    public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int ans=0;
        for(int i=0;i<len;i++){
            int sum=nums[i];
            if(sum==k){
                ans++;
            }
            for(int j=i+1;j<len;j++){
                sum+=nums[j];
                if(sum==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
