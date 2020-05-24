package weekly_contest_190;

/**5417.定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 t=new Test2();
        System.out.println(t.maxVowels("weallloveyou", 7));
    }

    public int maxVoAnInt3(String s,int k){
        int  n=s.length(),ans=0,count=0;
        for(int i=0,j=0;j<n;j++){
            //右指针
            char c=s.charAt(j);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                count++;
            }
            //当长度大于k时，左指针开始移动
            if(j>k-1){
                //左指针
                char c1=s.charAt(i);
                if(c1=='a'||c1=='e'||c1=='i'||c1=='o'||c1=='u'){
                    count--;
                }
                i++;
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }

    /**
     * 以"aeiou"为参照
     * 22ms
     */
    public int maxVowAnInt2(String s,int k){
        int n=s.length();
        int count=0,ans=0;
        int i=0;
        for(int j=0;j<n;j++){
            if("aeiou".indexOf(s.charAt(j))!=-1)count++;
            if(j>k-1){
                if("aeiou".indexOf(s.charAt(i))!=-1) count--;
                i++;
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }

    /** 定长滑动窗口  （双指针）
     * 12ms
     */
    public int maxVowels(String s, int k) {
        int ans=0;
        if(k>=s.length()){
            for(char c:s.toCharArray()){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    ans++;
                }
            }
            return ans;
        }else{
            int len=0;
            for(int i=0;i<k;i++){
                char c=s.charAt(i);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    len++;
                }
            }
            ans=len;
            for(int left=1,end=k;end<s.length();end++, left++){
                char preLeft=s.charAt(left-1);
                char c=s.charAt(end);
                if(preLeft=='a'||preLeft=='e'||preLeft=='i'||preLeft=='o'||preLeft=='u'){
                    len--;
                }
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    len++;
                }
                ans=Math.max(ans, len);

            }
            return ans;
        }
    }
}
