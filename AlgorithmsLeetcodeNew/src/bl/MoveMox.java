package bl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshay Hegde on 3/7/2020.
 *
 * 1263. Minimum Moves to Move a Box to Their Target Location
 Hard

 148

 9

 Add to List

 Share
 Storekeeper is a game in which the player pushes boxes around in a warehouse trying to get them to target locations.

 The game is represented by a grid of size m x n, where each element is a wall, floor, or a box.

 Your task is move the box 'B' to the target position 'T' under the following rules:

 Player is represented by character 'S' and can move up, down, left, right in the grid if it is a floor (empy cell).
 Floor is represented by character '.' that means free cell to walk.
 Wall is represented by character '#' that means obstacle  (impossible to walk there).
 There is only one box 'B' and one target cell 'T' in the grid.
 The box can be moved to an adjacent free cell by standing next to the box and then moving in the direction of the box. This is a push.
 The player cannot walk through the box.
 Return the minimum number of pushes to move the box to the target. If there is no way to reach the target, return -1.



 Example 1:



 Input: grid = [["#","#","#","#","#","#"],
 ["#","T","#","#","#","#"],
 ["#",".",".","B",".","#"],
 ["#",".","#","#",".","#"],
 ["#",".",".",".","S","#"],
 ["#","#","#","#","#","#"]]
 Output: 3
 Explanation: We return only the number of times the box is pushed.
 Example 2:

 Input: grid = [["#","#","#","#","#","#"],
 ["#","T","#","#","#","#"],
 ["#",".",".","B",".","#"],
 ["#","#","#","#",".","#"],
 ["#",".",".",".","S","#"],
 ["#","#","#","#","#","#"]]
 Output: -1
 Example 3:

 Input: grid = [["#","#","#","#","#","#"],
 ["#","T",".",".","#","#"],
 ["#",".","#","B",".","#"],
 ["#",".",".",".",".","#"],
 ["#",".",".",".","S","#"],
 ["#","#","#","#","#","#"]]
 Output: 5
 Explanation:  push the box down, left, left, up and up.
 Example 4:

 Input: grid = [["#","#","#","#","#","#","#"],
 ["#","S","#",".","B","T","#"],
 ["#","#","#","#","#","#","#"]]
 Output: -1


 Constraints:

 m == grid.length
 n == grid[i].length
 1 <= m <= 20
 1 <= n <= 20
 grid contains only characters '.', '#',  'S' , 'T', or 'B'.
 There is only one character 'S', 'B' and 'T' in the grid.


 */
public class MoveMox {
    class Location{
        int[] box;
        int[] man;
        public Location(int bi,int bj, int mi, int mj){
            box = new int[]{bi,bj};
            man = new int[]{mi,mj};
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(box[0]+""+box[1]+""+man[0]+""+man[1]);
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Location)){
                return false;
            }
            Location item = (Location) obj;
            return box[0]==item.box[0]&&box[1]==item.box[1]&&
                    man[0]==item.man[0]&&man[1]==item.man[1];
        }
    }
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] man = new int[2];
        int[] box = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='S'){
                    man[0] = i;
                    man[1] = j;
                }
                else if(grid[i][j]=='B'){
                    box[0]=i;
                    box[1] = j;
                }
            }
        }
        Location start = new Location(box[0],box[1],man[0],man[1]);
        int res = dfs(grid,start,new HashSet<>());
        return res==Integer.MAX_VALUE?-1:res;
    }

    private int dfs(char[][] grid,Location loc,Set<Location> visit){
        int bi = loc.box[0];
        int bj = loc.box[1];
        int mi = loc.man[0];
        int mj = loc.man[1];
        if(bi<0||bi>grid.length-1||bj<0||bj>grid[0].length||
                mi<0||mi>grid.length-1||mj<0||mj>grid[0].length
                ||grid[bi][bj]=='#'||grid[mi][mj]=='#') return Integer.MAX_VALUE;
        if(grid[bi][bj]=='T') return 0;
        if(visit.contains(loc)) return Integer.MAX_VALUE;
        visit.add(loc);
        List<Location> next = getNext(bi,bj,mi,mj);
        int min  = Integer.MAX_VALUE;
        for(Location nextLoc: next){
            int moves = dfs(grid,nextLoc,visit);
            if(moves==Integer.MAX_VALUE){
                continue;
            }
            int move=0;
            if(bi!=nextLoc.box[0]||bj!=nextLoc.box[1]) move=1;
            min = Math.min(min,moves+move);
        }
        visit.remove(loc);
        return min;
    }

    private List<Location> getNext(int bi, int bj, int mi, int mj){
        List<Location> next = new ArrayList<>();
        int miNew = mi-1;
        int mjNew = mj;
        if(bi==miNew&&bj==mjNew){
            next.add(new Location(bi-1,bj,miNew,mjNew));
        }
        else{
            next.add(new Location(bi,bj,miNew,mjNew));
        }
         miNew = mi+1;
         mjNew = mj;
        if(bi==miNew&&bj==mjNew){
            next.add(new Location(bi+1,bj,miNew,mjNew));
        }
        else{
            next.add(new Location(bi,bj,miNew,mjNew));
        }
         miNew = mi;
         mjNew = mj-1;
        if(bi==miNew&&bj==mjNew){
            next.add(new Location(bi,bj-1,miNew,mjNew));
        }
        else{
            next.add(new Location(bi,bj,miNew,mjNew));
        }
         miNew = mi;
         mjNew = mj+1;
        if(bi==miNew&&bj==mjNew){
            next.add(new Location(bi,bj+1,miNew,mjNew));
        }
        else{
            next.add(new Location(bi,bj,miNew,mjNew));
        }
        return next;
    }
}
