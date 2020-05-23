package day16;


import java.util.Arrays;


/**
 * 1. 记录a e i o u构成整体的状态  范围在00000~11111
 * 2. 如果两次出现了相同的状态，
 *    假设第一次出现在i处，第二次出现的j处，
 *    那么 i+1 ~ j 之间的字符串肯定是满足aeiou出现均为偶数次数的。
 * 3. 因为只有经历了偶数个aeiou，才能回到之前的状态。
 * 4. 为了使得合理的字符串长度最长，需在第一次出现此状态时，就需要记录到下标，然后下一次碰到相同的状态，就算最大长度。
 */
public class Test {
    public static void main(String[] args) {
        Test t=new Test();

        System.out.println(t.findTheLongestSubstring("leetcodeisgreat"));
    }
    public int findTheLongestSubstring(String s) {
        int n=s.length();
        int[] pos=new int[32];
        Arrays.fill(pos, Integer.MAX_VALUE);
        int ans=0,status=0;
        pos[0]=-1;
        for(int i=0;i<n;i++){
            //更新子串的状态  u o i e a
            char ch=s.charAt(i);
            if(ch=='a'){
                status^=(1);
            }else if(ch=='e'){
                status^=(1<<1);
            }else if(ch=='i'){
                status^=(1<<2);
            }else if(ch=='o'){
                status^=(1<<3);
            }else if(ch=='u'){
                status^=(1<<4);
            }

            if(pos[status]==Integer.MAX_VALUE){
                pos[status]=i;
            }else{
                ans=Math.max(ans, i-pos[status]);
            }
        }
        return ans;
    }
}
