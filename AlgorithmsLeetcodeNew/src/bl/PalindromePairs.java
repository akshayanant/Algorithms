package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/10/2019.
 * 336. Palindrome Pairs
 Hard

 949

 128

 Favorite

 Share
 Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:

 Input: ["abcd","dcba","lls","s","sssll"]
 Output: [[0,1],[1,0],[3,2],[2,4]]
 Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 Example 2:

 Input: ["bat","tab","cat"]
 Output: [[0,1],[1,0]]
 Explanation: The palindromes are ["battab","tabbat"]

 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        int m = words.length;
        String[] rev = new String[m];
        for (int i = 0; i < m; i++) {
            rev[i] = rev(words[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(m<=1){
            return res;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(i==j){
                    continue;
                }
                if(words[i].equals(rev[j])){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private String rev(String s){
        StringBuilder rev = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            rev.insert(0, s.charAt(i));
        }
        return rev.toString();
    }
}
