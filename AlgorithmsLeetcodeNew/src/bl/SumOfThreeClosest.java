package bl;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Akshay Hegde on 3/23/2019.
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class SumOfThreeClosest {
    public int threeSumClosest(int[] nums, int target) {
        ArrayList<Integer> num = new ArrayList<>(nums.length);
        for (int num1 : nums) {
            num.add(num1);
        }
        int closest = Integer.MAX_VALUE;
        int ret = closest;
        Collections.sort(num);
        int prevNum =num.get(0);
        for (int i = 0; i <num.size()-2 ; i++) {
            if(i!=0&&num.get(i)==prevNum){
                continue;
            }
            prevNum = num.get(i);
            int l= i+1;
            int r= num.size()-1;
            while(l<r) {
                if (num.get(l) + num.get(r) + num.get(i) == target) {
                    return target;
                }
                else{
                    int diff = num.get(l) + num.get(r) + num.get(i)-target;
                    if(Math.abs(diff)<closest){
                        closest = Math.abs(diff);
                        ret = num.get(l) + num.get(r) + num.get(i);
                    }
                    if(diff>0){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(new SumOfThreeClosest().threeSumClosest(nums,1));
    }
}
