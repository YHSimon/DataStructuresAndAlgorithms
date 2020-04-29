package day12;

import java.util.*;

public class Test {


    /**
     * 1ms  99%
     * 39   5%
     * 1<=nums[i]<=10^5
     *
     * @param nums
     * @return
     */
    public int findNumbers2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if ((num > 10 && num < 100) || (num > 1000 && num < 10000)||num==100000) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 2 ms  73%
     * 39    5.8%
     * 统计位数为偶数的数字
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * 1ms 99%
     * 40M 100%
     *
     * @param nums
     * @return
     */
    public int[] decompressRLElist3(int[] nums) {
        int i = 0;
        int len = 0;
        while (i < nums.length) {
            len += nums[i];
            i += 2;
        }
        int[] result = new int[len];
        int index = 0;
        i = 0;
        while (i < nums.length) {
            for (int k = 0; k < nums[i]; k++) {
                result[index] = nums[i + 1];
                index++;
            }
            i += 2;
        }
        return result;
    }


    /**
     * 2ms 70%
     * 40M 100%
     *
     * @param nums
     * @return
     */
    public int[] decompressRLElist2(int[] nums) {
        int[] ans = new int[5000];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[i] > 0) {
                ans[index++] = nums[i + 1];
                nums[i]--;
            }
        }
        return Arrays.copyOf(ans, index);
    }

    /**
     * 解压缩编码列表
     * <p>
     * 7ms 25%
     * 40M 100%
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[i] > 0) {
                list.add(nums[i + 1]);
                nums[i]--;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 宝石与石头
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (J.indexOf(s[i]) != -1) {
                count++;
            }
        }
        return count;
    }

    //使用哈希集合  效率不如使用字符串函数
    public int numJewelsInStones2(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        for (char j : J.toCharArray()) {
            jSet.add(j);
        }
        int ans = 0;
        for (char s : S.toCharArray()) {
            if (jSet.contains(s)) {
                ans++;
            }
        }
        return ans;
    }
}
