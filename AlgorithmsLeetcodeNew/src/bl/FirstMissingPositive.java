package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 5/11/2019.
 *
 * Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int i = 1; ; i++) {
            if(!map.containsKey(i)){
                return i;
            }
        }
    }

}
