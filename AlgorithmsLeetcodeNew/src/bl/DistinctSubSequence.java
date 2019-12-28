package bl;

/**
 * Created by Akshay Hegde on 6/3/2019.
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).


 */
public class DistinctSubSequence {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0){
                    dp[i][j] = 1;
                }
                else if(j==0 || j<i){
                    dp[i][j] = 0;
                }
                else if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
