package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 4/14/2019.
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 Example 1:

 Input:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 Output: [0,9]
 Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 The output order does not matter, returning [9,0] is fine too.
 Example 2:

 Input:
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 Output: []
 */
public class SubstringWithConcatOfWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length==0){
            return res;
        }
        int len =0;
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            len += word.length();
        }
        for (int i = 0; i <= s.length()-len; i++) {
            wordList.clear();
            wordList.addAll(Arrays.asList(words));
            String newS = s.substring(i);
            for (int j = 0; j < wordList.size(); j++) {
                if (newS.indexOf(wordList.get(j)) == 0) {
                    newS = newS.substring(wordList.get(j).length());
                    wordList.remove(j);
                    j=-1;
                }
            }
            if(wordList.isEmpty()){
                res.add(i);
            }
        }
        return res;
    }
}
