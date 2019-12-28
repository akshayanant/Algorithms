package bl;

/**
 * Created by Akshay Hegde on 5/11/2019.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example:

 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Note:

 You can assume that you can always reach the last index.
 */
public class JumpGame {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for (int i = nums.length-2; i >-1; i--) {
            if(i+nums[i] == nums.length-1){
                dp[i] = 1;
                continue;
            }
            int min = 1+ dp[i+1];
            for (int j = 2;(i+j)<nums.length && j <=nums[i]; j++) {
                if(1+dp[j+i]<min){
                    min = 1+dp[i+j];
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().jump(new int[]{1,2,3}));
    }
}
