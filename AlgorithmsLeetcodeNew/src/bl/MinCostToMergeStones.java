package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/8/2019.
 * There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.

 A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.

 Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.



 Example 1:

 Input: stones = [3,2,4,1], K = 2
 Output: 20
 Explanation:
 We start with [3, 2, 4, 1].
 We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 We merge [5, 5] for a cost of 10, and we are left with [10].
 The total cost was 20, and this is the minimum possible.
 Example 2:

 Input: stones = [3,2,4,1], K = 3
 Output: -1
 Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
 Example 3:

 Input: stones = [3,5,1,2,6], K = 3
 Output: 25
 Explanation:
 We start with [3, 5, 1, 2, 6].
 We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
 We merge [3, 8, 6] for a cost of 17, and we are left with [17].
 The total cost was 25, and this is the minimum possible.


 Note:

 1 <= stones.length <= 30
 2 <= K <= 30
 1 <= stones[i] <= 100

 */
public class MinCostToMergeStones {
    public int mergeStones(int[] stones, int K) {
        if(stones.length==1){
            return 0;
        }
        List<Integer> input = new ArrayList<>();
        for (int stone : stones) {
            input.add(stone);
        }
        return recursion(input,K);
    }

    private int recursion(List<Integer> stones, int k){
        if(k>stones.size()){
            return -1;
        }
        int min =Integer.MAX_VALUE;
        for (int i = 0; i <= stones.size()-k; i++) {
            int sum =0;
            for (int j = i; j <i+k ; j++) {
                sum+=stones.get(j);
            }
            List<Integer> copy = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                copy.add(stones.get(j));
            }
            copy.add(sum);
            for (int j = i+k; j < stones.size(); j++) {
                copy.add(stones.get(j));
            }
            if(copy.size()>1){
                int rec = recursion(copy,k);
                if(rec==-1){
                    continue;
                }
                int res = rec+sum;
                if(res<min){
                    min = res;
                }
            }
            else{
                if(sum<min){
                    min = sum;
                }
            }
        }
        return min!=Integer.MAX_VALUE?min:-1;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToMergeStones().mergeStones(new int[]{69,39,79,78,16,6,36,97,79,27,14,31,4},2));
    }
}
