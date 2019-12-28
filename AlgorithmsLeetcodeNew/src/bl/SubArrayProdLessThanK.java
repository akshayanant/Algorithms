package bl;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * 713. Subarray Product Less Than K
 * Medium
 * <p>
 * 800
 * <p>
 * 41
 * <p>
 * Favorite
 * <p>
 * Share
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 * Accepted
 */
public class SubArrayProdLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1;
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k){
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(new SubArrayProdLessThanK().numSubarrayProductLessThanK(input, k));
    }

}
