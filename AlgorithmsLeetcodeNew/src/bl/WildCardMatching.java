package bl;

/**
 * Created by Akshay Hegde on 5/11/2019.
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "*"
 Output: true
 Explanation: '*' matches any sequence.
 Example 3:

 Input:
 s = "cb"
 p = "?a"
 Output: false
 Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 Example 4:

 Input:
 s = "adceb"
 p = "*a*b"
 Output: true
 Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 Example 5:

 Input:
 s = "acdcb"
 p = "a*c?b"
 Output: false

 */
public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j < p.length()+1; j++) {
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0 && p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1];
                }
                else if(i==0 || j==0){
                    dp[i][j] = false;
                }
                else if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else
                    dp[i][j] = p.charAt(j-1) == '*' && (dp[i - 1][j] || dp[i][j - 1]);
            }
        }
        return dp[s.length()][p.length()];
    }
}
