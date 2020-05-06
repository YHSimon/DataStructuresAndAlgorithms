package day04;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 */
public class Test {
    /**
     * 1ms
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len=days.length,maxDay=days[len-1],minDay=days[0];
        int[] dp=new int[maxDay+31];
        //i表示days的索引
        //只考虑[minDay,MaxDay],此区间外都不需要出门
        for(int d=maxDay,i=len-1;d>=minDay;d--){
            if(d==days[i]){
                dp[d]=Math.min(dp[d+1]+costs[0],dp[d+7]+costs[1]);
                dp[d]=Math.min(dp[d+30]+costs[2],dp[d]);
                i--;
            }else{
                //不需要出门
                dp[d]=dp[d+1];
            }
        }
        return dp[minDay];
    }
}
