package bl;

import java.util.*;

/**
 *
 * Created by Akshay Hegde on 10/12/2019.
 * 567. Permutation in String
 Medium

 798

 42

 Favorite

 Share
 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



 Example 1:

 Input: s1 = "ab" s2 = "eidbaooo"
 Output: True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:

 Input:s1= "ab" s2 = "eidboaoo"
 Output: False


 Note:

 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].

 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        return s2.length() >= s1.length() && generatePerm(s1.toCharArray(), 0, s2);
    }

    private boolean generatePerm(char[] chars,int l,String s2){
        if (l==chars.length){
            String st = String.valueOf(chars);
            if(s2.contains(st)){
                return true;
            }
        }
        for (int i = l; i < chars.length; i++) {
            swap(chars,i,l);
            String st = String.valueOf(chars);
            if(generatePerm(chars,l+1,s2)){
                return true;
            }
            swap(chars,i,l);
        }
        return false;
    }

    private void swap(char[] chars,int i, int j){
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    private boolean opt(String s1,String s2){
        if(s2.length() < s1.length()){
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        for (int i = 0; i <= s2.length()-s1.length(); i++) {
            if(set.contains(s2.charAt(i))){
                String st2 = s2.substring(i,i+s1.length());
                char[] ch2 = st2.toCharArray();
                Arrays.sort(ch2);
                if(String.valueOf(ch2).equals(String.valueOf(ch1))){
                    return true;
                }
            }
        }
        return false;
    }
}
