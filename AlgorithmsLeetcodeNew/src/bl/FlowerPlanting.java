package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/24/2019.
 * 1042. Flower Planting With No Adjacent
 Easy

 121

 154

 Favorite

 Share
 You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

 paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

 Also, there is no garden that has more than 3 paths coming into or leaving it.

 Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

 Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.



 Example 1:

 Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 Output: [1,2,3]
 Example 2:

 Input: N = 4, paths = [[1,2],[3,4]]
 Output: [1,2,1,2]
 Example 3:

 Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 Output: [1,2,3,4]


 Note:

 1 <= N <= 10000
 0 <= paths.size <= 20000
 No garden has 4 or more paths coming into or leaving it.
 It is guaranteed an answer exists.

 */
public class FlowerPlanting {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] path : paths){
            List<Integer> list = map.containsKey(path[0])?map.get(path[0]):new ArrayList<>();
            list.add(path[1]);
            map.put(path[0],list);
             list = map.containsKey(path[1])?map.get(path[1]):new ArrayList<>();
            list.add(path[0]);
            map.put(path[1],list);
        }
        Set<Integer> global = new HashSet<>();
        int[] color = new int[N+1];
        for(int i=1;i<=N;i++){
            if(!global.contains(i)){
                dfs(map,new HashSet<>(),i,color,global);
            }
        }
        int[] res = new int[N];
        for(int i=1;i<=N;i++){
            res[i-1] = color[i];
        }
        return res;
    }

    private boolean dfs(Map<Integer,List<Integer>> map,Set<Integer> visit, int node,int[] color,Set<Integer> global){
        if(visit.contains(node)){
            return true;
        }
        visit.add(node);
        global.add(node);
        boolean res = false;
        for(int i=1;i<=4;i++){
            if(canPaint(node,color,i,map)){
                color[node] = i;
                for(int n:map.get(node)){
                    res = dfs(map,visit,n,color,global);
                    if(!res){
                        break;
                    }
                }
                if(res){
                    visit.remove(node);
                    return true;
                }
            }
        }
        color[node] = 0;
        visit.remove(node);
        return false;
    }

    private boolean canPaint(int i,int[] color,int c, Map<Integer,List<Integer>> map){
        List<Integer> next = map.get(i);
        for(int n:next){
            if(color[n]==c){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FlowerPlanting().gardenNoAdj
                (4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
    }
}

