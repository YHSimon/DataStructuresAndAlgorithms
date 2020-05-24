package weekly_contest_190;

public class Test {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans=-1;
        String[] s = sentence.split(" ");
        int len=searchWord.length();
        for(int i=0;i<s.length;i++){
            if(s[i].length()<searchWord.length()){
                continue;
            }
            if(s[i].substring(0, len).equals(searchWord)){
                ans=i+1;
                break;
            }
        }

        return  ans;
    }
}
