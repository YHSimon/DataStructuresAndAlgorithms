package draft01;

import java.util.Scanner;

/**
 * 递归实现  奇数项比前一项大，偶数项比前一项小
 */
public class Solution {
    static int mod = 10000;
    static Scanner in = new Scanner(System.in);
    static int m = in.nextInt(), n = in.nextInt();
    static int ans = 0;

    public static void main(String[] args) {
        if (m == 1) {
            System.out.println(n);
        } else {
            for (int i = 1; i <= n; i++) {
                f(i, 2);
            }
        }
        System.out.println(ans%mod);
    }

    /**
     *
     * @param k    前一个位置的值
     * @param loc  当前位置
     */
    public static void f(int k, int loc) {
        if (loc == m + 1) {
            ans++;
            return;
        }
        if (loc % 2 == 0) {
            for (int i = k - 1; i >= 1; i--) {
                f(i, loc + 1);
            }
        } else {
            for (int i = k + 1; i <= n; i++) {
                f(i, loc + 1);
            }
        }

    }
}
