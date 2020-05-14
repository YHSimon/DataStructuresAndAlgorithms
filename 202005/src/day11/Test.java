package day11;

import java.util.*;

/** 数组中数字出现的次数II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 */
public class Test {


    public int singleNumber3(int[] nums) {
       int[] counts=new int[32];
       for(int num:nums){
           for(int j=0;j<32;j++){
               counts[j]+=num&1;
               num>>>=1;
           }
       }
       int res=0,m=3;
       for(int i=0;i<32;i++){
           res<<=1;
           res|=counts[31-i]%m;
       }
       return res;
    }
    /**
     * 300ms
     * 优化后 更慢
     */
    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
                list.remove((Integer)num);
            }else{
                list.add(num);
                map.put(num,1);
            }
        }
        if(list.size()<=1){
            return list.get(0);
        }else{
            int a=map.get(list.get(0));
            int b=map.get(list.get(1));
            return a-b>0?list.get(1):list.get(0);
        }
    }

    /**
     *  HashMap 集合
     *  23ms
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

}
