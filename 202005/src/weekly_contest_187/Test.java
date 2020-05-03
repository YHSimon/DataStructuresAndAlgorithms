package weekly_contest_187;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        int[] nums = new int[]{10,1,2,4,7,2};
        System.out.println(t.longestSubarray3(nums, 5));
//        System.out.println(t.kLennugthApart(m, 1));
    }

    public int longestSubarray3(int[] nums, int limit) {
        int ans = 0;
        int len = nums.length;
        int subMax = 0;
        int min=nums[0];
        int max=min;
        for (int start = 0, end = 0; start < len && end < len; end++) {
            min = Math.min(min,nums[end]);
            max = Math.max(max,nums[end]);
            subMax = Math.max(subMax, max - min);
            if (subMax > limit) {
                ans = Math.max(ans, end - start);
                start++;
                //新起点
                end=start;
                end--;
                min=max=nums[start];
                subMax=0;
            }else{
                ans=Math.max(ans, end-start+1);
            }
        }
        return ans;
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray2(int[] nums, int limit) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            int subMax = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                subMax = Math.max(subMax, max - min);
                if (subMax <= limit) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    break;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    /**
     * 绝对差不超过限制的最长连续子数组
     * <p>
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
     * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     * 如果不存在满足条件的子数组，则返回 0 。
     * <p>
     *  
     * 53/54  超出内存时间限制
     *
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            int subMax = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                subMax = Math.max(subMax, max - min);
                if (subMax <= limit) {
                    count++;
                } else {
                    list.add(count);
                    break;
                }
                list.add(count);
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    /**
     * 1 <= nums.length <= 10^5
     * 0 <= k <= nums.length
     * nums[i] 的值为 0 或 1
     *
     *  1ms
     */
    public boolean kLennugthApart2(int[] nums,int k){
        int len=nums.length;
        for(int pre=-100000,next=0;next<len;next++){
            if(nums[next]==1){
                if(next-pre-1<k){
                    return false;
                }
                pre=next;
            }
        }
        return true;
    }

    /**
     * 5401  是否所有1都至少相隔k个元素
     *
     * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。
     * 如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
     * @param nums
     * @param k
     * @return
     *
     *  18ms
     */
    public boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int min = 0;
        int c1 = 0;
        List<Integer> list = new ArrayList<>();
        count = nums[0] == 1 ? 0 : 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                count += 1;
            } else {
                c1++;
                list.add(count);
                count = 0;
            }
        }
        if ((nums[0] == 1 && c1 == 1)) {
            return true;
        }
        if (c1 == 0) {
            return true;
        }
        Collections.sort(list);
        min = list.get(0);
        return min == k;
    }


    /**
     * 5400 旅行终点站
     *
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        String start = paths.get(0).get(0);
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String ans = map.get(start);
        while (true) {
            if (map.containsKey(ans)) {
                start = ans;
                ans = map.get(start);
            } else {
                return ans;
            }
        }
    }
}
