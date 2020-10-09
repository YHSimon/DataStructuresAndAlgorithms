package competiton11.test04;


import java.math.BigInteger;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        while (n.compareTo(BigInteger.ZERO) != 0) {
            System.out.print(n + " ");
            n = n.divide(BigInteger.valueOf(2));
        }
    }
}
