package day01;


//50ms
public class Solution4 {
    public int findLength(int[] A,int[] B){
        int n=A.length,m=B.length;
        int max=0;
        for(int i=0;i<n;i++){
            int len=Math.min(m, n-i);
            int maxLen=maxLength(A,B,i,0,len);
            max=Math.max(max, maxLen);
        }

        for(int i=0;i<m;i++){
            int len=Math.min(n,m-i);
            int maxLen=maxLength(A, B, 0, i, len);
            max=Math.max(max, maxLen);
        }
        return max;
    }

    //公共区域 最大匹配长度
    private int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ans=0,k=0;
        for(int i=0;i<len;i++){
            if(A[addA+i]==B[addB+i]){
                k++;
            }else{
                k=0;
            }
            ans=Math.max(ans, k);
        }
        return ans;
    }
}
