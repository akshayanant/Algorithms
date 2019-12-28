package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/3/2019.
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 Example 1:

 Input: 2, [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 course 0. So the correct course order is [0,1] .
 Example 2:

 Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 Output: [0,1,2,3] or [0,2,1,3]
 Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.


 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nodes.put(i,new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            List<Integer> children = nodes.get(prerequisite[1]);
            children.add(prerequisite[0]);
        }
        Set<Integer> globalVisit = new HashSet<>();
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> innerVisit = new HashSet<>();
            boolean noCycle = recursion(globalVisit,nodes,res,i,innerVisit);
            if(!noCycle){
                return new int[0];
            }
        }
        int[] order = new int[numCourses];
        int index =0;
        while (!res.isEmpty()){
            order[index] = res.pop();
            index++;
        }
        return order;
    }

    private boolean recursion(Set<Integer> globalVisit,Map<Integer,List<Integer>> nodes,
                           Stack<Integer> res,int node,Set<Integer> visit){
        if(visit.contains(node)){
            return false;
        }
        if(globalVisit.contains(node)){
            return true;
        }
        List<Integer> children = nodes.get(node);
        globalVisit.add(node);
        visit.add(node);
        if(children==null||children.isEmpty()){
            res.push(node);
            return true;
        }
        for(int i:children){
            Set<Integer> copy = new HashSet<>();
            copy.addAll(visit);
            boolean noCycle = recursion(globalVisit,nodes,res,i,copy);
            if(!noCycle){
                return false;
            }
        }
        res.push(node);
        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(4, input)));
    }
}
