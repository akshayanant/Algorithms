package bl;

/**
 * Created by Akshay Hegde on 7/19/2019.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

 Note:

 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:

 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

 */
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length-1; i++) {
            int search = search(numbers,i+1,target-numbers[i]);
            if(search!=-1){
                res[0] = i+1;
                res[1] = search+1;
            }
        }
        return res;
    }

    private int search(int[] nums,int start, int tar){
        int l =start;
        int r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==tar){
                return mid;
            }
            if(nums[mid]>tar){
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        return -1;
    }


}
