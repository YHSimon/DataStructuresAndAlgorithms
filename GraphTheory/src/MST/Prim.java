package MST;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {

    //用来初始化数组的，比结点数大就行
    private static final int MAXN = 100;
    //INF表示不存在边的长度，用一个很大的数表示它
    private static final int INF = 100000001;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("请输入结点个数:");
        int n = Integer.parseInt(s.nextLine());
        System.out.println("结点个数: " + n);
        //邻接矩阵
        int[][] w = new int[MAXN][MAXN];
        //存放父结点的集合
        int[] f = new int[MAXN];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int t = s.nextInt();
                w[i][j] = (t == 0) ? INF :t;
            }
        }
        //生成最小生成树
        toPrim(w, f, n);
        for(int i = 2; i <= n; i++) {
            System.out.println(i + "------>" + f[i]);
        }
    }

    private static void toPrim(int w[][], int f[], int n) {
        //用于存放结点的权值的集合
        int d[] = new int[INF];
        int k = 0;
        int m;
        //第一个结点与其它结点的权值加入集合中
        for(int j = 1; j <= n; j++) {
            d[j] = (j == 1 ? 0 : w[1][j]);
            //第一个结点没有父结点，初始化为1
            f[j] = 1;
        }
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
            //将上面找到的结点加入到集合中
            d[k] = 0;
            //更新父d[]，将k结点与其它结点连接的最小权值放进d[j]中
            for(int j = 1; j <= n; j++) {
                if(d[j] > w[k][j] && d[j] != 0) {
                    d[j] = w[k][j];
                    f[j] = k;
                }
            }
        }
    }
}