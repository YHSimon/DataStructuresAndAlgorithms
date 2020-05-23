package day17;

public class Practice {
    public String minwindow(String s,String t){
        if(s==null||t==null||s.length()==0||t.length()==0||s.length()<t.length()) return "";

        int [] map=new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int left=0,right=0;
        int match=0;
        int minLen=s.length()+1;
        int start=0,end=0;

        while(right<s.length()){
            char cRight=s.charAt(right);
            map[cRight]--;
            if(map[cRight]>=0) match++;
            right++;

            while(match==t.length()){
                int size=right-left;
                if(size<minLen){
                    minLen=size;
                    start=left;
                    end=right;
                }
                char cLeft=s.charAt(left);
                map[cLeft]++;
                if(map[cLeft]>0) match--;
                left++;
            }
        }
        return s.substring(start, end);
    }
}
