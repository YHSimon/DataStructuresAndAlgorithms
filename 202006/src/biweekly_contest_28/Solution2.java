package biweekly_contest_28;

import java.util.*;

public class Solution2 {
    public int minSumOfLengths2(int[] arr, int target) {
        //记录前缀和出现的最后一个下标
        Map<Integer,Integer> map=new HashMap<>();
        int t=0;
        int ans=Integer.MAX_VALUE;
        Vector<Integer> m_f;
        int mi=0;
        map.put(0, -1);
        return 0;
    }
    public int minSumOfLengths(int[] arr, int target) {
        int ans=0;
        int len=arr.length;
        boolean[] visited=new boolean[len];
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(arr);
        for(int num:arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int i=0;
        while(arr[i]<=target) i++;

        int tmp=target;
        List<Integer>  indexes=new ArrayList<>();
        int count=0;
        while(count<=2){
            boolean flag=false;
            for(int j=i;j>=0&&visited[j];j--){
                tmp=target-arr[j];
                visited[j]=true;
                if(tmp==0){
                    flag=true;
                    indexes.add(j);
                }else if(tmp>0){
                    indexes.add(j);
                }else{
                    for(int index:indexes){
                        visited[index]=false;
                    }
                    break;
                }
            }
            if(flag){
                ans+=indexes.size();
                indexes.clear();
                count++;
            }
        }
        return ans;
    }
}
