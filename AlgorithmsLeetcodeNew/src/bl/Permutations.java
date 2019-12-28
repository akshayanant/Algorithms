package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/12/2019.
 *
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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
        }
            for (int i = l; i < nums.length; i++) {
                swap(nums,i,l);
                recusrsion(nums,l+1,res);
                swap(nums,i,l);
            }
    }

    private void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
