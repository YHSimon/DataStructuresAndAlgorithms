package day06;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        int[] a={1,3,5,5,2,2,2,2,2,1,2,2};
        int[] a = {1};
//        int res = t.MoreThanHalfNum_Solution(a);
        int res = t.MoreThanHalfNum_Solution2(a);
        System.out.println(res);

    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
     * 超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
                map.put(array[i], 1);
                if (map.get(array[i]) > len / 2) {
                    return array[i];
                }
            } else {
                map.put(array[i], map.get(array[i]) + 1);
                int cur = map.get(array[i]);
                if (cur > len / 2) {
                    return array[i];
                }
            }
        }
        return 0;
    }

    /**
     * 方法二
     * 采用阵地攻守的思想：
     * 第一个数字作为第一个士兵，守阵地；count = 1；
     * 遇到相同元素，count++;
     * 遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
     * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array == null || array.length == 0) return 0;
        int soldier = array[0];
        int count = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == soldier) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    soldier = array[i];
                    count = 1;
                }
            }
        }
        if (count > 0) {//该士兵有可能是结果
            int c = 0;
            for (int i = 0; i < len; i++) {
                if (soldier == array[i]) {
                    c++;
                    if (c > len / 2) {
                        return soldier;
                    }
                }
            }
        }
        return 0;
    }
}
