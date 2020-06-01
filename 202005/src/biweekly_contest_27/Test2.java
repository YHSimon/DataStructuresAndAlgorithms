package biweekly_contest_27;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        System.out.println(t.hasAllCodes("0110", 2));
    }

    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == ((int) Math.pow(2, k));
    }
}
