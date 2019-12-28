package bl;

/**
 * Created by Akshay Hegde on 9/1/2019.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2
 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int max = nums[0];
        for (int num1 : nums) {
            if (max < num1) {
                max = num1;
            }
        }
        if(max<nums.length){
            return nums.length;
        }
        int[] buf = new int[max];
        for (int i = 0; i <=max; i++) {
            buf[i] = -1;
        }
        for (int num : nums) {
            buf[num] = 0;
        }
        for (int i = 0; i < buf.length; i++) {
            if(buf[i]==-1){
                return i;
            }
        }
        return -1;
    }
}
