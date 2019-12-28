//import java.util.Arrays;
//
///**
// * Created by Akshay Hegde on 10/10/2019.
// * 698. Partition to K Equal Sum Subsets
// Medium
//
// 1057
//
// 60
//
// Favorite
//
// Share
// Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
//
//
//
// Example 1:
//
// Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
// Output: True
// Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//
//
// Note:
//
// 1 <= k <= len(nums) <= 16.
// 0 < nums[i] < 10000.
//
// */
//public class PartitionToKSubSet {
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum =0;
//        for (int num:nums){
//            sum+=num;
//        }
//        if(sum%k!=0){
//            return false;
//        }
//        int groupSum = sum/k;
//        return
//
//    }
//
//    private boolean backtrack(int[] nums,boolean[] taken,int index,int rem){
//        if(rem==0){
//            return true;
//        }
//        if(index==nums.length){
//            return false;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if(canTake(nums,rem,nums[i],taken)){
//                taken[i] = true;
//                if(!backtrack(nums, taken, i + 1, rem - nums[i])){
//                    taken[i] =false;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean canTake(int[] nums, int rem, int index,boolean[] taken) {
//        return !taken[index] && rem - nums[index] > 0;
//    }
//}
