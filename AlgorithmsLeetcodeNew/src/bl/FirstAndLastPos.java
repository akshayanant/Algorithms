package bl;

/**
 * Created by Akshay Hegde on 5/9/2019.
 * 34. Find First and Last Position of Element in Sorted Array
 Medium

 1504

 85

 Favorite

 Share
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */
public class FirstAndLastPos {

    public int[] searchRange(int[] nums, int target) {
       int index = binarySearch(nums,0,nums.length-1,target);
       if(index ==-1){
           return new int[]{-1, -1};
       }
       int initIndex = index;
       int prevLeftIndex = index;
       while (index!=-1){
           prevLeftIndex = index;
           index = binarySearch(nums,0,index-1,target);
       }
       int prevRightIndex = index;
       index = initIndex;
       while (index!=-1){
           prevRightIndex = index;
           index = binarySearch(nums,index+1,nums.length-1,target);
       }
       int[] res = new int[2];
       res[0] = prevLeftIndex;
       res[1] = prevRightIndex;
       return res;
    }

    private int binarySearch(int[] nums, int l, int h, int tar){
        if(l>h){
            return -1;
        }
        int mid = (l+h)/2;
        if(nums[mid] == tar){
            return mid;
        }
        if(nums[mid]>tar){
            return binarySearch(nums, l, mid-1, tar);
        }
        return binarySearch(nums, mid+1, h, tar);
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for
    // Find First and Last Position of Element in Sorted Array.
    //Memory Usage: 38.6 MB, less than 99.65% of Java online submissions for
    // Find First and Last Position of Element in Sorted Array.
}
