package bl;

/**
 * Created by Akshay Hegde on 9/9/2019.
 * 334. Increasing Triplet Subsequence
 Medium

 986

 97

 Favorite

 Share
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Example 1:

 Input: [1,2,3,4,5]
 Output: true
 Example 2:

 Input: [5,4,3,2,1]
 Output: false

 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int small = Integer.MAX_VALUE;
        int large = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<=small){
                small = nums[i];
            }
            else if(nums[i]<=large){
               large = nums[i];
            }
            else{
                return true;
            }
        }
        return false;
    }
}
