package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 9/12/2019.
 * 518. Coin Change 2
 Medium

 908

 38

 Favorite

 Share
 You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



 Example 1:

 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 Example 2:

 Input: amount = 3, coins = [2]
 Output: 0
 Explanation: the amount of 3 cannot be made up just with coins of 2.
 Example 3:

 Input: amount = 10, coins = [10]
 Output: 1


 Note:

 You can assume that

 0 <= amount <= 5000
 1 <= coin <= 5000
 the number of coins is less than 500
 the answer is guaranteed to fit into signed 32-bit integer
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins.length==0){
            return 0;
        }
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = coins.length-1; i > -1; i--) {
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = getDP(dp,i+1,j)+getDP(dp,i,j-coins[i]);
            }
        }
        return dp[0][amount];
    }

    private int getDP(int[][] dp, int i, int j){
        if(i<0||i>dp.length-1||j<0||j>dp[0].length-1){
            return 0;
        }
        return dp[i][j];
    }

    private int rec(int amount,int[] coins,int index){
        if(index>coins.length-1){
            return 0;
        }
       if(amount<0){
           return 0;
       }
       if(amount==0){
           return 1;
       }
       return rec(amount,coins,index+1)+rec(amount-coins[index],coins,index);
    }


}
