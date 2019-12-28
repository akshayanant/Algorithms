package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 9/12/2019.
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Note:
 You may assume that you have an infinite number of each kind of coin.

 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        Arrays.sort(coins);
        int res=  rec(coins,amount,0);
        return (res==Integer.MAX_VALUE?-1:res);
    }

    private int rec(int[] coins,int amount, int index){
        if(index>coins.length-1){
            return Integer.MAX_VALUE;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        int include = amount-coins[index];
        if(include==0){
            return 1;
        }
        int first = rec(coins,include,index);
        if(first!=Integer.MAX_VALUE){
            first = first+1;
        }
        int second = rec(coins,include,index+1);
        if(second!=Integer.MAX_VALUE){
            second = second+1;
        }
        int third = rec(coins,amount,index+1);
        return Math.min(Math.min(first,second),third);
    }

    private int dp(int[] coins,int amount){
        int[][] dp = new int[coins.length][amount+1];
        for (int i = coins.length-1; i > -1; i--) {
            for (int j = 1; j < amount+1; j++) {
                dp[i][j] = -1;
                int first = getDP(dp,i,j-coins[i]);
                if(first!=-1){
                    dp[i][j] = 1+first;
                }
                int second = getDP(dp,i+1,j-coins[i]);
                if(second!=-1){
                    dp[i][j] = dp[i][j]==-1?1+second:Math.min(dp[i][j],1+second);
                }
                int third = getDP(dp,i+1,j);
                if(third!=-1){
                    dp[i][j] = dp[i][j]==-1?third:Math.min(dp[i][j],third);
                }
            }
        }
        return dp[0][amount];
    }

    private int getDP(int[][] dp,int i,int j){
        if(i<0||i>dp.length-1||j<0||j>dp[0].length-1){
            return -1;
        }
        return dp[i][j];
    }
}
