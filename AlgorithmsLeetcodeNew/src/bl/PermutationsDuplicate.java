package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/12/2019.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class PermutationsDuplicate {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            integers.add(num);
        }
        Collections.sort(integers);
        for (int i = 0; i < integers.size(); i++) {
            nums[i] = integers.get(i);
        }
        recusrsion(nums,0,res);
        return res;
    }

    private void recusrsion(int[] nums,int l,List<List<Integer>> res){
        if(l==nums.length-1) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            res.add(perm);
            return;
        }
        Map<Integer,Boolean> swapMap = new HashMap<>();
        for (int i = l; i < nums.length; i++) {
            if(canSwap(swapMap,nums,i)) {
                swap(nums, i, l);
                recusrsion(nums, l + 1, res);
                swap(nums, i, l);
            }
        }
    }

    private void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean canSwap(Map<Integer,Boolean> swapMap, int[] nums,int j){
        if(swapMap.containsKey(nums[j])){
            return false;
        }
        swapMap.put(nums[j],true);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsDuplicate().permuteUnique(new int[]{1,1,2}));
    }
}
