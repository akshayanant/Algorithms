package bl;

/**
 * Created by Akshay Hegde on 5/9/2019.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class RotatedArraySearch {
    public int search(int[] nums, int target) {
       return searcRec(nums,0,nums.length-1,target);
    }

    private int searcRec(int[] nums, int l, int h, int tar){
        if(l>h){
            return -1;
        }
        int mid = (l+h)/2;
        if(nums[mid]==tar){
            return mid;
        }
        //it means first half is sorted
        if(nums[l]<=nums[mid]){
            if(tar<=nums[mid]&&tar>=nums[l]){
                return searcRec(nums,l,mid-1,tar);
            }
            return searcRec(nums,mid+1,h,tar);
        }
        //if not first half then second half must be sorted
        if(tar>=nums[mid]&&tar<=nums[h]){
            return searcRec(nums,mid+1,h,tar);
        }
        return searcRec(nums,l,mid-1,tar);
    }
}
