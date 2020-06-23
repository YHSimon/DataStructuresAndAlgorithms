package day12;

import java.util.HashMap;
import java.util.Map;

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
public class Solution {//dogcatcatdog  abba

    public static void main(String[] args) {
        String a="";
        System.out.println(a.length());

        Solution s=new Solution();
      s.patternMatching("aaa", "catcatdog");
    }

    public  boolean patternMatching(String pattern, String value) {
        char[] chars = pattern.toCharArray();
        int pLen = chars.length;
        int vLen = value.length();
        if (pLen == 0 || pLen == 1 || pLen == 2) return true;
        int i = 1;
        String str1;
        String str2;
        Map<Character,String> map=new HashMap<>();
        map.put('a', "");
        map.put('b', "");
//        String a = "", b = "";
        int index = 0,width=1;
        while (i < pLen&&index<vLen) {
            char c1 = chars[i - 1];
            char c2 = chars[i];
            if (c1 == c2) {//如果相邻pattern元素相同  则在value中寻找相同且相邻的两个字符串
                if("".equals(map.get(c2))){
                   map.put(c2,findSame(value,width));
                   if(map.get(c2).equals("")) return false;
                   index=map.get(c2).length()*2;
                }else{
                    int l1=map.get(c2).length();
                    if(value.substring(index, index+l1).equals(map.get(c2))){
                        index+=l1;
                        i++;
                    }else{//若不同 重新找相同
                        map.put(c2, findSame(value, l1+1));
                        if(map.get(c2).equals("")) return false;
                        index=map.get(c2).length()*2;
                        i=0;
                    }
                }
                System.out.println(map.toString());
            } else {//如果相邻pattern 元素不同时
                String a=map.get(c1);
                String b=map.get(c2);
                if(a.length()>0&&b.length()>0){
                    if(value.substring(index, index+b.length()).equals(b)){
                        index+=b.length();
                    }else{//重新找b
//                        findDiffer(value, b.length()+1, index);
                    }
                }
                if(a.length()==0&&b.length()==0){
                    for (int k = 1; k < vLen / 2; k++) {
                        str1 = value.substring(0, k);
                        boolean isFound=false;
                        for (int j = 1; j < vLen / 2; j++) {
                            str2 = value.substring( k, index + k + j);
                            if (!str1.equals(str2)){
                                a=str1;
                                b=str2;
                                index=index+k+j;
                                isFound=true;
                                break;
                            }
                        }
                        if(isFound){
                            break;
                        }
                    }
                }
                if(a.length()>0&&b.length()==0){
                     for(int k=1;k<=vLen-index;k++){
                         String tmp=value.substring(index,index+k);
                         if(!a.equals(tmp)){
                             map.put(c2, tmp);
                             index+=k;
                             break;
                         }
                     }
                }
            }
        }
        return true;
    }
    public String findDiffer(String value,int width,int index,Map<Character,String> map){

        for(int i=index;i<=value.length()-index;i++){
            break;
        }

        return "";
    }

    public String findSame(String value,int width){
        int vLen=value.length();
        String str1,str2,a="";
        for (int k = width; k < vLen / 2; k++) {
            str1 = value.substring(0,  k);
            str2 = value.substring( k, k + k);
            if (str1.equals(str2)) {
                a = str2;
                break;
            }
        }
        return a;
    }

}
