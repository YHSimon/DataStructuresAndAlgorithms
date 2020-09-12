package MST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prim2 {

    //用来初始化数组的，比结点数大就行
    private static final int MAXN = 100;
    //INF表示不存在边的长度，用一个很大的数表示它
    private static final double INF = Double.MAX_VALUE;
    private static double sum=0;
//    private static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {



        Scanner in = new Scanner(System.in);
        //存放父结点的集合
        int[] f = new int[MAXN];
        //记录所有结点信息
        Position[] p=new Position[MAXN];
        //邻接矩阵
        double[][] dis=new double[MAXN][MAXN];
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            p[i]=new Position();
            p[i].x=in.nextInt();
            p[i].y=in.nextInt();
            p[i].h=in.nextInt();
        }

        //构建邻接矩阵
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                double p2p=Math.sqrt((p[i].x-p[j].x)*(p[i].x-p[j].x)+(p[i].y-p[j].y)*(p[i].y-p[j].y))+(p[i].h-p[j].h)*(p[i].h-p[j].h);
                dis[i][j]=p2p;
                dis[j][i]=p2p;
            }
        }
        //生成最小生成树
        toPrim(dis, f, n);
        System.out.printf("%.2f",sum);
//        System.out.println(list.toString());
    }

    private static void toPrim(double w[][], int f[], int n) {
        //用于存放结点的权值的集合
        double d[] = new double[MAXN];
        int k = 0;
        double m;
        //第一个结点与其它结点的权值加入集合中
        for(int j = 1; j <= n; j++) {
            d[j] = (j == 1 ? 0 : w[1][j]);
            //第一个结点没有父结点，初始化为1
            f[j] = 1;
        }
//        list.add(1);
        //从第二个结点开始
        for(int i = 2; i <= n; i++) {
            m = INF;
            //遍历与当前结点相连接的各个结点的权值并找出具有最小权值的结点
            for(int j = 1; j <= n; j++) {
                if(d[j] <= m && d[j] != 0) {
                    m = d[j];
                    k = j;
                }
            }
            sum+=d[k];
//            list.add(k);
            //将上面找到的结点加入到集合中
            d[k] = 0;
            //更新父d[]，将k结点与其它结点连接的最小权值放进d[j]中
            for(int j = 2; j <= n; j++) {
                if(d[j] > w[k][j] && d[j] != 0) {
                    d[j] = w[k][j];
                    f[j] = k;
                }
            }
        }
    }
    static class Position{
        int x,y,h;
    }
}