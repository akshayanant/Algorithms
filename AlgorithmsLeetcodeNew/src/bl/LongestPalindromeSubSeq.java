package bl;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 516. Longest Palindromic Subsequence
 Medium

 1127

 142

 Favorite

 Share
 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".

 */
public class LongestPalindromeSubSeq {
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i+len<s.length(); i++) {
                if(s.charAt(i)==s.charAt(i+len)){
                    dp[i][i+len]= 2+dp[i+1][i+len-1];
                }
                else {
                    dp[i][i+len] = Math.max(dp[i][i+len-1],dp[i+1][i+len]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    private int getDP(int[][] dp,int i, int j){
        if(i+1==j){
            return 0;
        }
        return dp[i+1][j-1];
    }
}
