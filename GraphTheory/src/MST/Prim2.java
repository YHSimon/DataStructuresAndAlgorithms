package MST;

import java.util.Scanner;

/**
 * 问题描述
 *
 * 小明和朋友们一起去郊外植树，他们带了一些在自己实验室精心研究出的小树苗。
 * 　　小明和朋友们一共有 n 个人，他们经过精心挑选，在一块空地上每个人挑选了一个适合植树的位置，总共 n 个。他们准备把自己带的树苗都植下去。
 * 　　然而，他们遇到了一个困难：有的树苗比较大，而有的位置挨太近，导致两棵树植下去后会撞在一起。
 * 　　他们将树看成一个圆，圆心在他们找的位置上。如果两棵树对应的圆相交，这两棵树就不适合同时植下（相切不受影响），称为两棵树冲突。
 * 　　小明和朋友们决定先合计合计，只将其中的一部分树植下去，保证没有互相冲突的树。他们同时希望这些树所能覆盖的面积和（圆面积和）最大。
 *
 * 输入格式
 *
 * 输入的第一行包含一个整数 n ，表示人数，即准备植树的位置数。
 * 　　接下来 n 行，每行三个整数 x, y, r，表示一棵树在空地上的横、纵坐标和半径。
 *
 * 输出格式
 *
 * 输出一行包含一个整数，表示在不冲突下可以植树的面积和。由于每棵树的面积都是圆周率的整数倍，请输出答案除以圆周率后的值（应当是一个整数）。
 *
 * 样例输入
 *
 * 6
 * 1 1 2
 * 1 4 2
 * 1 7 2
 * 4 1 2
 * 4 4 2
 * 4 7 2
 *
 * 样例输出
 *
 * 12
 *
 * 评测用例规模与约定
 *
 * 对于 30% 的评测用例，1 <= n <= 10；
 * 　　对于 60% 的评测用例，1 <= n <= 20；
 * 　　对于所有评测用例，1 <= n <= 30，0 <= x, y <= 1000，1 <= r <= 1000。
 */
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