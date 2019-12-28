package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/26/2019.
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubSetsDuplicate {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            List<Integer> comb = new ArrayList<>();
            recursion(nums, 0, i, comb, res, nums.length);
        }
        return res;
    }

    private void recursion(int[] nums, int start, int k, List<Integer> comb, List<List<Integer>> res, int n) {
        if (k == 0) {
                res.add(comb);
                return;
            }
            Set<Integer> used = new HashSet<>();
            for (int i = start; i < n - k + 1; i++) {
                if (!used.contains(nums[i])) {
                    used.add(nums[i]);
                    List<Integer> list = new ArrayList<>();
                    list.addAll(comb);
                    list.add(nums[i]);
                    recursion(nums, i + 1, k - 1, list, res, n);
                }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubSetsDuplicate().subsetsWithDup(new int[]{1,2,2}));
    }
}
