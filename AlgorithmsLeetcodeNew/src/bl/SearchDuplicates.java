package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 10/14/2019.
 * Given a sorted array, A, with possibly duplicated elements, find the indices of the first and last occurrences of a target element, x. Return -1 if the target is not found.

 Example:
 Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
 Output: [6,8]

 Input: A = [100, 150, 150, 153], target = 150
 Output: [1,2]

 Input: A = [1,2,3,4,5,6,10], target = 9
 Output: [-1, -1]
 */
public class SearchDuplicates {
    private int[] search(int[] nums, int target){
        int[] res = new int[]{-1,-1};
        int index = binarySearch(nums,0,nums.length-1,target);
        int left = index;
        int right = index;
        int prevLeft = left;
        int preRight = right;
        while (left!=-1||right!=-1){
            if(left!=-1) {
                left = binarySearch(nums, 0, prevLeft - 1, target);
                if(left!=-1){
                    prevLeft = left;
                }
            }
            if(right!=-1) {
                right = binarySearch(nums, preRight + 1, nums.length-1, target);
                if(right!=-1){
                    preRight = right;
                }
            }
        }
        res[0] = prevLeft;
        res[1] = preRight;
        return res;
    }

    private int binarySearch(int[] nums, int l,int r,int target){
        if(l>r){
            return -1;
        }
        int m = (l+r)/2;
        if(nums[m]==target){
            return m;
        }
        if(nums[m]>target){
            return binarySearch(nums,l,m-1,target);
        }
        return binarySearch(nums,m+1,r,target);
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{1, 2, 2, 2, 2,2, 3, 4, 7, 8, 8};
        int target = 7;
        System.out.println(Arrays.toString(new SearchDuplicates().search(inputs, target)));
    }

}
