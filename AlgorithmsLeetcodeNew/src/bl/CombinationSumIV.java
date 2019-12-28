package bl;

/**
 * Created by Akshay Hegde on 10/6/2019.
 *
 * 377. Combination Sum IV
 Medium

 941

 112

 Favorite

 Share
 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.


 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?

 Credits:
 Special thanks to @pbrother for adding this problem and creating all test cases.

 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        return rec(nums,target,0);
    }

    private int rec(int[] nums,int target,int index) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || index > nums.length - 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=rec(nums,target-nums[i],i);
        }
        return sum;
    }

    private int dp(int[] nums,int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < target+1; i++) {
            int sum =0;
            for (int num : nums) {
                sum += getDP(dp, i - num);
            }
            dp[i] = sum;
        }
        return dp[target];
    }

    private int getDP(int[] dp,int i){
        if(i<0){
            return 0;
        }
        return dp[i];
    }
}
