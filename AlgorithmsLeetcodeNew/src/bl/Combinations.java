package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/22/2019.
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        recursion(1,k,comb,res,n);
        return res;
    }

    private void recursion(int start, int k, List<Integer> comb, List<List<Integer>> res,int n){
        if(k==0){
            res.add(comb);
            return;
        }
        for (int i = start; i <=n-k+1 ; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(comb);
            list.add(i);
            recursion(i + 1, k - 1, list, res,n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(5,3));
    }
}
