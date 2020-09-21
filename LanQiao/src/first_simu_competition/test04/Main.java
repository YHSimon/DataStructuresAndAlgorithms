package first_simu_competition.test04;

/**
 * 在1至2019中，有多少个数的数位中包含数字9？
 * 注意，有的数中的数位中包含多个9，这个数只算一次。例如，1999这个数包含数字9，在计算只是算一个数。
 */
public class Main {
    public static void main(String[] args) {
        int n=2019,ans=0;
        for(int i=1;i<=20;i++){
            String str=String.valueOf(i);
            if(str.indexOf('9')!=-1){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
