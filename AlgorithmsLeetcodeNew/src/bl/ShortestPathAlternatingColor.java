package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 11/29/2019.
 */
public class ShortestPathAlternatingColor {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer,List<Integer>> red = new HashMap<>();
        Map<Integer,List<Integer>> blue = new HashMap<>();
        for(int[] edge:red_edges){
            if(!red.containsKey(edge[0])){
                red.put(edge[0],new ArrayList<>());
            }
            red.get(edge[0]).add(edge[1]);
        }
        for(int[] edge:blue_edges){
            if(!blue.containsKey(edge[0])){
                blue.put(edge[0],new ArrayList<>());
            }
            blue.get(edge[0]).add(edge[1]);
        }
        Set<Integer> set = new HashSet<>();
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                continue;
            }
            bfs(red,blue,i,res,1,set);
        }
        set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                continue;
            }
            bfs(red,blue,i,res,0,set);
        }
        for(int i=0;i<n;i++){
            if(res[i]==Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        return res;
    }

    private void bfs(Map<Integer,List<Integer>> red, Map<Integer,List<Integer>> blue, int node, int[] res, int color, Set<Integer> visit){
        LinkedList<Integer> q = new LinkedList<>();
        int dist = 0;
        q.add(node);
        q.add(null);
        while(!q.isEmpty()){
            Integer poll = q.poll();
            if(poll==null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                dist++;
                color = 1-color;
                continue;
            }
            List<Integer> next = null;
            if(color==1){
                next = red.get(poll);
            }
            else{
                next = blue.get(poll);
            }
            if(res[poll]>dist){
                res[poll] = dist;
            }
            visit.add(poll);
            if(next==null){
                continue;
            }
            for(int n:next){
                if(visit.contains(n)){
                    continue;
                }
                q.add(n);
            }
        }
    }
}
