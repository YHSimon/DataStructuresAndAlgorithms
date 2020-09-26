package first_simu_competition.test05;


/**
 * 问题描述
 * 　　一个正整数如果任何一个数位不大于右边相邻的数位，则称为一个数位递增的数，例如1135是一个数位递增的数，而1024不是一个数位递增的数。
 * 　　给定正整数 n，请问在整数 1 至 n 中有多少个数位递增的数？
 * 输入格式
 * 　　输入的第一行包含一个整数 n。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 30
 * 样例输出
 * 26
 * 评测用例规模与约定
 * 　　对于 40% 的评测用例，1 <= n <= 1000。
 * 　　对于 80% 的评测用例，1 <= n <= 100000。
 * 　　对于所有评测用例，1 <= n <= 1000000。
 */
public class Main {
    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
        int n=100;
//        in.close();
        int ans=0;
        for(int i=1;i<=n;i++){
            int tmp=i,pre=tmp%10;
            boolean flag=true;
            tmp/=10;
            while(tmp>0){
                if(pre<(tmp%10)){
                    flag=false;
                    break;
                }
                pre=tmp%10;
                tmp/=10;
            }
            if(flag){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
