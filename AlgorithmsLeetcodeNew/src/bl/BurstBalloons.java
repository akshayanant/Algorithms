package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/6/2019.
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:

 You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 Example:

 Input: [3,1,5,8]
 Output: 167
 Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int k = len+i-1;
                for (int j = i; j <= k; j++) {
                    int left = 1;
                    int right = 1;
                    if(i!=0){
                        left = nums[i-1];
                    }
                    if(k!=nums.length-1){
                        right = nums[k+1];
                    }
                    int bef = 0;
                    int aft = 0;
                    if(i!=j){
                        bef = dp[i][j-1];
                    }
                    if(k!=j){
                        aft = dp[j+1][k];
                    }
                    dp[i][k] = Math.max(dp[i][k],left*right*nums[j]+bef+aft);
                }
            }
        }
        return dp[0][dp[0].length-1];
    }

    private int recursion(List<Integer> list){
        if(list.size()==1){
            return list.get(0);
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            copy.remove(list.get(i));
            int coins = list.get(i)*getLeft(list,i)*getRight(list,i)+recursion(copy);
            if(coins>max){
                max = coins;
            }
        }
        System.out.println(max);
        return max;
    }

    private int getLeft(List<Integer> list,int index){
        if(index==0){
            return 1;
        }
        return list.get(index-1);
    }

    private int getRight(List<Integer> list,int index){
        if(index==list.size()-1){
            return 1;
        }
        return list.get(index+1);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,1,5,8};
        System.out.println(new BurstBalloons().maxCoins(input));
    }
}
