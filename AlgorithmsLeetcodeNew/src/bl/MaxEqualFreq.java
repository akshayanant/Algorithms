//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Akshay Hegde on 10/12/2019.
// * 5225. Maximum Equal Frequency
// User Accepted:20
// User Tried:224
// Total Accepted:20
// Total Submissions:512
// Difficulty:Hard
// Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.
//
// If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
//
//
//
// Example 1:
//
// Input: nums = [2,2,1,1,5,3,3,5]
// Output: 7
// Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
// Example 2:
//
// Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
// Output: 13
// Example 3:
//
// Input: nums = [1,1,1,2,2,2]
// Output: 5
// Example 4:
//
// Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6]
// Output: 8
//
//
// Constraints:
//
// 2 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^5
//
// */
//public class MaxEqualFreq {
//    public int maxEqualFreq(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int res=0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if(checkRemove(map)){
//                    res = Math.max(res,j-i);
//                }
//                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
//            }
//        }
//        return res;
//    }
//
//    private boolean checkRemove(Map<Integer,Integer> map){
//        boolean first = true;
//        int prev =0;
//        for(int key:map.keySet()){
//            if(first){
//                prev = map.get(key);
//                first = false;
//            }
//            else{
//                if(map.get(key)!=prev){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}
