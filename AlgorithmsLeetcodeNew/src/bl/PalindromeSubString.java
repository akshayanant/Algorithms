package bl;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 647. Palindromic Substrings
 Medium

 1668

 86

 Favorite

 Share
 Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:

 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".


 Example 2:

 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


 Note:

 The input string length won't exceed 1000.

 */
public class PalindromeSubString {
    public int countSubstrings(String s) {
        int res =0;
        for (int i = 0; i < 2*s.length()-1; i++) {
            int left = i/2;
            int right= left+i%2;
            while (left>-1&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                res++;
            }
        }
        return res;
    }
}
