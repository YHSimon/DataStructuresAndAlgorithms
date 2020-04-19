package day09;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), r = in.nextInt(), c = in.nextInt();
        int len = m * n;
        int[][] arr = new int[m][n];
        int[][] record = new int[m][n];
        int count = 0;
        int i = 0, j = 0;
        while (count < len) {
            while (j < n && record[i][j] == 0) {
                arr[i][j] = ++count;
                record[i][j] = 1;
                j++;
            }
            j--;
            i++;
            while (i < m && record[i][j] == 0) {
                arr[i][j] = ++count;
                record[i][j] = 1;
                i++;
            }
            i--;
            j--;
            while (j >= 0 && record[i][j] == 0) {
                arr[i][j] = ++count;
                record[i][j] = 1;
                j--;
            }
            j++;
            i--;
            while (i >= 0 && record[i][j] == 0) {
                arr[i][j] = ++count;
                record[i][j] = 1;
                i--;
            }
            i++;
            j++;
        }
        System.out.println(arr[r-1][c-1]);
        in.close();
    }

    public static void list(int[][] arr){
        for (int p = 0; p < arr.length; p++) {
            for(int q=0;q<arr[p].length;q++){
                System.out.print(arr[p][q]+" ");
            }
            System.out.println();
        }
    }
}
