package day10;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        int[] nums={2,7,11,15};
//        int[] nums={3,2,4};
        int[] nums = {-1, -2, -3, -4,-5};
        System.out.println(Arrays.toString(t.twoSum3(nums, -8)));
    }


    //方法三 一次遍历哈希表  O(n)
    public int[] twoSum3(int [] nums,int target){
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0,len=nums.length;i<len;i++){
            int surplus=target-nums[i];
            if(map.containsKey(surplus)){
                return new int[] {map.get(surplus),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no solution");
    }


    //方法二   O(n)
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        for(int i=0;i<len;i++){
           map.put(nums[i],i);
        }
        for(int i=0;i<len;i++){
            int j=target-nums[i];
            if(map.containsKey(j)&&map.get(j)>i){
                return  new int[] {i,map.get(j)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }


    //时间复杂度 O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] index = new int[2];
        for (int i = 0; i < len; i++) {
            target -= nums[i];
            index[0] = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == target) {
                    index[1] = j;
                    return index;
                }
            }
            target += nums[i];
        }
        return index;
    }
}
