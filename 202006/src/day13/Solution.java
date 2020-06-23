package day13;


public class Solution {
    public static void main(String[] args) {

//        System.out.println(addBinary2("1010", "1011"));
        System.out.println(addBinary2("10", "11"));
    }

    // 2ms
    public static String addBinary(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int i1 = c1.length - 1;
        int i2 = c2.length - 1;
        int[] res = new int[Math.max(c1.length, c2.length) + 1];
        int index = res.length - 1;
        StringBuilder str=new StringBuilder();
        int add = 0;
        char num1, num2;
        while (index > 0) {
            num1 = i1 == -1 ? '0' :c1[i1];
            num2 = i2 == -1 ? '0' :c2[i2];
            res[index] = (num1 - '0') ^ (num2 - '0') ^ add;
            if (num1 == '1' && num2 == '1' || (num1 != num2 && (res[index] == 0))) {
                add = 1;
            } else {
                add = 0;
            }
            if(i1>=0) i1--;
            if(i2>=0) i2--;
            index--;
        }
        if (add == 1) {
            res[0] = 1;
        }
        if(res.length==1&&res[0]==0) return "0";
        int i=res[0]==0?1:0;
        for(;i<res.length;i++){
            str.append(res[i]);
        }
        return str.toString();
    }

    //优化 3ms 并没有优化
    public static String addBinary2(String a, String b) {
        int i1 =a.length() - 1;
        int i2 = b.length() - 1;
        int index =Math.max(a.length(), b.length());
        StringBuilder str=new StringBuilder();
        int add = 0,tmp;
        char num1, num2;
        while (index > 0) {
            num1 = i1 == -1 ? '0' :a.charAt(i1);
            num2 = i2 == -1 ? '0' :b.charAt(i2);
            tmp= (num1 - '0') ^ (num2 - '0') ^ add;
            str.append(tmp);
            if (num1 == '1' && num2 == '1' || (num1 != num2 && (tmp == 0))) {
                add = 1;
            } else {
                add = 0;
            }
            if(i1>=0) i1--;
            if(i2>=0) i2--;
            index--;
        }
        if (add == 1) {
            str.append(1);
        }
        if(a.length()==1&&a.equals("0")&&b.length()==1&&b.equals("0")) return "0";
        return str.reverse().toString();
    }
}
