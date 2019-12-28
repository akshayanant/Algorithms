package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/14/2019.
 * 594. Longest Harmonious Subsequence
 Easy

 471

 66

 Favorite

 Share
 We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:

 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].


 Note: The length of the input array will not exceed 20,000.

 */
public class LongestHarmoniusSubSeq {
    public int findLHS(int[] nums) {
        int max =0;
        for (int i = 0; nums.length-i>max; i++) {
            int num = nums[i];
            int sameCount =1;
            int nextCount =0;
            int prevCount = 0;
            for (int j = i+1; j < nums.length; j++) {
                if(num==nums[j]){
                    sameCount++;
                }
                else if(num+1==nums[j]){
                    nextCount++;
                }
                else if(num-1==nums[j]){
                    prevCount++;
                }
            }
            if(nextCount!=0||prevCount!=0){
                max = Math.max(sameCount+Math.max(nextCount,prevCount),max);
            }
        }
        return max;
    }

    private int opt(int[] nums){
        Map<Integer,Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        int max =0;
        for (int num : nums) {
            int prevCount = numCount.getOrDefault(num - 1, 0);
            int nextCount = numCount.getOrDefault(num + 1, 0);
            int curCount = numCount.get(num);
            if (prevCount != 0 || nextCount != 0) {
                max = Math.max(max, curCount + Math.max(prevCount, nextCount));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,1,3,4,2,2,5,4,2,3,4,7};
        System.out.println(new LongestHarmoniusSubSeq().opt(input));
    }
}
