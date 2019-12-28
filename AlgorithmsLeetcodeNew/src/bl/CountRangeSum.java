package bl;

/**
 * Created by Akshay Hegde on 9/8/2019.
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

 Note:
 A naive algorithm of O(n2) is trivial. You MUST do better than that.

 Example:

 Input: nums = [-2,5,-1], lower = -2, upper = 2,
 Output: 3
 Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.

 */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum =0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if(sum<=upper&&sum>=lower){
                    count++;
                }
            }
        }
        return count;
    }
}
