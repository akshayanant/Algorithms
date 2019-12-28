package bl;

/**
 * Created by Akshay Hegde on 6/25/2019.
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

 Example 1:

 Input: [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                if (prod > maxProd) {
                    maxProd = prod;
                }
                if (prod == 0) {
                    prod = 1;
                }
            }
        }
        return maxProd;
    }
}
