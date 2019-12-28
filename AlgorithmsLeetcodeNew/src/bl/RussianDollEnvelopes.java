package bl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Akshay Hegde on 10/16/2019.
 * 354. Russian Doll Envelopes
 Hard

 701

 29

 Favorite

 Share
 You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Note:
 Rotation is not allowed.

 Example:

 Input: [[5,4],[6,4],[6,7],[2,3]]
 Output: 3
 Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n==0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(canFit(envelopes[j],envelopes[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    private boolean canFit(int[] boxA,int[] boxB){
        return boxA[0]<boxB[0]&&boxA[1]<boxB[1];
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1,4},{2,7},{8,9},{2,3}};
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(inputs));
    }
}
