package first_simu_competition.test02;

/**
 * 1200000有多少个约数（只计算正约数）。
 */
public class Main {
    public static void main(String[] args) {
        int n=1200000,ans=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
