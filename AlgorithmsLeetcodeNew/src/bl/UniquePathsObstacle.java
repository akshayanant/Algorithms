package bl;

/**
 * Created by Akshay Hegde on 5/18/2019.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 Now consider if some obstacles are added to the grids. How many unique paths would there be?



 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Note: m and n will be at most 100.

 Example 1:

 Input:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right
 */
public class UniquePathsObstacle {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        for (int i = m-1; i > -1; i--) {
            for (int j = n-1; j > -1; j--) {
                if(obstacleGrid[i][j] ==1){
                    grid[i][j] = 0;
                }
                else if(i==m-1 && j==n-1){
                    grid[i][j] = 1;
                }
                else if(j+1==n){
                    grid[i][j] = grid[i+1][j];
                }
                else if(i+1==m){
                    grid[i][j] = grid[i][j+1];
                }
                else{
                    grid[i][j] = grid[i][j+1]+grid[i+1][j];
                }
            }
        }
        return grid[0][0];
    }
}
