package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * Smallest Difference: Given two arrays of integers, compute the pair of values (one value in each
 array) with the smallest (non-negative) difference. Return the difference.
 EXAMPLE
 Input: {l, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 Output: 3. That is, the pair (11, 8).

 */
public class SmallestDifference {
    private int solution(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        //sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //pointers
        int i=0;
        int j=0;
        int minDiff = Integer.MAX_VALUE;
        while (i<nums1.length&&j<nums2.length){
            //min possible value=0
            if(nums1[i]==nums2[j]){
                return 0;
            }
            int diff = Math.abs(nums1[i]-nums2[j]);
            minDiff = Math.min(minDiff,diff);
            if(nums1[i]>nums2[j]) {
                j++;
            }else {
                i++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,11,12};
        int[] nums2 = new int[]{23,27,19,8};
        System.out.println(new SmallestDifference().solution(nums1,nums2));
    }
}
