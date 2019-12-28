package bl;

/**
 * Created by Akshay Hegde on 10/14/2019.
 * 485. Max Consecutive Ones
 Easy

 418

 330

 Favorite

 Share
 Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000

 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        nums[0] = nums[0]==1?1:0;
        int max =nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==1){
                nums[i] = nums[i-1]+1;
                max = Math.max(max,nums[i]);
            }
            else{
                nums[i] = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,0,0,0};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(input));
    }
}
