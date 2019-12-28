package bl;

/**
 * Created by Akshay Hegde on 8/27/2019.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 Example:

 Input:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Output: 4

 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j] = 1+Math.min(Math.min(getInt(dp,i-1,j-1),
                                        getInt(dp,i,j-1)),
                                        getInt(dp,i-1,j));
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return max*max;
    }

    private int getChar(char[][] matrix,int i,int j){
        if(i<0||j<0){
            return 0;
        }
        return matrix[i][j];
    }

    private int getInt(int[][] matrix,int i,int j){
        if(i<0||j<0){
            return 0;
        }
        return matrix[i][j];
    }
}
