package weekly_contest_192;

import java.util.*;

/**
 * 5429.数组中的k个最强值
 *
 * 给你一个整数数组 arr 和一个整数 k 。
 *
 * 设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
 *
 *   |arr[i] - m| > |arr[j] - m|
 *   |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
 * 请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
 *
 * 中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) / 2) 的元素。
 *
 *  提示：
 *     1 <= arr.length <= 10^5
 *    -10^5 <= arr[i] <= 10^5
 *    1 <= k <= arr.length
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getStrongest2(new int[]{1,2,3,4,5}, 2)));
    }

    //45ms
    public static int[] getStrongest2(int[] arr,int k){
        if(arr.length<=1||k>arr.length) return arr;
        Arrays.sort(arr);
        int mid=arr[(arr.length-1)/2];
        int l=0,r=arr.length-1,count=0;
        int[] ans=new int[k];
        while (count<k){
            if(Math.abs(arr[r]-mid)>=Math.abs(arr[l]-mid)){
                ans[count++]=arr[r];
                r--;
            }else{
                ans[count++]=arr[l];
                l++;
            }
        }
        return ans;
    }

    //200ms
    public static int[] getStrongest(int[] arr, int k) {
        int len=arr.length;
        int[] ans=new int[k];
        Arrays.sort(arr);
        int mid=arr[(len-1)/2];
        Map<Integer,List<Integer>> map= new TreeMap<>();
        for(int num:arr){
            int tmp=Math.abs(num-mid);
            if(map.containsKey(tmp)){
                map.get(tmp).add(num);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(num);
                map.put(tmp, list);
            }
        }
        map=((TreeMap)map).descendingMap();
        System.out.println(map.toString());
        int count=0;
        boolean flag=false;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            List<Integer> list=entry.getValue();
            Collections.sort(list);
            for(int i=list.size()-1;i>=0;i--){
                if (count == k) {
                    flag=true;
                    break;
                }
                ans[count++]=list.get(i);
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
