package bl;

/**
 * Created by Akshay Hegde on 8/18/2019.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Example 1:

 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.
 Example 2:

 Input: [2,7,9,3,1]
 Output: 12
 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 Total amount you can rob = 2 + 9 + 1 = 12.

 */
public class HouseRobber {
    public int rob(int[] nums) {
        return recursion(nums,0);
    }



    private int recursion(int[] nums,int start){
        if(start>=nums.length){
            return 0;
        }
        if (start==nums.length-1){
            return nums[nums.length-1];
        }
        return Math.max(nums[start]+recursion(nums,start+2),recursion(nums,start+1));
    }

    private int dp(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1]>nums[0]?nums[1]:nums[0];
        for (int i = 2; i <nums.length ; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];
    }
//If houses are arranged circular

    private int dp2(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length-1];
        dp[0] = nums[0];
        dp[1] = nums[1]>nums[0]?nums[1]:nums[0];
        for (int i = 2; i <nums.length-1 ; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        int max = dp[dp.length-1];
        dp[0] = nums[1];
        dp[1] = nums[2]>nums[1]?nums[2]:nums[1];
        for (int i = 3; i <nums.length ; i++) {
            dp[i-1] = Math.max(nums[i]+dp[i-3],dp[i-3]);
        }
        return (max>dp[dp.length-1])?max:dp[dp.length-1];
    }


}
