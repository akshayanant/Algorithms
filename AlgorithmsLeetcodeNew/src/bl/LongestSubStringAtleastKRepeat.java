package bl;

/**
 * Created by Akshay Hegde on 10/14/2019.
 * 395. Longest Substring with At Least K Repeating Characters
 Medium

 892

 79

 Favorite

 Share
 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

 */
public class LongestSubStringAtleastKRepeat {
    public int longestSubstring(String s, int k) {
        int max =0;
        for (int i = 0; s.length()-i>max; i++) {
            int[] charCount = new int[26];
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                charCount[ch-'a']++;
                if(kRepeat(charCount,k)){
                   max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    private boolean kRepeat(int[] charCount,int k){
        for (int aCharCount : charCount) {
            if (aCharCount != 0 && aCharCount < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "ababbc";
        int k =2;
        System.out.println(new LongestSubStringAtleastKRepeat().longestSubstring(input,k));
    }


}
