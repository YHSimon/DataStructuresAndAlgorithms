package weekly_contest_189;

/**
 * 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
 * <p>
 * 句子的首字母大写
 * text 中的每个单词都用单个空格分隔。
 * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 * <p>
 * 请同样按上述格式返回新的句子。
 */
public class Test {
    public static void main(String[] args) {

    }

    public String arrangeWords2(String text) {
        String[] strs = new String[(int) Math.pow(10, 5) + 1];
        String[] inputStrs = text.split(" ");
        int count = 1;
        for (String str : inputStrs) {
            int index = str.length();
            if (count == 1) {
                str = str.toLowerCase();
                strs[index] = str;
            } else {//（同样的长度下）在已有的基础上 继续添加单词
                strs[index] = (strs[index] == null ? str : (strs[index] + " " + str));
            }
            count++;
        }

        //拼接
        StringBuilder builder=new StringBuilder();
        for(String str:strs){
            if(str==null||str.equals("")) continue;
            builder.append(" "+str);
        }

        String firstChar=builder.toString().trim().charAt(0)+"";
        String leftStr=builder.toString().trim().substring(1);
        return firstChar.toUpperCase()+leftStr;
    }

    /**
     * 1000ms
     */
    public String arrangeWords(String text) {
        String s1 = text.toLowerCase();
        String[] s = s1.split(" ");
        int len = s.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (s[j].length() > s[j + 1].length()) {
                    String tmp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = tmp;
                }
            }
        }
        char[] cs = s[0].toCharArray();
        cs[0] -= 32;
        String first = String.valueOf(cs);
        String ans = first;
        for (int i = 1; i < len; i++) {
            ans += " " + s[i];
        }
        return ans;
    }
}
