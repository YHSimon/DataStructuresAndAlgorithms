package first_simu_competition.test06;

/**
 * 在数列 a[1], a[2], …, a[n] 中，如果对于下标 i, j, k 满足 0<i<j<k<n+1 且 a[i]<a[j]<a[k]，则称 a[i], a[j], a[k] 为一组递增三元组，a[j]为递增三元组的中心。
 * 　　给定一个数列，请问数列中有多少个元素可能是递增三元组的中心。
 * 输入格式
 *
 * 输入的第一行包含一个整数 n。
 * 　　第二行包含 n 个整数 a[1], a[2], …, a[n]，相邻的整数间用空格分隔，表示给定的数列。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 *
 * 5
 * 1 2 5 3 5
 * 样例输出
 * 2
 * 样例说明
 * 　　a[2] 和 a[4] 可能是三元组的中心。
 * 评测用例规模与约定
 * 　　对于 50% 的评测用例，2 <= n <= 100，0 <= 数列中的数 <= 1000。
 * 　　对于所有评测用例，2 <= n <= 1000，0 <= 数列中的数 <= 10000。
 */
public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,5,3,5};
        boolean l=false,r=false;
        int ans=0;
        for(int i=1;i<arr.length-1;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    l=true;
                    break;
                }
            }
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    r=true;
                    break;
                }
            }
            if(l&&r){
                l=false;r=false;
                System.out.print(arr[i]+" ");
                ans++;
            }
        }
//        System.out.println(ans);
    }
}
