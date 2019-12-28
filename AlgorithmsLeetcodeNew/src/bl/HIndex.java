package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 9/6/2019.
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [3,0,6,1,5]
 Output: 3
 Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 */
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        int[] dp = new int[citations.length];
        Arrays.sort(citations);
        if(citations[0]==citations[citations.length-1]){
            return Math.min(citations[0],citations.length);
        }
        dp[citations.length-1]=1;
        int max =1;
        for (int i = citations.length-2; i > -1; i--) {
            dp[i] = Math.min(dp[i+1]+1,citations[i]);
            if(dp[i]==citations[i]){
                return dp[i];
            }
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] in = new int[]{3,0,6,1,5};
        System.out.println(new HIndex().hIndex(in));
    }
}
