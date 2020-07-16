package day03;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    private static final int UNCOLORED=0;
    private static final int RED=1;
    private static final int GREEN=2;
    private int[] color;
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        color=new int[n];
        Arrays.fill(color, UNCOLORED);
        for(int i=0;i<n;i++){
            if(color[i]==UNCOLORED){
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                color[i]= RED;
                while(!queue.isEmpty()){
                    int node=queue.poll();
                    int cNei=color[node]==RED?GREEN:RED;
                    for(int neighbor:graph[node]){
                        if(color[neighbor]==UNCOLORED){
                            queue.add(neighbor);
                            color[neighbor]=RED;
                        }else if(color[neighbor]!=cNei){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
