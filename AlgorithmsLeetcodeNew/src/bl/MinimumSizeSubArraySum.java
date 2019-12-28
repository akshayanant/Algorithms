package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 8/23/2019.
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 Example:

 Input: s = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 Follow up:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

 */
public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum =0;
        int left =0;
        int minLen = nums.length+1;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum>=s){
                minLen = Math.min(minLen,i+1-left);
                sum-=nums[left++];
            }
        }
        return minLen==nums.length+1?0:minLen;
    }
}
