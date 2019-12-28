package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




//--------------------INCOMPLETE --------------------------------------------
/**
 * Created by Akshay Hegde on 5/17/2019.
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note:

 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.

 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = 1; i < n+1; i++) {
            num[i-1] = i;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        List<String> lists = new ArrayList<>();
        recusrsion(nums,0,lists,k);
        return lists.get(k-1);
    }

    private boolean recusrsion(List<Integer> nums,int l,List<String> res, int k){
        if(l==nums.size()-1) {
            StringBuilder perm = new StringBuilder();
            for (int num : nums) {
                perm.append(num);
            }
            res.add(perm.toString());
            if(res.size()==k){
                return true;
            }
            return false;
        }
        for (int i = l; i < nums.size(); i++) {
            boolean complex = swap(nums,i,l);
            boolean end = recusrsion(nums,l+1,res,k);
            if(end){
                return true;
            }
            if(!complex) {
                Collections.swap(nums, i, l);
            }
            else{
                reswapComplex(nums,i,l);
            }
        }
        return false;
    }

    private boolean swap(List<Integer> a,int i, int j){
        if(i==j){
            return false;
        }
      Collections.swap(a,i,j);
      if(a.get(j+1)>a.get(i)){
          int val = a.remove(i);
          a.add(j+1,val);
          return true;
      }
      return false;
    }

    private void reswapComplex(List<Integer> a,int i, int j){
        Collections.swap(a,i,j);
        Collections.swap(a,j+1,j);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(new PermutationSequence().getPermutation(3,i));

        }
    }
}
