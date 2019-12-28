package bl;

/**
 * Created by Akshay Hegde on 8/30/2019.
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:

 Each of the array element will not exceed 100.
 The array size will not exceed 200.


 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].


 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.

 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for (int num : nums) {
            sum += num;
        }
        return dp(nums,sum)==0;
    }

    private int minPartition(int[] nums, int index, int total, int sumCalc){
        if(index>nums.length-1){
            return Math.abs((total-sumCalc)-sumCalc);
        }
        return Math.min(minPartition(nums,index+1,total,sumCalc),
                minPartition(nums,index+1,total,sumCalc+nums[index]));
    }

    private int dp(int[] nums,int total){
        int[][] dp = new int[nums.length+1][total+1];
        for (int i = 0; i < total+1; i++) {
            dp[nums.length][i] = Math.abs((total-i)-i);
        }
        int rem = total;
        for (int i = nums.length-1; i > -1; i--) {
            rem-=nums[i];
            for (int j = rem; j >-1 ; j--) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+nums[i]]);
            }
        }
        return dp[0][0];
    }
}
