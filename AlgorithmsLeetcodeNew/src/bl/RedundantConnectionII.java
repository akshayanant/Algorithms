//import java.util.*;
//
///**
// * Created by Akshay Hegde on 11/14/2019.
// * 685. Redundant Connection II
// Hard
//
// 558
//
// 174
//
// Favorite
//
// Share
// In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
//
// The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
//
// The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
//
// Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
//
// Example 1:
// Input: [[1,2], [1,3], [2,3]]
// Output: [2,3]
// Explanation: The given directed graph will be like this:
// 1
// / \
// v   v
// 2-->3
// Example 2:
// Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
// Output: [4,1]
// Explanation: The given directed graph will be like this:
// 5 <- 1 -> 2
// ^    |
// |    v
// 4 <- 3
// Note:
// The size of the input 2D-array will be between 3 and 1000.
// Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
//
// */
//public class RedundantConnectionII {
//    public int[] findRedundantDirectedConnection(int[][] edges) {
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        boolean[] inc = new boolean[edges.length];
//        boolean[][] mat = new boolean[edges.length][edges.length];
//        for (int[] edge : edges) {
//            inc[edge[1]-1] = true;
//            mat[edge[0]][edge[1]] = true;
//        }
//        int root = 0;
//        for (int i = 0; i < edges.length; i++) {
//            if(!inc[i]){
//                root = i+1;
//                break;
//            }
//        }
//        int[] res = new int[2];
//        int[] start = new int[2];
//        for (int[] edge : edges) {
//            if (edge[0] == root) {
//                start = edge;
//                break;
//            }
//        }
//
//        Set<Integer> visit = new HashSet<>();
//
//
//    }
//
//    private void dfs(Map<Integer,List<Integer>> map, int node,int[] res,int parent){
//        if(!map.containsKey(node)){
//            res[0] = parent;
//            res[1] = node;
//            return;
//        }
//        List<Integer> next = map.remove(node);
//        if(next!=null) {
//            for (int n : next) {
//                dfs(map, n, res, node);
//            }
//        }
//    }
//}
