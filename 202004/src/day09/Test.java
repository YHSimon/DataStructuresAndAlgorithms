package day09;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % a == 0 || i % b == 0 || i % c == 0) {
                continue;
            }
            count++;
        }
        System.out.println(count);
        in.close();
    }
}
