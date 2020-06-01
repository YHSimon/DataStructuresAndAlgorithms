package weekly_contest_191;

public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.maxProduct(new int[]{1,5,4,5}));
    }
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int len=nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                ans=Math.max(ans, (nums[i]-1)*(nums[j]-1));
            }
        }
        return ans;
    }
}
