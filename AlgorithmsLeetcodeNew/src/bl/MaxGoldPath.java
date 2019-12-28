package bl;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 5215. Path with Maximum Gold
 User Accepted:331
 User Tried:417
 Total Accepted:333
 Total Submissions:492
 Difficulty:Medium
 In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

 Return the maximum amount of gold you can collect under the conditions:

 Every time you are located in a cell you will collect all the gold in that cell.
 From your position you can walk one step to the left, right, up or down.
 You can't visit the same cell more than once.
 Never visit a cell with 0 gold.
 You can start and stop collecting gold from any position in the grid that has some gold.


 Example 1:

 Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 Output: 24
 Explanation:
 [[0,6,0],
 [5,8,7],
 [0,9,0]]
 Path to get the maximum gold, 9 -> 8 -> 7.
 Example 2:

 Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 Output: 28
 Explanation:
 [[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
 Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.


 Constraints:

 1 <= grid.length, grid[i].length <= 15
 0 <= grid[i][j] <= 100
 There are at most 25 cells containing gold.

 */
public class MaxGoldPath {
    public int getMaximumGold(int[][] grid) {
        int max= 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max,rec(grid,i,j));
            }
        }
        return max;
    }

    private int rec(int[][] grid,int i, int j){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0){
            return 0;
        }
        int[][] copy = new int[grid.length][grid[0].length];
        copyGrid(grid,copy);
        copy[i][j] = 0;
        int left = rec(copy,i,j-1);
        copyGrid(grid,copy);
        copy[i][j] = 0;
        int right = rec(copy,i,j+1);
        copyGrid(grid,copy);
        copy[i][j] = 0;
        int down = rec(copy,i+1,j);
        copyGrid(grid,copy);
        copy[i][j] = 0;
        int top = rec(copy,i-1,j);
        return grid[i][j]+Math.max(Math.max(Math.max(left,right),
                top),down);
    }

    private void copyGrid(int[][] grid,int[][] copy){
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, grid[0].length);
        }
    }
}
