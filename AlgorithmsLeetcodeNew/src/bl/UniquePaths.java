package bl;

/**
 * Created by Akshay Hegde on 5/17/2019.
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 7 x 3 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.

 Example 1:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 Example 2:

 Input: m = 7, n = 3
 Output: 28
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = m-1; i > -1; i--) {
            for (int j = n-1; j > -1; j--) {
                if(i==m-1 && j==n-1){
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
