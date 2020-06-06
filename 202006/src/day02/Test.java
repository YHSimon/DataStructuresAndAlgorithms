package day02;

import java.util.HashMap;
import java.util.Map;

/**238.除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 */
public class Test {
    public static void main(String[] args) {
        productExceptSelf3(new int[]{1,2,3,4});
    }

    public static int[] productExceptSelf3(int[] nums){
        int[] res=new int[nums.length];
        // 此时数组存储的是除去当前元素左边的元素乘积
        int k=1;
        for(int i=0;i<res.length;i++){
            res[i]=k;
            k*=nums[i];
        }
        k=1;
        for(int i=res.length-1;i>=0;i--){
            // k为该数右边的乘积。
            res[i]*=k;
            // 此时数组等于左边的 * 该数右边的。
            k*=nums[i];
        }
        return res;
    }

    public static int[] productExceptSelf2(int[] nums){
        int len=nums.length;
        int[] ans=new int[len];
        Map<Integer,Integer> map=new HashMap<>();
        int tmp=1;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                map.put(i, 1);
                continue;
            }
            tmp*=nums[i];
        }
        for(int i=0;i<len;i++){
//            if(map.size()==0){
//                ans[i]=tmp/nums[i];
//            }else{
//                if(map.size()==1){
//                    ans[i]=map.containsKey(i)?0:tmp;
//                    if(!map.containsKey(i)){
//                        ans[i]=0;
//                    }else{
//                        ans[i]=tmp;
//                    }
//                }else{
//                    ans[i]=0;
//                }
//                ans[i]=map.size()==1?(map.containsKey(i)?0:tmp):0; //合并
//            }




        }
        return ans;
    }

    //用例通过  但时间超时
    public int[] productExceptSelf(int[] nums) {
        int count=0,len=nums.length;
        int[] ans=new int[len];
        while(count<len){
            int tmp=1;
            for(int i=0;i<len;i++){
                if(tmp==0){
                    break;
                }
                if(i==count){
                    continue;
                }
                tmp*=nums[i];
            }
            ans[count]=tmp;
            count++;
        }
        return ans;
    }

}
