package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/10/2019.
 * 560. Subarray Sum Equals K
 Medium

 2553

 71

 Favorite

 Share
 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,1);
        int count = 0;
        int runSum =0;
        for (int num : nums) {
            runSum += num;
            count+=sumMap.getOrDefault(runSum-k,0);
            sumMap.put(runSum,sumMap.getOrDefault(runSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySumEqualsK().subarraySum(new int[]{1,4,6,-2,-10,7,0},-2));
    }
}
