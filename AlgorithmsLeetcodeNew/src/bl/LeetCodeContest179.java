package bl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Akshay Hegde on 3/7/2020.
 */
public class LeetCodeContest179 {
    public String generateTheString(int n) {
        if(n==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if(n%2==0){
            for (int i = 0; i < n-1; i++) {
                sb.append('a');
            }
            sb.append('b');
            return sb.toString();
        }
        sb.append('c');
        return sb.toString()+generateTheString(n-1);
    }

    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        boolean[] on = new boolean[n+1];
        int count =0;
        for (int i = 0; i < n; i++) {
            int bulb = light[i];
            on[bulb] = true;
            boolean allOn = true;
            for (int j = 1; j <bulb; j++) {
                if(!on[j]){
                    allOn = false;
                    break;
                }
            }
            if(allOn){
                int blueCount= bulb;
                for (int j = bulb+1; j <= n&&on[j]; j++) {
                    blueCount++;
                }
                if(blueCount==i+1){
                    count++;
                }
            }
        }
        return count;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if(manager[i]==-1){
                continue;
            }
            adj[manager[i]].add(i);
        }
        return dfs(adj,headID,informTime);
    }

    private int dfs(List<Integer>[] adj,int node,int[] informTime){
        List<Integer> next = adj[node];
        if(next.isEmpty()){
            return 0;
        }
        int time = informTime[node];
        int max = 0;
        for(int child:next){
            max = Math.max(max,dfs(adj,child,informTime));
        }
        return time+max;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] adj = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        double[] count = new double[n+1];
        dfs(adj,1,count,t,1.0);
        return count[target];

    }

    private void dfs(List<Integer>[] adj, int node, double[] count,int rem,double prob){
        if(rem<0){
            return;
        }
        List<Integer> next = adj[node];
        count[node]= prob;
        for(int child : next){
            dfs(adj,child,count,rem-1,prob*(1.0/next.size()));
        }
    }





    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        System.out.println(new LeetCodeContest179().frogPosition(7,in,2,4));
    }

}
