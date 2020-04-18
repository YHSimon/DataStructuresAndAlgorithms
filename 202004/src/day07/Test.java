package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        System.out.println(5 ^ 7);

//        Test t=new Test();
//        t.NumberOf1Between1AndN_Solution(55);


//        Integer[] a=new Integer[]{1,5,3,5,6,2};
//        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(a));
//        Collections.sort(list,Collections.reverseOrder());
//        System.out.println(list);
//

//        Arrays.sort(a,Collections.reverseOrder());
//        System.out.println(Arrays.toString(a));
    }

    /**
     * 方法二
     * 从个 十 百  ...依次讨论
     * 整数中1出现的次数（从1到n整数中1出现的次数）
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }

    /**
     * 方法一  暴力求解
     * 整数中1出现的次数（从1到n整数中1出现的次数）
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    /**
     * 动态规划
     * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
     * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        return 0;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0) {
            return res;
        }
        for (int i = 0, len = input.length; i < len; i++) {
            list.add(input[i]);
        }
        Collections.sort(list);
        if (k > list.size()) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        return res;
    }
}
