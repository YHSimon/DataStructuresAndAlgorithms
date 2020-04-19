package day09;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String s=in.next();
        char[] chars = s.toCharArray();
        for(int i=0,len=chars.length;i<len;i++){
            chars[i]=(char)(97+(chars[i]+3-97)%26);
        }
        System.out.println(String.valueOf(chars));
        in.close();
    }
}
