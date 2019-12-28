package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/15/2019.
 * 438. Find All Anagrams in a String
 Medium

 1887

 146

 Favorite

 Share
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i)-'a']++;
        }
        for (int i = 0; i <p.length(); i++) {
            sCount[s.charAt(i)-'a']++;
        }
        int i=0;
        List<Integer> res = new ArrayList<>();
        while (i<=s.length()-p.length()){
            if(checkEqual(sCount,pCount)){
                res.add(i);
            }
            sCount[s.charAt(i)-'a']--;
            if(i+p.length()<s.length()) {
                sCount[s.charAt(i + p.length()) - 'a']++;
            }
            i++;
        }
        return res;
    }

    private boolean checkEqual(int[] sCount,int[] pCount){
        for (int i = 0; i < sCount.length; i++) {
            if(sCount[i]!=pCount[i]){
                return false;
            }
        }
        return true;
    }
}
