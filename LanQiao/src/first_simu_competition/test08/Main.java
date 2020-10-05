package first_simu_competition.test08;

import java.util.Scanner;

/**
 * 【问题描述】
 * 小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
 * 小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
 * 这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展，这四小块空地都将变为有草的小块。
 * 请告诉小明，k 个月后空地上哪些地方有草。
 *
 * 【输入格式】
 * 输入的第一行包含两个整数 n, m。
 * 接下来 n 行，每行包含 m 个字母，表示初始的空地状态，字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。
 * 接下来包含一个整数 k。
 *
 * 【输出格式】
 * 输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草。
 *
 * 【样例输入】
 * 4 5
 * .g...
 * .....
 * ...g.
 * .....
 * 2
 *
 * 【样例输出】
 * gggg.
 * ggggg
 * .gggg
 * ..ggg
 *
 * 【评测用例规模与约定】
 * 对于 30% 的评测用例，2 <= n, m <= 20。
 * 对于 70% 的评测用例，2 <= n, m <= 100。
 * 对于所有评测用例，2 <= n, m <= 1000，1 <= k <= 1000。
 */
public class Main {
    //记录是否被访问过
    static int[][] vis;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        in.nextLine();//不要漏掉！！ 否则后续读取数据出错
        char[][] maps=new char[m][n];
        for(int i=0;i<m;i++){
            String str=in.nextLine();
            maps[i]=str.toCharArray();
        }
        int k=in.nextInt();
        for(int month=0;month<k;month++){
            vis=new int[m][n];//每一轮更新vis
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(maps[i][j]=='g'&&vis[i][j]==0){
                        vis[i][j]=1;
                        dfs(i,j,maps);
                    }
                }
            }
            listVis(vis);
            list(maps);
            System.out.println();
        }



    }

    private static void dfs(int i, int j, char[][] maps) {
        //定义数组dir表示草地扩张方向后的坐标变化
        int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
        for(int u=0;u<4;u++){
            int nx=i+dir[u][0];
            int ny=j+dir[u][1];
            //变化后的坐标不越界并且没有被访问过，进行具体操作
            if(nx>=0&&nx< maps.length&&ny>=0&&ny<maps[0].length&&vis[nx][ny]==0){
                if(maps[nx][ny]=='.'){
                    vis[nx][ny]=1;
                    maps[nx][ny]='g';
                }else if(maps[nx][ny]=='g'){
                    vis[nx][ny]=1;
                    dfs(nx,ny,maps);
                }
            }
        }
    }

    public static void list(char[][] grounds){
        for (int i = 0; i <grounds.length ; i++) {
            for(int j=0;j<grounds[i].length;j++){
                System.out.print(grounds[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void listVis(int[][] vis){
        for (int i = 0; i <vis.length ; i++) {
            for(int j=0;j<vis[i].length;j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
    }
}
