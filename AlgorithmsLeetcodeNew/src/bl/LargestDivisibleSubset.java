package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/7/2019.
 * 368. Largest Divisible Subset
 Medium

 639

 33

 Favorite

 Share
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

 Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 Input: [1,2,3]
 Output: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 Input: [1,2,4,8]
 Output: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> dp = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            dp.add(new ArrayList<>());
        }
        Arrays.sort(nums);
        for (int i = nums.length-1; i > -1; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            int max = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]%nums[i]==0){
                    if(dp.get(j).size()>dp.get(max).size()){
                        max = j;
                    }
                }
            }
            if(max!=i){
                list.addAll(dp.get(max));
            }
            dp.remove(i);
            dp.add(i,list);
            if(res.size()<dp.get(i).size()){
                res = dp.get(i);
            }
        }
        return res;
    }
}
