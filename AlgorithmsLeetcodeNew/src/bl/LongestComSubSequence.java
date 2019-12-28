package bl;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 1143. Longest Common Subsequence
 Medium

 226

 8

 Favorite

 Share
 Given two strings text1 and text2, return the length of their longest common subsequence.

 A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



 If there is no common subsequence, return 0.



 Example 1:

 Input: text1 = "abcde", text2 = "ace"
 Output: 3
 Explanation: The longest common subsequence is "ace" and its length is 3.
 Example 2:

 Input: text1 = "abc", text2 = "abc"
 Output: 3
 Explanation: The longest common subsequence is "abc" and its length is 3.
 Example 3:

 Input: text1 = "abc", text2 = "def"
 Output: 0
 Explanation: There is no such common subsequence, so the result is 0.


 Constraints:

 1 <= text1.length <= 1000
 1 <= text2.length <= 1000
 The input strings consist of lowercase English characters only.

 */
public class LongestComSubSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0||text2.length()==0){
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1+getDP(dp,i-1,j-1);
                }
                else{
                    dp[i][j] = Math.max(getDP(dp,i-1,j),getDP(dp,i,j-1));
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }

    private int getDP(int[][] dp, int i,int j){
        if(i<0||j<0){
            return 0;
        }
        return dp[i][j];
    }
}
