package bl;

import java.util.List;

/**
 * Created by Akshay Hegde on 10/9/2019.
 * 554. Brick Wall
 Medium

 625

 31

 Favorite

 Share
 There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

 The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

 If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

 You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.



 Example:

 Input: [[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]

 Output: 2

 Explanation:



 Note:

 The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.


 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int width =0;
        for (Integer wid:wall.get(0)){
            width+=wid;
        }
        for (List<Integer> aWall : wall) {
            for (int j = 1; j < aWall.size(); j++) {
                int wid = aWall.remove(j);
                aWall.add(j, wid + aWall.get(j - 1));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < width; ) {
            int count =0;
            int minStep = Integer.MAX_VALUE;
            for (List<Integer> aWall : wall) {
                if (aWall.get(0) == i) {
                    aWall.remove(0);
                } else {
                    count++;
                }
                minStep = Math.min(minStep,aWall.get(0)-i);
            }
            min = Math.min(count,min);
            i+=minStep;
        }
        return min;
    }

}
