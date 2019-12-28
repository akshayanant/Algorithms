package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/23/2019.
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            List<Integer> comb = new ArrayList<>();
            recursion(nums,0,i,comb,res,nums.length);
        }
        return res;
    }

    private void recursion(int[] nums,int start, int k, List<Integer> comb, List<List<Integer>> res,int n){
        if(k==0){
            res.add(comb);
            return;
        }
        for (int i = start; i <n-k+1 ; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(comb);
            list.add(nums[i]);
            recursion(nums,i + 1, k - 1, list, res,n);
        }
    }
}
