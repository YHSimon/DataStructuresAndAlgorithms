package biweekly_contest_28;

public class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<prices[i]){
                    ans[i]=prices[i]-prices[j];
                    break;
                }
                if(j==prices.length-1&&prices[j]>=prices[i]){
                    ans[i]=prices[i];
                    break;
                }
            }
        }
        return ans;
    }
}
