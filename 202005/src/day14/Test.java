package day14;

/**
 * 152.乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 */
public class Test {
    public static void main(String[] args) {
//        int[] nums={2,3,-2,4};
        int[] nums={-2,3,-4};
        Test t=new Test();
        System.out.println(t.maxProduct2(nums));
    }

    /**
     * 2ms
     * 动态规划
     */
    public int maxProduct2(int[] nums){
        //imax为当前最大值
        int max=Integer.MIN_VALUE,imax=1,imin=1;
        for(int i=0;i<nums.length;i++){
            //若当前遍历值为负数  则imax与imin先交换 再进行计算
            if(nums[i]<0){
                int tmp=imax;
                imax=imin;
                imin=tmp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(max, imax);
        }
        return max;
    }
    /**
     * 120ms
     */
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int mult=1;
            for(int j=i;j<nums.length;j++){
                mult*=nums[j];
                ans=Math.max(ans, mult);
            }
        }
        return ans;
    }
}
