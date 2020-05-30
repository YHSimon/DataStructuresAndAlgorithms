package day21;

import java.util.HashMap;
import java.util.Map;

/**974 和可被K整除的子数组
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println((-7%2+2)%2);
        System.out.println((-7%10+10)%10);
//        System.out.println(t.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }

    public int subarraysDivByK2(int[] A,int K){
        int ans=0,sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int num:A){
            sum+=num;
            //当被除数为负数时取模结果为负数  需要纠正
            int m=(sum%K+K)%K;
            int same=map.getOrDefault(m, 0);
            ans+=same;
            map.put(m, same+1);
        }
        return ans;
    }

    /**
     * 双for 超时
     */
    public int subarraysDivByK(int[] A, int K) {
        int ans=0;
        int tmp;
        for(int i=0,len=A.length;i<len;i++){
            tmp=A[i];
            if(tmp%K==0){
                ans++;
            }
            for(int j=i+1;j<len;j++){
                tmp+=A[j];
                if((tmp)%K==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
