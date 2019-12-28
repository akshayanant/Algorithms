package bl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Akshay Hegde on 7/16/2019.
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Example 1:

 Input: [3,6,9,1]
 Output: 3
 Explanation: The sorted form of the array is [1,3,6,9], either
 (3,6) or (6,9) has the maximum difference 3.
 Example 2:

 Input: [10]
 Output: 0
 Explanation: The array contains less than 2 elements, therefore return 0.
 Note:

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 Try to solve it in linear time/space.

 */
public class MaxGap {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num :  nums){
            set.add(num);
        }
        int maxGap = 0;
        for (int num : nums) {
            int j = num - 1;
            while (j > -1) {
                if(set.contains(j)){
                    int gap = num-j;
                    if(maxGap<gap){
                        maxGap = gap;
                    }
                    break;
                }
                j--;
            }
        }
        return maxGap;
    }
}
