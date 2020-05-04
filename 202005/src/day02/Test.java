package day02;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.maxSubArray(new int[]{4,-1,2,1}));
    }

    /**
     * 优化
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums){
        int len=nums.length;
        if(len==0) return 0;
        int max=nums[0];
        int subMax=nums[0];
        for(int i=1;i<len;i++){
            if(subMax>=0){
                subMax=subMax+nums[i];
            }else{
                subMax=nums[i];
            }
            max=Math.max(max, subMax);
        }
        return max;
    }

    /**
     * 动态规划
     * 1ms   O(n)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums){
        int len=nums.length;
        if(len==0) return 0;
        int[] dps=new int[len];
        dps[0]=nums[0];
        for(int i=1;i<len;i++){
            if(dps[i-1]>=0){
                dps[i]=dps[i-1]+nums[i];
            }else{
                dps[i]=nums[i];
            }
        }

        int ans=dps[0];
        for(int dp:dps){
            ans=Math.max(ans, dp);
        }
        return ans;
    }

    /**
     * 双for O(n^2) 160ms
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans=nums[0],len=nums.length;
        for(int i=0;i<len;i++){
            int sum=nums[i];
            ans=Math.max(ans, sum);
            for(int j=i+1;j<len;j++){
                sum+=nums[j];
                ans=Math.max(ans, sum);
            }
        }
        return  ans;
    }

}
