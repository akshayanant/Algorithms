package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/9/2019.
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Example 1:

 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true
 Example 2:

 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false
 Example 3:

 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false
 Example 4:

 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        StringTokenizer tokenizer = new StringTokenizer(str);
        List<String> words = new ArrayList<>();
        while (tokenizer.hasMoreElements()){
            words.add(tokenizer.nextToken());
        }
        if(pattern.length()!=words.size()){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words.get(i))){
                    return false;
                }
            }
            else{
                if(set.contains(words.get(i))){
                    return false;
                }
                map.put(pattern.charAt(i),words.get(i));
                set.add(words.get(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba","dog cat cat fish"));
    }
}


