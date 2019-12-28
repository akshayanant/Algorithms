package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 8/18/2019.
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 Note:

 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        int i =0;
        int j = k;
        while (i<nums.length){
            res[j%nums.length] = nums[i];
            i++;
            j++;
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
        }

        private void inPlace(int[] nums,int k){
        if(nums.length==1){
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            for (int j = 0; j < nums.length; j++) {
                int swap = nums[(j+1)%nums.length];
                nums[(j+1)%nums.length] = temp;
                temp = swap;
            }
        }
    }
}
