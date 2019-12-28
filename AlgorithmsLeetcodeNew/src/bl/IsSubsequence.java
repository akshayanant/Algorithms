package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/16/2019.
 *
 * 392. Is Subsequence
 Easy

 709

 147

 Favorite

 Share
 Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

 Credits:
 Special thanks to @pbrother for adding this problem and creating all test cases.

 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
       return indexed(s,t);
    }

    private int longestCommonSubsequence(String text1, String text2) {
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

    private boolean indexed(String s, String t){
        List<List<Integer>> indices = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            indices.add(new ArrayList<>());
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            indices.get(ch-'a').add(i);
        }
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            List<Integer> indexList = indices.get(ch-'a');
            if(indexList.isEmpty()){
                return false;
            }
            int removedIndex = indexList.remove(0);
            while (removedIndex<startIndex&&!indexList.isEmpty()){
                removedIndex = indexList.remove(0);
            }
            if(removedIndex<startIndex){
                return false;
            }
            startIndex = removedIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acb";
        String t = "ajhlbgfjhkyc";
        System.out.println(new IsSubsequence().isSubsequence(s,t));
    }
}
