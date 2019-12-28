package bl;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * 5230. Check If It Is a Straight Line
 User Accepted:0
 User Tried:0
 Total Accepted:0
 Total Submissions:0
 Difficulty:Easy
 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.





 Example 1:



 Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 Output: true
 Example 2:



 Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 Output: false


 Constraints:

 2 <= coordinates.length <= 1000
 coordinates[i].length == 2
 -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 coordinates contains no duplicate point.

 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean par = false;
        boolean perp=false;
        double slope = 0;
        if(coordinates[1][0]-coordinates[0][0]==0){
            perp  = true;
        }
        if(coordinates[1][1]-coordinates[0][1]==0){
            par  = true;
        }
        else {
            slope = ((double) coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        }
            for (int i = 2; i < coordinates.length; i++) {
                int[] prev = coordinates[i-1];
                int[] cur = coordinates[i];
                if(par){
                    if(prev[1]!=cur[1]){
                        return false;
                    }
                }
                else if(perp) {
                    if (prev[0] != cur[0]) {
                        return false;
                    }
                }
                else if(cur[0] - prev[0]==0) {
                    return false;
                }
                else {
                    double slope2 = ((double) cur[1] - prev[1]) / (cur[0] - prev[0]);
                    if (slope2 != slope) {
                        return false;
                    }
                }
        }
        return true;
    }
}
