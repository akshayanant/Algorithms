package bl;

/**
 * Created by Akshay Hegde on 10/6/2019.
 *
 * 343. Integer Break
 Medium

 675

 187

 Favorite

 Share
 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 Example 1:

 Input: 2
 Output: 1
 Explanation: 2 = 1 + 1, 1 × 1 = 1.
 Example 2:

 Input: 10
 Output: 36
 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 Note: You may assume that n is not less than 2 and not larger than 58.

 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if(n==3){
            return 2;
        }
        return rec(n);
    }

    private int rec(int n){
        int max =n;
        for (int i = 2; i <= n / 2; i++) {
            max = Math.max(max,(i)*rec(n-i));
        }
        return max;
    }


    private int dp(int n){
        int[] dp = new int[n+1];
        for (int i = 2; i < n+1; i++) {
            dp[i] = i;
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i],j*dp[i-j]);
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().dp(55));
    }
}
