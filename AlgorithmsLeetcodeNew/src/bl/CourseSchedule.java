package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 8/22/2019.
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 Example 1:

 Input: 2, [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: 2, [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should
 also have finished course 1. So it is impossible.
 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.

 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i,new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = courseMap.get(prerequisite[1]);
            list.add(prerequisite[0]);
        }
        Set<Integer> globalVisit = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if(globalVisit.contains(i)){
                continue;
            }
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            boolean cycle = traverse(visited,globalVisit,courseMap,i);
            if(!cycle){
                return false;
            }
        }
        return true;
    }

    private boolean traverse(Set<Integer> visited,Set<Integer> global,Map<Integer,List<Integer>> courseMap,int node){
        List<Integer> nexts = courseMap.get(node);
        if(nexts.isEmpty()){
            return true;
        }
        for (Integer next : nexts) {
            if (visited.contains(next)) {
                return false;
            }
            if(global.contains(next)){
                continue;
            }
            Set<Integer> copy = new HashSet<>();
            copy.addAll(visited);
            copy.add(next);
            global.add(next);
            boolean cycle = traverse(copy,global, courseMap, next);
            if (!cycle) {
                return false;
            }
        }
        return true;
    }
}
