package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/10/2019.
 * 862. Shortest Subarray with Sum at Least K
 Hard

 592

 16

 Favorite

 Share
 Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

 If there is no non-empty subarray with sum at least K, return -1.



 Example 1:

 Input: A = [1], K = 1
 Output: 1
 Example 2:

 Input: A = [1,2], K = 4
 Output: -1
 Example 3:

 Input: A = [2,-1,2], K = 3
 Output: 3


 Note:

 1 <= A.length <= 50000
 -10 ^ 5 <= A[i] <= 10 ^ 5
 1 <= K <= 10 ^ 9

 */
public class ShortestSubArraySum {


    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList<>(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());
            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestSubArraySum().shortestSubarray(new int[]{17,85,93,-45,-21},150));
    }

}
