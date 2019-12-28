package bl;

/**
 * Created by Akshay Hegde on 5/16/2019.
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>largest){
                largest = nums[i];
            }
        }
        int sum =0;
        int largeSum =0;
        for (int num : nums) {
            sum += num;
            if (sum < 0) {
                sum = 0;
            }
            if (sum > largeSum) {
                largeSum = sum;
            }
        }
        if(largeSum==0) {
            return largest;
        }
        return largeSum;
    }
}
