package bl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Akshay Hegde on 6/7/2019.
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Your algorithm should run in O(n) complexity.

 Example:

 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCount = 1;
        int count =1;
        for (int num : nums) {
            num--;
            while (set.contains(num)) {
                num--;
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
            count = 0;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] input = new int[]{100,4,200,1,3,2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(input));
    }
}
