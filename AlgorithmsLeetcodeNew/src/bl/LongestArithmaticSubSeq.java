package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 5214. Longest Arithmetic Subsequence of Given Difference
 User Accepted:758
 User Tried:1287
 Total Accepted:760
 Total Submissions:1809
 Difficulty:Medium
 Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.



 Example 1:

 Input: arr = [1,2,3,4], difference = 1
 Output: 4
 Explanation: The longest arithmetic subsequence is [1,2,3,4].
 Example 2:

 Input: arr = [1,3,5,7], difference = 1
 Output: 1
 Explanation: The longest arithmetic subsequence is any single element.
 Example 3:

 Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 Output: 4
 Explanation: The longest arithmetic subsequence is [7,5,3,1].

 */
public class LongestArithmaticSubSeq {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int max  =1;
        for (int anArr : arr) {
            if (map.containsKey(anArr - difference)) {
                int count = map.get(anArr - difference);
                count++;
                map.put(anArr, count);
                max = Math.max(max, count);
            }
            else {
                map.put(anArr,1);
            }
        }
        return max;
    }
}
