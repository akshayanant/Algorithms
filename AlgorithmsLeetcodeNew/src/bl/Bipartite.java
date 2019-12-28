package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/15/2019.
 *
 * Given an undirected graph, return true if and only if it is bipartite.

 Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

 The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

 Example 1:
 Input: [[1,3], [0,2], [1,3], [0,2]]
 Output: true
 Explanation:
 The graph looks like this:
 0----1
 |    |
 |    |
 3----2
 We can divide the vertices into two groups: {0, 2} and {1, 3}.
 Example 2:
 Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 Output: false
 Explanation:
 The graph looks like this:
 0----1
 | \  |
 |  \ |
 3----2
 We cannot find a way to divide the set of nodes into two independent subsets.


 Note:

 graph will have length in range [1, 100].
 graph[i] will contain integers in range [0, graph.length - 1].
 graph[i] will not contain i or duplicate values.
 The graph is undirected: if any element j is in graph[i], then i will be in graph[j].

 */
public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        List<Integer> nodes = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Set<Integer> global = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if(global.contains(i)){
                continue;
            }
            nodes.add(i);
            while (!nodes.isEmpty()){
                boolean res = dfs(graph,nodes,visited,global);
                if(!res){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, List<Integer> nodes, Set<Integer> visited,Set<Integer> global){
        List<Integer> next = new ArrayList<>();
        for (Integer node : nodes) {
            if(global.contains(node)){
                continue;
            }
            int[] nextNodes = graph[node];
            if(nextNodes.length==0){
                return false;
            }
            for (int nextNode : nextNodes) {
                if (visited.contains(nextNode)) {
                    return false;
                }
                next.add(nextNode);
            }
            global.add(node);
        }
        visited.clear();
        nodes.clear();
        visited.addAll(next);
        nodes.addAll(next);
        return true;
    }

    private boolean isBipartiteMain(int[][] graph){
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if(visit.contains(i)){
                continue;
            }
            visit.add(i);
            boolean res = isBipartiteOpt(graph,i,visit);
            if(!res){
                return false;
            }
        }
        return true;
    }

    private boolean isBipartiteOpt(int[][] graph,int source,Set<Integer> set){
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            colors[i] = -1;
        }
        colors[source] = 1;
        LinkedList<Integer> visit = new LinkedList<>();
        visit.add(0);
        while (!visit.isEmpty()){
            int i = visit.poll();
            int[] next = graph[i];
            for (int aNext : next) {
                if(colors[aNext]==-1){
                    colors[aNext] = 1-colors[i];
                    visit.add(aNext);
                    set.add(aNext);
                }
                else if(colors[aNext]==colors[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Bipartite().isBipartiteMain(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
    }
}
