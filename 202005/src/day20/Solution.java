package day20;

import java.util.LinkedList;
import java.util.Stack;

/**394  字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println((char) 57);
//        System.out.println((int) 'Z');
//        char c=49;
//        System.out.println("c="+(c-'0'));

//        String s = "3[a]2[bc]";
        String s = "2[abc]3[cd]ef";
//        String s="3[a2[c]]";
        System.out.println(decodeString2(s));
    }

    /**
     * 1ms   90%
     */
    public static String decodeString2(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi=0;
                res=new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++){
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                //数字的拼接
                multi = multi * 10 + Integer.parseInt(String.valueOf(c));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


    /**
     * 失败
     *
     * @param s
     * @return
     */

    public static String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> chars = new Stack<>();
        int len = s.length();
        int i = 0;
        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        while (i < len) {
            while (i < len && s.charAt(i) != ']') {
                while (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    num.append(s.charAt(i));
                    i++;
                }
                if (num.length() > 0) {
                    numbers.add(Integer.parseInt(num.toString()));
                }
                num.delete(0, num.length());
                chars.add(s.charAt(i));
                i++;
            }
            StringBuilder temp = new StringBuilder();
            while (!chars.isEmpty()) {
                while (!chars.isEmpty() && chars.peek() != '[') {
                    str.append(chars.pop());
                }
                //弹出 '['
                if (!chars.isEmpty()) chars.pop();
                int count = numbers.isEmpty() ? 1 : numbers.pop();
                for (int j = 0; j < count; j++) {
                    temp.append(str);
                }
                str.delete(0, str.length());
                //若字符栈
                while (!chars.isEmpty() && chars.peek() != '[') {
                    temp.append(chars.pop());
                }
                temp.reverse();
                String s1 = temp.toString();
                str.append(s1);
                temp.delete(0, temp.length());
            }


            if (chars.isEmpty()) {
                int count = numbers.isEmpty() ? 1 : numbers.pop();
                for (int j = 0; j < count; j++) {
                    ans.append(str);
                }
            }
            str.delete(0, str.length());
            i++;
        }
        return ans.toString();
    }
}
