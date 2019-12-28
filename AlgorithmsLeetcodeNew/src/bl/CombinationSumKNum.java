package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 8/27/2019.
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Note:

 All numbers will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: k = 3, n = 7
 Output: [[1,2,4]]
 Example 2:

 Input: k = 3, n = 9
 Output: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class CombinationSumKNum {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(k,n,1,null,res);
        return res;
    }

    private void recursion(int k, int n,int start,List<Integer> nums, List<List<Integer>> res){
       if(k==1){
           if(start<=n&&n<10){
               List<Integer> list = new ArrayList<>();
               list.addAll(nums);
               list.add(n);
               res.add(list);
           }
           return;
       }
        for (int i = start; i < 10; i++) {
            if(n-i<i){
                return;
            }
            List<Integer> copy = new ArrayList<>();
            if(nums!=null){
                copy.addAll(nums);
            }
            copy.add(i);
            recursion(k-1,n-i,i+1,copy,res);
        }

    }
}
