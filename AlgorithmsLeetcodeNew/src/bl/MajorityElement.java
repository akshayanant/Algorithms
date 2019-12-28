package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 7/31/2019.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:

 Input: [3,2,3]
 Output: 3
 Example 2:

 Input: [2,2,1,1,1,2,2]
 Output: 2

 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        int major = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int val= map.get(nums[i]);
                val++;
                map.put(nums[i],val);
                if(val>map.get(major)){
                    major = nums[i];
                }
            }
            else{
                map.put(nums[i],1);
            }
        }
        return major;
    }
}
