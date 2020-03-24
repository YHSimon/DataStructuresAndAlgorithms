package day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 迷宫的入口为左上角，出口为右下角，在迷宫中，只能从一个位置走到这 个它的上、下、左、右四个方向之一。
 * 对于上面的迷宫，从入口开始，可以按DRRURRDDDR 的顺序通过迷宫， 一共 10 步。其中 D、U、L、R 分别表示向下、向上、向左、向右走。
 * 对于下面这个更复杂的迷宫（30 行 50 列），请找出一种通过迷宫的方式， 其使用的步数最少，在步数最少的前提下，请找出字典序最小的一个作为答案。
 * 请注意在字典序中D<L<R<U。
 *
 * 答案：DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDDRRRURRUURRDDDDRDRRRRRRDRRURRDDDRRRRUURUUUUUUULULLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDDRRRRRDDRRDDLLLDDRRDDRDDLDDDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR
 * 结果：DDDDRRURRRRRRDRRRRDDDLDDRDDDDDDDDDDDDRDDRRRURRUURRDDDDRDRRRRRRDRRURRDDDRRRRUURUUUUUUULULLUUUURRRRUULLLUUUULLUUULUURRURRURURRRDDRRRRRDDRRDDLLLDDRRDDRDDLDDDLLDDLLLDLDDDLDDRRRRRRRRRDDDDDDRR
 * @author Q倘若
 *2020年2月21日
 */
public class MiGong {
    static int n=30,m=50;
    static int [][] map=new int[n][m];
    static int [][] record=new int[n][m];
    static char [][] dir=new char[n][m];

    //D<L<R<U
    static int[] x={1,0,0,-1};
    static int[] y={0,-1,+1,0};
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        for (int i = 0; i <n ; i++) {
            String line=in.next();
            for (int j = 0; j <m ; j++) {
                map[i][j]=line.charAt(j)-'0';
            }
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(0,0));
        record[0][0]=1;
        bfs(queue);

        //逆向寻找路径
        Stack<Character> stack=new Stack<>();
        int x1=n-1,y1=m-1;
        while(true){
            char c=dir[x1][y1];
            stack.add(c);
            if(c=='U'){
                x1+=1;
            }else if(c=='D'){
                x1-=1;
            }else if(c=='L'){
                y1+=1;
            }else {
                y1-=1;
            }

            if(x1==0&&y1==0){
                break;
            }
        }


        //遍历路径
        while(stack.size()>0){
            System.out.print(stack.pop());
        }
        in.close();
    }

    private static void bfs(Queue<Node> queue) {
        while (queue.size()>0){
            Node temp=queue.poll();
            for (int i = 0; i < 4; i++) {
                int x1=temp.x+x[i];
                int y1=temp.y+y[i];
                //优先越界判断
                if(x1<0||y1<0||x1>n-1||y1>m-1||record[x1][y1]==1||map[x1][y1]==1){
                    continue;
                }
                queue.add(new Node(x1,y1));
                record[x1][y1]=1;
                addDir(i,x1,y1);
            }
        }
    }


    //D<L<R<U
    private static void addDir(int i, int x1, int y1) {
        if(i==0){
            dir[x1][y1]='D';
        }else if(i==1){
            dir[x1][y1]='L';
        }else if(i==2){
            dir[x1][y1]='R';
        }else{
            dir[x1][y1]='U';
        }
    }

}
class Node{
    int x,y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }

    public Node(){

    }
}