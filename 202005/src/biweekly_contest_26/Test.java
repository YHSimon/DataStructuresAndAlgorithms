package biweekly_contest_26;


public class Test {
    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.maxPower("lcccdfdfcccd"));
    }
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        char c=chars[0];
        int ans=0;
        int count=0;
        for(int i=0;i<chars.length;i++){
            if(c==chars[i]){
                count++;
            }else{
                count=1;
                c=chars[i];
            }
            ans=Math.max(ans, count);
        }
        return ans;
    }
}
