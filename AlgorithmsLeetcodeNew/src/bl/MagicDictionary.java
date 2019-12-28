package bl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Akshay Hegde on 10/13/2019.
 * 676. Implement Magic Dictionary
 Medium

 416

 106

 Favorite

 Share
 Implement a magic directory with buildDict, and search methods.

 For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

 For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

 Example 1:
 Input: buildDict(["hello", "leetcode"]), Output: Null
 Input: search("hello"), Output: False
 Input: search("hhllo"), Output: True
 Input: search("hell"), Output: False
 Input: search("leetcoded"), Output: False
 Note:
 You may assume that all the inputs are consist of lowercase letters a-z.
 For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
 Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.



 /**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

public class MagicDictionary {
    class Trie{
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String s){
            TrieNode node = root;
            int i =0;
            while (i<s.length()&&node.get(s.charAt(i))!=null){
                node = node.get(s.charAt(i++));
            }
            while (i<s.length()) {
                TrieNode newNode = new TrieNode();
                node.put(s.charAt(i), newNode);
                node = node.get(s.charAt(i++));
            }
            node.put(null,null);
        }

        private boolean existsChar(String word,TrieNode node){
            if(node==null){
                return false;
            }
           if(word.length()==0) {
               if (node.contains(null)) {
                   return true;
               }
               return false;
           }
           node = node.get(word.charAt(0));
                return node != null && existsChar(word.substring(1), node);
            }

        private boolean exists(String word){
            Set<Character> characterSet = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                characterSet.add(word.charAt(i));
            }
            TrieNode node =root;
            boolean res;
            for(Character ch:node.keySet()){
                if(node.contains(word.charAt(0))){
                    res = search(word.substring(1),node.get(word.charAt(0)),characterSet);
                    if(res){
                        return true;
                    }
                }
                else{
                    res = existsChar(word.substring(1),node.get(ch));
                    if(res){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(String word,TrieNode node,Set<Character> characterSet){
            while (word.length()>0){
                if(node.contains(word.charAt(0))){
                    node = node.get(word.charAt(0));
                    word = word.substring(1);
                }
                else{
                    if(!characterSet.contains(word.charAt(0))){
                        return false;
                    }
                    Set<Character> keySet = node.keySet();
                    word =  word.substring(1);
                    for(Character ch:keySet){
                        if(existsChar(word,node.get(ch))){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
    class TrieNode{
        Map<Character,TrieNode> countMap;

        public TrieNode() {
            this.countMap = new HashMap<>();
        }

        public void put(Character ch,TrieNode node){
            this.countMap.put(ch,node);
        }

        public TrieNode get(Character ch){
            return countMap.get(ch);
        }

        public boolean contains(Character ch){
            return countMap.containsKey(ch);
        }

        private Set<Character> keySet(){
            return countMap.keySet();
        }
    }

    Trie trie;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word:dict){
            trie.addWord(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return trie.exists(word);
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("helll"));
        System.out.println(magicDictionary.search("leetcoded"));



    }
}
