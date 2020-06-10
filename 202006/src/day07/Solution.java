package day07;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    //9ms  翻转一半
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revNum = 0;
        while (x > revNum) {
            revNum = revNum * 10 + x % 10;
            x /= 10;
        }
        return x == revNum || x == revNum / 10;
    }

    //转换字符串 对称比较
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if ((s.charAt(i) ^ s.charAt(len - 1 - i)) != 0) {
                return false;
            }
        }
        return true;
    }
}
