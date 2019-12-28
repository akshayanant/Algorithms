package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 8/23/2019.
 *
 * Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true
 Note:

 You may assume that all inputs are consist of lowercase letters a-z.
 All inputs are guaranteed to be non-empty strings.


 */class Trie {
     class Cell{
         char ch;
         Map<Character,Cell> nexts;

         public Cell(char ch) {
             this.ch = ch;
             this.nexts = new HashMap<>();
         }
     }

     Cell root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Cell(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Cell cell = root;
        while (!word.isEmpty()&&cell.nexts.containsKey(word.charAt(0))){
            cell = cell.nexts.get(word.charAt(0));
            word = word.substring(1);
        }
        if(!word.isEmpty()){
            if(word.length()==1) {
                char c = word.charAt(0);
                Cell lastCell = new Cell(c);
                lastCell.nexts.put(null,null);
                cell.nexts.put(c,lastCell);
            }
            else{
                Cell newCell = new Cell(word.charAt(0));
                newCell.nexts.put(word.charAt(1),insertExtra(word.substring(1)));
                cell.nexts.put(word.charAt(0),newCell);
            }
        }
        else{
            cell.nexts.put(null,null);
        }
    }

    private Cell insertExtra(String word){
        if(word.length()==1) {
            char c = word.charAt(0);
            Cell cell = new Cell(c);
            cell.nexts.put(null,null);
            return cell;
        }
        char c = word.charAt(0);
        Cell cell = new Cell(c);
        cell.nexts.put(word.charAt(1),insertExtra(word.substring(1)));
        return cell;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Cell cell =root;
        while (true){
            if(word.isEmpty()){
                return cell.nexts.containsKey(null);
            }
            if(!cell.nexts.containsKey(word.charAt(0))){
                return false;
            }
            cell = cell.nexts.get(word.charAt(0));
            word = word.substring(1);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Cell cell =root;
        while (true){
            if(prefix.isEmpty()){
                return true;
            }
            if(!cell.nexts.containsKey(prefix.charAt(0))){
                return false;
            }
            cell = cell.nexts.get(prefix.charAt(0));
            prefix = prefix.substring(1);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
