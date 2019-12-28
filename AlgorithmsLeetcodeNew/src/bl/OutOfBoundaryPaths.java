package bl;

/**
 * Created by Akshay Hegde on 9/10/2019.
 * 576. Out of Boundary Paths
 Medium

 328

 113

 Favorite

 Share
 There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.



 Example 1:

 Input: m = 2, n = 2, N = 2, i = 0, j = 0
 Output: 6
 Explanation:

 Example 2:

 Input: m = 1, n = 3, N = 3, i = 0, j = 1
 Output: 12
 Explanation:



 Note:

 Once you move the ball out of boundary, you cannot move it back.
 The length and height of the grid is in range [1,50].
 N is in range [0,50].

 */
public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N<0){
            return 0;
        }
        if(i<0||i>m-1||j<0||j>n-1){
            return 1;
        }
        return  findPaths(m,n,N-1,i+1,j)+
                findPaths(m,n,N-1,i,j+1)+
                findPaths(m,n,N-1,i-1,j)+
                findPaths(m,n,N-1,i,j-1);
    }

    private int dp(int m, int n, int N, int i, int j){
        int[][][] dp = new int[N+1][m+2][n+2];
        int mod = (int) (Math.pow(10,9)+7);
        for (int p = 0; p <N+1 ; p++) {
            for (int k = 0; k < m + 2; k++) {
                for (int l = 0; l < n + 2; l++) {
                    if (k == 0 || k == m + 1 || l == 0 || l == n + 1) {
                        dp[p][k][l] = 1;
                    }
                }
            }
        }
        for (int p = 1; p <N+1 ; p++) {
            for (int k = 1; k < m + 1; k++) {
                for (int l = 1; l < n + 1; l++) {
                    dp[p][k][l] = ((dp[p-1][k+1][l]%mod)+(dp[p-1][k][l+1]%mod)+
                            (dp[p-1][k-1][l]%mod)+(dp[p-1][k][l-1]%mod)%mod);
                }
            }
        }
        return  (dp[N][i+1][j+1]%mod);
    }

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().dp(2,2,2,0,0));
    }
}
