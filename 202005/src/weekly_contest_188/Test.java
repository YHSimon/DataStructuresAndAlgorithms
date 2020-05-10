package weekly_contest_188;

import java.util.ArrayList;
import java.util.List;

/**
 * 5405
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *      a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 *      b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
//        int[] arr={2,3,1,6,7};
        int[] arr={1,1,1,1,1};
        System.out.println(t.countTriplets3(arr));
    }

    /**
     *确定 i k 的位置  在符合 a^b==0的前提下  统计j的可能值，该值为k-i;
     */
    public int countTriplets3(int[] arr){
        if(arr==null||arr.length==0) return 0;
        int ans=0,len=arr.length;
        for(int i=0;i<len;i++){
            int sum=arr[i];
            for(int k=i+1;k<len;k++){
                sum^=arr[k];
                if(sum==0){
                    ans+=k-i;
                }
            }
        }
        return  ans;
    }
    /**
     *  优化
     * 24ms  O(n^3)
     */
    public int countTriplets2(int[] arr) {
        if(arr==null||arr.length==0) return 0;
        int ans=0;
        int len=arr.length;
        for(int i=0;i<len;i++){
            int a=arr[i];
            for(int j=i+1;j<len;j++){
                int b=0;
                for(int k=j;k<len;k++){
                    b^=arr[k];
                    if(a==b){
                        ans++;
                    }
                }
                a^=arr[j];
            }
        }
        return  ans;
    }

    /**
     * 暴力解题
     * 超时 O(n^4)
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        if(arr==null||arr.length==0) return 0;
        int ans=0;
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j;k<len;k++){
                    int a=0,b=0;
                    for(int p=i;p<j;p++){
                        a^=arr[p];
                    }
                    for(int q=j;q<=k;q++){
                        b^=arr[q];
                    }
                    if(a==b){
                        System.out.println("i="+i+"j="+j+"k="+k);
                        ans++;
                    }
                }
            }
        }
        return  ans;
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list=new ArrayList<>();
        int len=target.length;
        int count=0;
        for(int i=1;i<=n;i++){
            if(count==len){
                break;
            }
            if(i==target[count]){
                list.add("Push");
                count++;
            }else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}
