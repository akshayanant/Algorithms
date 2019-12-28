package bl;

/**
 * Created by Akshay Hegde on 10/1/2019.
 * 329. Longest Increasing Path in a Matrix
 Hard

 1236

 22

 Favorite

 Share
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 Input: nums =
 [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Output: 4
 Explanation: The longest increasing path is [1, 2, 6, 9].
 Example 2:

 Input: nums =
 [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Output: 4
 Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */
public class LongestIncPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix.length==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max,rec(matrix,new boolean[matrix.length][matrix[0].length],dp,i,j));
            }
        }
        return max;
    }

    private int rec(int[][] matrix,boolean[][] visit,int[][] dp,int i,int j){
        if(visit[i][j]){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        visit[i][j] = true;
        int max = 1;
        if(getVal(matrix,i,j+1)>matrix[i][j]){
            max = Math.max(max,1+rec(matrix,arrayCopy(visit),dp,i,j+1));
        }
        if(getVal(matrix,i,j-1)>matrix[i][j]){
            max = Math.max(max,1+rec(matrix,arrayCopy(visit),dp,i,j-1));
        }
        if(getVal(matrix,i+1,j)>matrix[i][j]){
            max = Math.max(max,1+rec(matrix,arrayCopy(visit),dp,i+1,j));
        }
        if(getVal(matrix,i-1,j)>matrix[i][j]){
            max = Math.max(max,1+rec(matrix,arrayCopy(visit),dp,i-1,j));
        }
        dp[i][j] = max;
        return max;
    }

    private boolean[][] arrayCopy(boolean[][] visit){
        boolean[][] copy = new boolean[visit.length][visit[0].length];
        for (int i = 0; i < visit.length; i++) {
            System.arraycopy(visit[i], 0, copy[i], 0, visit[0].length);
        }
        return copy;
    }

    private int getVal(int[][] matrix, int i, int j){
        if(i>matrix.length-1||i<0||j<0||j>matrix[0].length-1){
            return Integer.MIN_VALUE;
        }
        return matrix[i][j];
    }
}
