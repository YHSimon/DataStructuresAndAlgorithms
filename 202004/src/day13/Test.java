package day13;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.isHappy2(2));
    }

    /**
     *   ArrayList        HashMap
     *   2ms   52%      1ms      99%
     *   36M    8%      36        8%
     * 用集合（List|Map）装载中间数据 ，如果重复出现某个元素（形成环）
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
//        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        while(n!=1){
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n/=10;
            }
            if(map.containsKey(temp)){
                return false;
            }else{
                n=temp;
                map.put(temp,1);
            }
        }
        return true;
    }

    /**
     * 1ms   99%
     * 36M    8%
     * 快慢指针处理环问题
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }

    public int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
