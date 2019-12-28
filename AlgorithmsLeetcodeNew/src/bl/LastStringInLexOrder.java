package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 11/24/2019.
 * 1163. Last Substring in Lexicographical Order
 Hard

 71

 167

 Favorite

 Share
 Given a string s, return the last substring of s in lexicographical order.



 Example 1:

 Input: "abab"
 Output: "bab"
 Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
 Example 2:

 Input: "leetcode"
 Output: "tcode"


 Note:

 1 <= s.length <= 4 * 10^5

 */
public class LastStringInLexOrder {
    class TrieNode{
        Map<Character,TrieNode> children;
        List<Character> letters;
        public TrieNode(){
            children = new HashMap<>();
            letters = new ArrayList<>();
        }
    }

    TrieNode root;

    private void addWord(String word){
        TrieNode node = root;
        int index = 0;
        while(index<word.length()&&node.children.containsKey(word.charAt(index))){
            node = node.children.get(word.charAt(index));
            index++;
        }
        while (index<word.length()){
            node.children.put(word.charAt(index),new TrieNode());
            node.letters.add(word.charAt(index));
            node = node.children.get(word.charAt(index++));
        }
    }

    private String getLargest(){
        TrieNode node = root;
        StringBuilder sb=new StringBuilder();
        while (!node.letters.isEmpty()){
            Collections.sort(node.letters);
            char ch = node.letters.get(node.letters.size()-1);
            sb.append(ch);
            node = node.children.get(ch);
        }
        return sb.toString();
    }

    public String lastSubstring(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            if (res.compareTo(s.substring(i)) < 0) {
                res = s.substring(i);
            }
        }
        return res;
    }
}
