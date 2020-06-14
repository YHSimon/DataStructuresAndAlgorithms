package weekly_contest_193;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3);
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (k == 0) return map.size();
        int[] val = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {//获取map的所有key  并遍历
            val[i++] = map.get(key);
        }
        Arrays.sort(val);
        int j;
        for (j = 0; j < val.length; j++) {
            if (k - val[j] >= 0) {
                k = k - val[j];
            } else break;
        }
        return val.length - j;
    }
}