package bl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshay Hegde on 6/19/2019.
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.isEmpty()){
            return false;
        }
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        //return recursion(s,set);
        return solDP(s,set);
    }

    private boolean recursion(String s, Set<String> wordDict){
        if(s.length()==0){
            return true;
        }
        for (int i = s.length(); i >-1 ; i--) {
            if(wordDict.contains(s.substring(0,i))){
                if (recursion(s.substring(i),wordDict)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean solDP(String s, Set<String> wordDict){
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++) {
            for (int j = 0; j <s.length()-len; j++) {
                if(wordDict.contains(s.substring(j,j+len+1))){
                    dp[j][j+len] = true;
                }
                else {
                    int row = len+j;
                    int col = len + j - 1;
                    while (row > j && col >= j) {
                        if (dp[row][len + j] && dp[j][col]) {
                            dp[j][len + j] = true;
                            break;
                        }
                        col--;
                        row--;
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
