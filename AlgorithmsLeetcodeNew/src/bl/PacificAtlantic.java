package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Akshay Hegde on 12/30/2019.
 *
 * 417. Pacific Atlantic Water Flow
 Medium

 877

 161

 Add to List

 Share
 Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:

 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.


 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).


 A

 */
public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pac  = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(matrix,pac,i,0,0,new boolean[m][n]);
        }
        for(int j=0;j<n;j++){
            dfs(matrix,pac,0,j,0,new boolean[m][n]);
        }
        boolean[][] atl = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(matrix,atl,i,n-1,0,new boolean[m][n]);
        }
        for(int j=0;j<n;j++){
            dfs(matrix,atl,m-1,j,0,new boolean[m][n]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j]&&atl[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, boolean[][] res, int i, int j,int prev,boolean[][] local){
        if(i<0||j<0||i>matrix.length-1||j>matrix[0].length-1||local[i][j]){
            return;
        }
        local[i][j] = true;
        if(matrix[i][j]>=prev){
            res[i][j] = true;
            dfs(matrix,res,i+1,j,matrix[i][j],local);
            dfs(matrix,res,i,j+1,matrix[i][j],local);
            dfs(matrix,res,i-1,j,matrix[i][j],local);
            dfs(matrix,res,i,j-1,matrix[i][j],local);
        }
        local[i][j] = false;
    }

}
