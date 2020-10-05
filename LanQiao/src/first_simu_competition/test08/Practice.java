package first_simu_competition.test08;

import java.util.Scanner;

public class Practice {

    static int vis[][];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        in.nextLine();
        char[][] maps = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            maps[i] = str.toCharArray();
        }
        int k = in.nextInt();
        for (int mon = 0; mon < k; mon++) {
            vis = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maps[i][j] == 'g' && vis[i][j] == 0) {
                        vis[i][j] = 1;
                        dfs(i, j, maps);
                    }
                }
            }
        }
        list(maps);
    }

    public static void dfs(int i, int j, char[][] maps) {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int n = 0; n < 4; n++) {
            int nx = i + dir[n][0];
            int ny = j + dir[n][1];
            if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && vis[nx][ny] == 0) {
                if (maps[nx][ny] == '.') {
                    vis[nx][ny] = 1;
                    maps[nx][ny] = 'g';
                } else if (maps[nx][ny] == 'g') {
                    vis[nx][ny] = 1;
                    dfs(nx, ny, maps);
                }
            }
        }
    }
    public static void list ( char[][] grounds){
        for (int i = 0; i < grounds.length; i++) {
            for (int j = 0; j < grounds[i].length; j++) {
                System.out.print(grounds[i][j] + " ");
            }
            System.out.println();
        }
    }
}
