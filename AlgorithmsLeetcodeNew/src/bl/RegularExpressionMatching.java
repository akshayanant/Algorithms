package bl;

/**
 * Created by Akshay Hegde on 3/19/2019.
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false


 "mississippi"
 "mis*is*ip*."
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j < p.length()+1; j++) {
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0 && p.charAt(j-1)=='*'){
                    dp[i][j] = getDP(dp,i,j-2);
                }
                else if(i==0 || j==0){
                    dp[i][j] = false;
                }
                else if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1)=='*'){
                    dp[i][j] = getDP(dp,i,j-2);
                    if(getChar(p,j-2)=='.' || getChar(p,j-2)==s.charAt(i-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private char getChar(String s, int i){
        if(i<0){
            return '\u0000';
        }
        return s.charAt(i);
    }

    private boolean getDP(boolean[][] dp, int i, int j) {
        return j < 0 || dp[i][j];
    }

    public static void main(String[] args) {
        String s="aaa";
        String p = "ab*a*c*a";
        System.out.println(new RegularExpressionMatching().isMatch(s,p));
    }
}
