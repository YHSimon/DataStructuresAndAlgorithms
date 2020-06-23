package day12;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 提示
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }

    /**
     * 回溯算法
     * 95ms
     *
     */
    public boolean patternMatching(String pattern,String value){
        String s[]=new String[2];
        return solve(s,pattern,0,value,0);
    }

    /**
     *
     * @param s             s[0]为a对应的字符串  s[1]为b对应的字符串
     * @param pattern       模式串
     * @param index1        模式串匹配位置
     * @param value         匹配串
     * @param index2        匹配串匹配的位置
     * @return
     */
    private boolean solve(String[] s, String pattern, int index1, String value, int index2) {
        //匹配完成
        if(index1==pattern.length()&&index2==value.length()) return true;
        //当匹配串匹配位置等于 匹配串长度的时候  也可以继续匹配，因为模式匹配中的a,b可以匹配空串
        if(index1>=pattern.length()||index2>value.length()) return false;
        int num=pattern.charAt(index1)-'a';
        if(s[num]==null){
            //从当前尝试a或b对应的字符串的每一种可能
            for(int i=index2;i<=value.length();i++){
                s[num]=value.substring(index2, i);
                if(!s[num].equals(s[num^1])&&solve(s,pattern,index1+1,value,i)) return true;
            }
            //失配时应将设置过的对应字符串为空
            s[num]=null;
            return false;
        }else{
            //若此前a或b已有对应的字符串匹配成功了，则查看当前位置时候能否匹配上
            int end=index2+s[num].length();
            if(end>value.length()||!value.substring(index2, end).equals(s[num])) return false;
            return solve(s, pattern, index1+1, value, end);
        }
    }
}
