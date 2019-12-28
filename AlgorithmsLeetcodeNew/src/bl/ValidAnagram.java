package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 9/4/2019.
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sChar = String.valueOf(chars);
        chars = t.toCharArray();
        Arrays.sort(chars);
        String tChar = String.valueOf(chars);
        return sChar.equals(tChar);
    }
}
