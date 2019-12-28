package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/18/2019.
 * 350. Intersection of Two Arrays II
 Easy

 863

 300

 Favorite

 Share
 Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
public class IntersectionOfTowArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0||n==0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;
        while (i<m&&j<n){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        int[] ans = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }
}
