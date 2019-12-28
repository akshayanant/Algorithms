package bl;

/**
 * Created by Akshay Hegde on 10/21/2019.
 * 494. Target Sum
 Medium

 1680

 80

 Favorite

 Share
 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.

 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return rec(nums,0,nums.length-1,S);
    }

    private int rec(int[] nums, int sum,int index, int target){
        if(index<0){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        return rec(nums,sum+nums[index],index-1,target)+
                rec(nums,sum-nums[index],index-1,target);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(new TargetSum().findTargetSumWays(input,target));
    }
}
