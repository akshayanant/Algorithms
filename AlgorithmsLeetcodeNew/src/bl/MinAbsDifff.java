package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/21/2019.
 * 5197. Minimum Absolute Difference
 User Accepted:0
 User Tried:0
 Total Accepted:0
 Total Submissions:0
 Difficulty:Easy
 Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

 Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

 a, b are from arr
 a < b
 b - a equals to the minimum absolute difference of any two elements in arr


 Example 1:

 Input: arr = [4,2,1,3]
 Output: [[1,2],[2,3],[3,4]]
 Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 Example 2:

 Input: arr = [1,3,6,10,15]
 Output: [[1,3]]
 Example 3:

 Input: arr = [3,8,-10,23,19,-4,-14,27]
 Output: [[-14,-10],[19,23],[23,27]]


 Constraints:

 2 <= arr.length <= 10^5
 -10^6 <= arr[i] <= 10^6

 */
public class MinAbsDifff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min =Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]-arr[i]<min){
                min = arr[i+1]-arr[i];
            }
        }
        List<List<Integer>> res =  new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]+min == arr[i+1]){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                res.add(pair);
            }
        }
        return res;
    }
}
