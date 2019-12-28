package bl;

/**
 * Created by Akshay Hegde on 5/29/2019.
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 Example 1:

 Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 Output: true
 Example 2:

 Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 Output: false
 */
public class InterLeavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < s1.length()+1; i++) {
            if(s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < s2.length()+1; i++) {
            if(s2.charAt(i-1)==s3.charAt(i-1)){
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s2.charAt(j)==s3.charAt(i+j+1)){
                    dp[i+1][j+1] = dp[i+1][j];
                }
                if(s1.charAt(i)==s3.charAt(i+j+1)){
                    dp[i+1][j+1] = dp[i+1][j+1]||dp[i][j+1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
