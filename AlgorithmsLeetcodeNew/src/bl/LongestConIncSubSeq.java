package bl;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 674. Longest Continuous Increasing Subsequence
 Easy

 508

 101

 Favorite

 Share
 Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 Note: Length of the array will not exceed 10,000.

 */
public class LongestConIncSubSeq {
    public int findLengthOfLCIS(int[] nums) {
        int max =0;
        for (int i = 0; i < nums.length; i++) {
            int j =i+1;
            while (j<nums.length&&nums[j]>nums[j-1]){
                j++;
            }
            max = Math.max(j-i,max);
            i = j-1;
        }
        return max;
    }
}
