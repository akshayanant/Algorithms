package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/14/2019.
 * 5192. Critical Connections in a Network
 User Accepted:37
 User Tried:60
 Total Accepted:37
 Total Submissions:67
 Difficulty:Hard
 There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

 A critical connection is a connection that, if removed, will make some server unable to reach some other server.

 Return all critical connections in the network in any order.



 Example 1:



 Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 Output: [[1,3]]
 Explanation: [[3,1]] is also accepted.

 */
public class CriticalConnections {
    class Node {
        int index;
        int low;
        List<Integer> next;
        int t;
        public Node(int i,int l,int time){
            index = i;
            this.t = time;
            low = l;
            next = new ArrayList<>();
        }
    }

    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(List<Integer> con:connections){
            int i = con.get(0);
            int j = con.get(1);
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<>());
            }
            if(!map.containsKey(j)){
                map.put(j,new ArrayList<>());
            }
            map.get(i).add(j);
            map.get(j).add(i);
        }
        Map<Integer,Node> nodes = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(map,0,nodes,-1,res);
        return res;
    }

    private int dfs(Map<Integer,List<Integer>> map,int node,Map<Integer,Node> nodes,int parent,List<List<Integer>> res){
        if(!map.containsKey(node)){
            return nodes.get(node).low;
        }
        List<Integer> next = map.remove(node);
        Node newNode = new Node(node,time,time++);
        nodes.put(node,newNode);
        for(int n:next){
            if(n==parent){
                continue;
            }
            newNode.next.add(n);
            int l = dfs(map,n,nodes,node,res);
            if(l>newNode.t){
                List<Integer> edge = new ArrayList<>();
                edge.add(node);
                edge.add(n);
                res.add(edge);
            }
            else {
                newNode.low = Math.min(l, newNode.low);
            }
        }
        return newNode.low;
    }

    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();
        in.add(Arrays.asList(0,1));
        in.add(Arrays.asList(1,2));
        in.add(Arrays.asList(2,0));
        in.add(Arrays.asList(1,3));
        System.out.println(new CriticalConnections().criticalConnections(4,in));
    }

}
