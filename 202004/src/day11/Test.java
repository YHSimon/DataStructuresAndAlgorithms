package day11;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
    }

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        int [] ans=new int[2];
        int count=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                ans[count++]=entry.getKey();
            }
        }

        return ans;
    }

    //更慢了
    public int[] singleNumbers2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
                set.remove(num);
            }else{
                map.put(num, 1);
                set.add(num);
            }
        }
        int[] ans={(Integer) set.toArray()[0],(Integer)set.toArray()[1]};

        return ans;
    }

    //使用分组位运算
    public int[] singleNumbers3(int[] nums) {
       //因为只有两个数出现一次，数组全部元素进行异或运算的值 等同于 这个两个元素异或运算的值
        int k=0;
        for(int num:nums){
            k^=num;
        }

        //两个不同的数异或运算的结果 k  对k从低位往高位寻找 两个数某位不同的所在位置  （即k从最低位开始 首次出现'1'的位置）
        //找到区分值，就可以将这两个数 分到 两个不同分组
        int first=1;
        while((first&k)==0){
            first<<=1;
        }
        //0跟数异或等于数本身  相同数异或等于0
        //在各自分组中  只有一个数出现了一次  其他数都出现两次
        //各个分组 各自异或运算 结果值为  只出现过一次的数
        int a=0;
        int b=0;
        for(int num:nums){
            if((num&first)==0){
                a^=num;
            }else{
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
