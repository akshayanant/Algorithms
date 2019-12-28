package bl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 454. 4Sum II
 Medium

 807

 62

 Favorite

 Share
 Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int[][] tuples = new int[4][];
        tuples[0] = A;
        tuples[1] = B;
        tuples[2] = C;
        tuples[3] = D;
        return rec(tuples,3,0);
    }

    private int rec(int[][] tuples,int index,int sum){
        if(index<0){
            if(sum==0){
                return 1;
            }
            return 0;
        }
        int count =0;
        for (int i = 0; i < tuples[0].length; i++) {
            count+=rec(tuples,index-1,sum+tuples[index][i]);
        }
        return count;
    }

    private int pointers(int[] A,int[] B, int[] C,int[] D){
        int count = 0;
        Map<Integer,Integer> pairsMap = new HashMap<>();
        for (int aA : A) {
            for (int aB : B) {
                int sum = aA + aB;
                pairsMap.put(sum, pairsMap.getOrDefault(sum, 0) + 1);
            }
        }
        for (int aC : C) {
            for (int aD : D) {
                count += pairsMap.getOrDefault(0 - aC - aD, 0);
            }
        }
        return count;
    }
}
