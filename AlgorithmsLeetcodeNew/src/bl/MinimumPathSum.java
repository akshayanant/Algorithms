package bl;

/**
 * Created by Akshay Hegde on 5/18/2019.
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] gridDP = new int[m][n];
        for (int i = m-1; i > -1; i--) {
            for (int j = n-1; j > -1; j--) {
                if(i==m-1 && j==n-1){
                    gridDP[i][j] = grid[i][j];
                }
                else if(j+1==n){
                    gridDP[i][j] = grid[i][j]+gridDP[i+1][j];
                }
                else if(i+1==m){
                    gridDP[i][j] = gridDP[i][j+1] + grid[i][j];
                }
                else{
                    gridDP[i][j] = grid[i][j] + (Math.max(gridDP[i][j+1],gridDP[i+1][j]));
                }
            }
        }
        return gridDP[0][0];
    }
}
