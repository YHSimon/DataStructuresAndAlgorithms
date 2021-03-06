package second_simu_competiton.test08;

/**
 * 问题描述
 *
 * 　　2015年，全中国实现了户户通电。作为一名电力建设者，小明正在帮助一带一路上的国家通电。
 * 　　这一次，小明要帮助 n 个村庄通电，其中 1 号村庄正好可以建立一个发电站，所发的电足够所有村庄使用。
 * 　　现在，这 n 个村庄之间都没有电线相连，小明主要要做的是架设电线连接这些村庄，使得所有村庄都直接或间接的与发电站相通。
 * 　　小明测量了所有村庄的位置（坐标）和高度，如果要连接两个村庄，小明需要花费两个村庄之间的坐标距离加上高度差的平方，形式化描述为坐标为 (x_1, y_1) 高度为 h_1 的村庄与坐标为 (x_2, y_2) 高度为 h_2 的村庄之间连接的费用为
 * 　　sqrt((x_1-x_2)*(x_1-x_2)+(y_1-y_2)*(y_1-y_2))+(h_1-h_2)*(h_1-h_2)。
 * 　　在上式中 sqrt 表示取括号内的平方根。请注意括号的位置，高度的计算方式与横纵坐标的计算方式不同。
 * 　　由于经费有限，请帮助小明计算他至少要花费多少费用才能使这 n 个村庄都通电。
 *
 * 输入格式
 *
 * 　　输入的第一行包含一个整数 n ，表示村庄的数量。
 * 　　接下来 n 行，每个三个整数 x, y, h，分别表示一个村庄的横、纵坐标和高度，其中第一个村庄可以建立发电站。
 *
 * 输出格式
 *
 * 　　输出一行，包含一个实数，四舍五入保留 2 位小数，表示答案。
 *
 * 样例输入
 *
 * 4
 * 1 1 3
 * 9 9 7
 * 8 8 6
 * 4 5 4
 *
 * 样例输出
 *
 * 17.41
 *
 * 评测用例规模与约定
 *
 * 　　对于 30% 的评测用例，1 <= n <= 10；
 * 　　对于 60% 的评测用例，1 <= n <= 100；
 * 　　对于所有评测用例，1 <= n <= 1000，0 <= x, y, h <= 10000。
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小生成树 Prim算法
 */
public class Main {
    static Scanner in=new Scanner(System.in);
    static int n;
    static Position[] p=new Position[1010];
    static double[][] dis=new double[1005][1005];
    static int[] vis=new int[1010];
    static double[] d=new double[1010];
    public static double ans;
    public static void main(String[] args) {
        n=in.nextInt();
        for(int i=1;i<=n;i++){
            p[i]=new Position();
            p[i].x=in.nextInt();
            p[i].y=in.nextInt();
            p[i].h=in.nextInt();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                double p2p=Math.sqrt((p[i].x-p[j].x)*(p[i].x-p[j].x)+(p[i].y-p[j].y)*(p[i].y-p[j].y)+(p[i].h-p[j].h)*(p[i].h-p[j].h));
                dis[i][j]=p2p;
                dis[j][i]=p2p;
            }
        }
        ans=0;
        prim();
        System.out.println(ans);
        System.out.printf("%.2f\n",ans);
    }
    public static void prim(){
        Arrays.fill(vis, 0);
        double minn;
        int k=1;
        for(int i=1;i<=n;i++){
            d[i]=dis[1][i];
        }
        for(int i=1;i<=n;i++){
            minn=Double.MAX_VALUE;
            for(int j=1;j<=n;j++){
                if(vis[j]==0&&minn>d[j]){
                    k=j;
                    minn=d[j];
                }
            }
            ans+=d[k];
            vis[k]=1;
            for(int j=1;j<=n;j++){
                if(vis[j]==0&&d[j]>dis[k][j]){
                    d[j]=dis[k][j];
                }
            }
        }
    }
    static class Position{
        int x,y,h;
    }
}
