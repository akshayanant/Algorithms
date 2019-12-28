package bl;

/**
 * Created by Akshay Hegde on 3/17/2019.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindrome {
    private static int maxLen =1;
    private static StringBuilder sb;

    private String solution(String s){
        if(s.length()==0){
            return "";
        }
        return pal(s);
    }

    private String pal(String s1){
        boolean[][] res = new boolean[s1.length()][s1.length()];
        int maxLen =1;

        for (int i = 0; i < s1.length(); i++) {
            res[i][i] = true;
        }
        int start =0;
        for (int i = 0; i < s1.length() - 1; i++) {
            if(s1.charAt(i)==s1.charAt(i+1)){
                res[i][i+1] = true;
                maxLen =2;
                start = i;
            }
        }

        for (int k = 3; k <=s1.length(); ++k) {
            for (int i = 0; i <s1.length()-k+1 ; ++i) {
                int j = i+k-1;
                if(res[i+1][j-1]&&s1.charAt(i)==s1.charAt(j)){
                    res[i][j] = true;
                    if(maxLen<k){
                        maxLen = k;
                        start =i;
                    }
                }
            }

        }
        return s1.substring(start,maxLen);
    }
}
