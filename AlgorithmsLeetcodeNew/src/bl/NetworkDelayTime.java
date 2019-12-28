package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/22/2019.
 *
 * 743. Network Delay Time
 Medium

 775

 181

 Favorite

 Share
 There are N network nodes, labelled 1 to N.

 Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

 Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.



 Example 1:



 Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 Output: 2


 Note:

 N will be in the range [1, 100].
 K will be in the range [1, N].
 The length of times will be in the range [1, 6000].
 All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

 */
public class NetworkDelayTime {

    class GraphNode{
        int cost;
        int id;
        public GraphNode(int id,int cost) {
            this.id = id;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        public int getId() {
            return id;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] delay = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j){
                    delay[i][j] = 0;
                    continue;
                }
                delay[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] time : times) {
            delay[time[0]-1][time[1]-1] = time[2];
        }
        Set<Integer> s = new HashSet<>();
        K--;
        s.add(K);
        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>(new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode o1, GraphNode o2) {
                return o1.cost-o2.cost;
            }
        });
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if(i==K){
                continue;
            }
            GraphNode node = new GraphNode(i,delay[K][i]);
            priorityQueue.add(node);
            nodeMap.put(i,node);
        }
        int res = Integer.MIN_VALUE;
        while (!priorityQueue.isEmpty()){
            GraphNode next = priorityQueue.remove();
            if(next.cost==Integer.MAX_VALUE){
                return -1;
            }
            if(next.cost>res){
                res = next.cost;
            }
            s.add(next.id);
            int id = next.id;
            for (int i = 0; i < N; i++) {
                if(s.contains(i)||delay[id][i]==Integer.MAX_VALUE){
                    continue;
                }
                GraphNode node = nodeMap.get(i);
                if(node.cost>next.cost+delay[id][i]){
                    priorityQueue.remove(nodeMap.get(i));
                    GraphNode newNode = new GraphNode(i,next.cost+delay[id][i]);
                    priorityQueue.add(newNode);
                    nodeMap.put(i,newNode);
                }
            }
        }
        if(s.size()==N){
            return res;
        }
        return -1;
    }
}
