package bl;

/**
 * Created by Akshay Hegde on 6/26/2019.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 The array may contain duplicates.

 Example 1:

 Input: [1,3,5]
 Output: 1
 Example 2:

 Input: [2,2,2,0,1]
 Output: 0
 Note:

 This is a follow up problem to Find Minimum in Rotated Sorted Array.
 Would allow duplicates affect the run-time complexity? How and why?

 */
public class MinInRotatedSortedArrayDuplicates {
    public int findMin(int[] nums) {
        return findMinRec(nums,0,nums.length-1);
    }

    private int findMinRec(int[] nums, int l, int r){
        if(l==r){
            return nums[l];
        }
        int mid = (l+r)/2;
        if(nums[mid+1]<=nums[r]){
            return Math.min(nums[mid+1],findMinRec(nums,l,mid));
        }
        return Math.min(nums[l],findMinRec(nums,mid+1,r));
    }
}
