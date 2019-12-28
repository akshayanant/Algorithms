package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/8/2019.
 * 886. Possible Bipartition
 Medium

 344

 16

 Favorite

 Share
 Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

 Each person may dislike some other people, and they should not go into the same group.

 Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

 Return true if and only if it is possible to split everyone into two groups in this way.



 Example 1:

 Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 Output: true
 Explanation: group1 [1,4], group2 [2,3]
 Example 2:

 Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 Output: false
 Example 3:

 Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 Output: false


 Note:

 1 <= N <= 2000
 0 <= dislikes.length <= 10000
 1 <= dislikes[i][j] <= N
 dislikes[i][0] < dislikes[i][1]
 There does not exist i != j for which dislikes[i] == dislikes[j].

 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes.length==0||N<=2){
            return true;
        }
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int[] dislike : dislikes) {
            if (!graph.containsKey(dislike[0])) {
                graph.put(dislike[0], new ArrayList<>());
            }
            graph.get(dislike[0]).add(dislike[1]);
            if (!graph.containsKey(dislike[1])) {
                graph.put(dislike[1], new ArrayList<>());
            }
            graph.get(dislike[1]).add(dislike[0]);
        }
        Set<Integer> visit = new HashSet<>();
        int index= 1;
        int[] color = new int[N+1];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        while (index<=N){
            if(visit.contains(index)){
                index++;
                continue;
            }
            boolean res = isBip(visit,graph,index,color);
            if(!res){
                return false;
            }
            index++;
        }
        return true;
    }

    private boolean isBip(Set<Integer> visit,Map<Integer,List<Integer>> graph,int source,int[] color){
        color[source] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visit.add(source);
        while (!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> next = graph.get(node);
            if(next==null||next.isEmpty()){
                continue;
            }
            for(Integer i:next){
                if(color[i]==-1){
                    color[i] = 1-color[node];
                    queue.add(i);
                    visit.add(i);
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2},{1,3},{2,4}};
        System.out.println(new PossibleBipartition().possibleBipartition(4,in));
    }


}
