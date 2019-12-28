package bl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshay Hegde on 10/6/2019.
 * 349. Intersection of Two Arrays
 Easy

 491

 900

 Favorite

 Share
 Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Note:

 Each element in the result must be unique.
 The result can be in any order.

 */
public class IntersectionArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int aNums1 : nums1) {
            set.add(aNums1);
        }
        List<Integer> res = new ArrayList<>();
        for (int aNums2 : nums2) {
            if (set.contains(aNums2)) {
                res.add(aNums2);
                set.remove(aNums2);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
