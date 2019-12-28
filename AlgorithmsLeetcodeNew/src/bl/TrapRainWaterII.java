package bl;

/**
 * Created by Akshay Hegde on 10/13/2019.
 * 407. Trapping Rain Water II
 Hard

 850

 23

 Favorite

 Share
 Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.



 Note:

 Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.



 Example:

 Given the following 3x6 height map:
 [
 [1,4,3,1,3,2],
 [3,2,1,3,2,4],
 [2,3,3,2,3,1]
 ]

 Return 4.


 The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.





 After the rain, water is trapped between the blocks. The total volume of water trapped is 4.

 */
public class TrapRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n =heightMap[0].length;
        int res = 0;
        int[][] dpL = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0){
                    continue;
                }
                dpL[i][j] = Math.max(heightMap[i][j-1],dpL[i][j-1]);
            }
        }
        int[][] dpR = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j > -1; j--) {
                if(j==n-1){
                    continue;
                }
                dpR[i][j] = Math.max(heightMap[i][j+1],dpR[i][j+1]);
            }
        }
        int[][] dpT = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j==0){
                    continue;
                }
                dpT[j][i] = Math.max(heightMap[j-1][i],dpT[j-1][i]);
            }
        }
        int[][] dpD = new int[m][n];
        for (int i = n-1; i > -1; i--) {
            for (int j = 0; j < m; j++) {
                if(j==m-1){
                    continue;
                }
                dpD[j][i] = Math.max(heightMap[j+1][i],dpD[j+1][i]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(Math.min(Math.min(getHeight(dpL,i,j),getHeight(dpR,i,j)),
                        getHeight(dpD,i,j)),getHeight(dpT,i,j));
                res+=(Math.max(0,min-heightMap[i][j]));
            }
        }
        return res;
    }

    private int getHeight(int[][] heights, int i, int j){
        return heights[i][j];
    }
}
