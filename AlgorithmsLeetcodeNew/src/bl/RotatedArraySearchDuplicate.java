package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/23/2019.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 You are given a target value to search. If found in the array return true, otherwise return false.

 Example 1:

 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:

 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 Follow up:

 This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 Would this affect the run-time complexity? How and why?
 */
public class RotatedArraySearchDuplicate {

    public boolean search(int[] nums, int target) {
        List<Integer> removeRepeat = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                removeRepeat.add(num);
                set.add(num);
            }
        }
        int[] newNums = new int[removeRepeat.size()];
        for (int i = 0; i < removeRepeat.size(); i++) {
            newNums[i] = removeRepeat.get(i);
        }
        return searcRec(newNums, 0, nums.length - 1, target);
    }

    private boolean searcRec(int[] nums, int l, int h, int tar) {
        if (l > h) {
            return false;
        }
        if(nums[l]==tar||nums[h]==tar){
            return true;
        }
        int mid = (l + h) / 2;
        if (nums[mid] == tar) {
            return true;
        }
        //it means first half is sorted
        if (nums[l] <= nums[mid]) {
            if (tar <= nums[mid] && tar >= nums[l]) {
                return searcRec(nums, l, mid - 1, tar);
            }
            return searcRec(nums, mid + 1, h, tar);
        }
        //if not first half then second half must be sorted
        if (tar >= nums[mid] && tar <= nums[h]) {
            return searcRec(nums, mid + 1, h, tar);
        }
        return searcRec(nums, l, mid - 1, tar);
    }
}