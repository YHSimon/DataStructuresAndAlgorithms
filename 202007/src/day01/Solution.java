package day01;


/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 超时
 */
public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.findLength(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}));
    }
    public  int findLength(int[] A, int[] B) {
        int max=0;
        int l1=A.length,l2=B.length;
        for(int i=0;i<l1;i++){
            int tmp=0;
            for(int j=0;j<l2;j++){
                if(A[i]==B[j]){
                    tmp=find(i,j,A,B);
                }
                max=Math.max(max,tmp);
            }

        }
        return max;
    }

    public int find(int i,int j,int[] A,int[] B){
        int tmp=0;
        while(i<A.length&&j<B.length&&A[i]==B[j]){
            tmp++;
            i++;
            j++;
        }
        return tmp;
    }
}
