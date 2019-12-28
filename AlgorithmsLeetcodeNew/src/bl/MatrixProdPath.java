package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 10/14/2019.
 */
class MatrixProdPath {

    private int sol(int[][] arr) {
        int m= arr.length;
        int n = arr[0].length;
        int[][] maxDP = new int[m][n];
        int[][] minDP = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    maxDP[i][j] = arr[i][j];
                    minDP[i][j] = arr[i][j];
                    continue;
                }
                int maxVal = Integer.MIN_VALUE;
                int minVal = Integer.MAX_VALUE;
                if(i>0){
                    maxVal = Math.max(Math.max(maxVal,arr[i][j]*maxDP[i-1][j]),arr[i][j]*minDP[i-1][j]);
                    minVal = Math.min(Math.min(minVal,arr[i][j]*maxDP[i-1][j]),arr[i][j]*minDP[i-1][j]);
                }
                if(j>0){
                    maxVal = Math.max(Math.max(maxVal,arr[i][j]*maxDP[i][j-1]),arr[i][j]*minDP[i][j-1]);
                    minVal = Math.min(Math.min(minVal,arr[i][j]*maxDP[i][j-1]),arr[i][j]*minDP[i][j-1]);
                }
                maxDP[i][j] = maxVal;
                minDP[i][j] = minVal;
            }
        }
        System.out.println(Arrays.deepToString(maxDP));
        return maxDP[m-1][n-1];

    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,-9}};
        System.out.println(new MatrixProdPath().sol(input));
    }
}
