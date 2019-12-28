package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akshay Hegde on 8/29/2019.
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 Note: The algorithm should run in linear time and in O(1) space.

 Example 1:

 Input: [3,2,3]
 Output: [3]
 Example 2:

 Input: [1,1,1,3,3,2,2,2]
 Output: [1,2]

 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        int th = nums.length/3;
        for (int i = 0; i < nums.length-th; i++) {
            if(nums[i]==nums[i+th]){
                res.add(nums[i]);
                int j = i+1;
                while (j<nums.length-th&&nums[j]==nums[i]){
                    j++;
                }
                i=j-1;
            }
        }
        return res;
    }
}
