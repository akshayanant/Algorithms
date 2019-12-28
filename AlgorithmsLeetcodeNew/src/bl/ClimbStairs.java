package bl;

/**
 * Created by Akshay Hegde on 9/4/2019.
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 Note:
 cost will have a length in the range [2, 1000].
 Every cost[i] will be an integer in the range [0, 999].

 */
public class ClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        return recursion(cost,0);
    }

    private int recursion(int[] cost,int index){
        if(index>=cost.length-1){
            return 0;
        }
        return Math.min(
                cost[index]+recursion(cost,index+1),
                cost[index+1]+recursion(cost,index+2)
        );
    }

    private int dp(int[] cost){
        int[] dp = new int[cost.length];
        for (int i = cost.length-2; i >-1; i--) {
            dp[i] = Math.min(cost[i]+getDP(dp,i+1),cost[i+1]+getDP(dp,i+2));
        }
        return dp[0];
    }

    private int getDP(int[] dp, int index){
        if(index>=dp.length){
            return 0;
        }
        return dp[index];
    }
}
