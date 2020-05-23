package day17;

import java.util.*;

/** 72.最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 */
public class Test {


    /**
     * 5ms  90%
     */
    public String minWindow3(String s,String t){
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        // 定义一个数字，用来记录字符串 t 中出现字符的频率，也就是窗口内需要匹配的字符和相应的频率
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int left = 0, right = 0;
        int match = 0;  // 匹配字符的个数
        int minLen = s.length() + 1;   // 最大的子串的长度
        // 子串的起始位置 子串结束的位置(如果不存在这样的子串的话，start，end 都是 0，s.substring 截取就是 “”
        int start = 0, end = 0;
        while (right < s.length()){
            char charRight = s.charAt(right); // 右边界的那个字符
            map[charRight]--;   // 可以理解为需要匹配的字符 charRight 减少了一个
            // 如果字符 charRight 在 t 中存在，那么经过这一次操作，只要个数大于等于 0，说明匹配了一个
            // 若字符 charRight 不在 t 中，那么 map[charRight] < 0, 不进行任何操作
            if (map[charRight] >= 0) match++;
            right++;  // 右边界右移，这样下面就变成了 [)，方便计算窗口大小

            // 只要窗口内匹配的字符达到了要求，右边界固定，左边界收缩
            while (match == t.length()){
                int size = right - left;
                if (size < minLen){
                    minLen = size;
                    start = left;
                    end = right;
                }
                char charLeft = s.charAt(left);  // 左边的那个字符
                map[charLeft]++;  // 左边的字符要移出窗口
                // 不在 t 中出现的字符，移出窗口，最终能够达到的最大值 map[charLeft] = 0
                // 如果恰好移出了需要匹配的一个字符，那么这里 map[charLeft] > 0, 也就是还要匹配字符 charLeft，此时 match--
                if (map[charLeft] > 0) match--;
                left++;  // 左边界收缩
            }
        }
        return s.substring(start, end);

    }

    //ori 统计字符串t 中 各个字符的数量
    Map<Character,Integer> ori=new HashMap<>();
    //cnt 滑动字符串中 各字符的计数器;
    Map<Character,Integer> cnt=new HashMap<>();

    public String minWindow(String s,String t){
        //字符串t 的长度
        int tLen=t.length();
        //遍历字符串t  同时通过ori 记录t中各个字符的数量
        for(int i=0;i<tLen;i++){
            char c=t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0)+1);
        }

        //l表示左指针  r表示右指针
        int l=0,r=-1;
        //len记录 滑动窗口的最小长度   ansL记录窗口的左端  ansR记录窗口的右端
        int len=Integer.MAX_VALUE,ansL=-1,ansR=-1;
        //sLen表示字符串s的长度
        int sLen=s.length();
        while (r<sLen){
            //移动右指针
            r++;
            //如果r指向的字符在 t中,滑动字符串计数器cnt 记录该字符 并更新其数量
            if(r<sLen&&ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0)+1);
            }
            //先判断滑动字符串是否满足 t的要求，若满足，不断更新左指针(收缩窗口)
            while(check()&&l<=r){
                //若新窗口值比旧窗口还小 更新ansL ansR
                if(r-l+1<len){
                    len=r-l+1;
                    ansL=l;
                    ansR=l+len;
                }
                //收缩左指针  并更新cnt里的数量
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0)-1);
                }
                l++;
            }
        }
        //直接调用substring方法截取字符串
        return ansL==-1?"":s.substring(ansL, ansR);
    }

    public boolean check(){
        for(Map.Entry<Character,Integer> entry:ori.entrySet()){
            if(cnt.getOrDefault(entry.getKey(), 0)<entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        int len = s.length();
        List<Node> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (t.indexOf(s.charAt(i)) != -1) {
                list.add(new Node(s.charAt(i), i));
                set.add(s.charAt(i));
            }
        }
        if (set.size() < t.length()) {
            return "";
        }
        //记录坐标
        int[] pos = new int[2];
        //记录符合要求的最小长度
        int ans = Integer.MAX_VALUE;
        //记录符合要求的最小下标 默认从0
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        set.clear();
        for (int j = 0; j < list.size(); j++) {
            set.add(list.get(j).c);
            if (queue.size() > 0 && (queue.peek() == list.get(j))) {
                while (set.size() == t.length()) {
                    queue.poll();
                    index++;
                }
            }
            index--;
            queue.add(list.get(j));

            if ((list.get(j).i - list.get(index).i) < ans) {
                pos[0] = list.get(index).i;
                pos[1] = list.get(j).i;
                ans = pos[1] - pos[0];
            }
        }

        return "";
    }
}

class Node {
    char c;
    int i;

    public Node(char c, int i) {
        this.c = c;
        this.i = i;
    }
}