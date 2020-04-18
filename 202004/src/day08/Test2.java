package day08;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.getHappyString(3, 3);

//        System.out.println(t.findMinFibonacciNumbers(7));

//        int[] nums={-3,2,-3,4,2};
//        int[] nums={1,2};
//        System.out.println(t.minStartValue(nums));
    }

    static List<String> res = new ArrayList<>();

    public String getHappyString(int n, int k) {
        char[] r = {'a', 'b', 'c'};
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i <= 2; i++) {
            queue.add(r[i]);
            bfs(queue, r, n);
        }
        Collections.sort(res);
        System.out.println(res);
        return "";
    }

    private static void bfs(Queue<Character> queue, char[] r, int n) {
        List<Character> list = new ArrayList<>();
        while (list.size()<n) {
            Character temp = queue.poll();
            int index = 0;
            list.add(temp);
            for (int i = 0; i <= 2&&list.size()<=n; i++) {
                if (r[i] == list.get(index)) {
                    continue;
                }
                list.add(r[i]);
                index++;
                queue.add(r[i]);
            }
            res.add(list.toString());
            list.clear();
        }
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        if (k == 1) return 1;
        if (k == 2) return 1;
        int one = 1;
        int two = 1;
        int temp = 0;
        list.add(1);
        list.add(1);
        while (temp <= k) {
            temp = one + two;
            list.add(temp);
            one = two;
            two = temp;
        }
//        System.out.println(list);
        int index = list.size() - 1;
        int count = 0;
        if (list.get(index) > k) {
            index -= 1;
        }
        for (int i = index; i >= 0; i--) {
            k -= list.get(i);
            count++;
            if (k < 0) {
                k += list.get(i);
                count--;
                continue;
            }
            if (k == 0) {
                return count;
            }
            if (list.contains(k)) {
                count++;
                return count;
            }
        }
        return 0;
    }

    public int minStartValue(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int res = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            res = i;
            int sum = i;
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                sum += nums[j];
                if (sum < 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return res;
            }
        }
        return 0;
    }
}
