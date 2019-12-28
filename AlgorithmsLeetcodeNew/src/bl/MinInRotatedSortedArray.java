package bl;

/**
 * Created by Akshay Hegde on 6/26/2019.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Example 1:

 Input: [3,4,5,1,2]
 Output: 1
 Example 2:

 Input: [4,5,6,7,0,1,2]
 Output: 0

 */
public class MinInRotatedSortedArray {
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
