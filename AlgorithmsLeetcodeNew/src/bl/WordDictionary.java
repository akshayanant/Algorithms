package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 8/24/2019.
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 Example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 */
class WordDictionary {

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
    public WordDictionary() {
        root = new Cell(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Cell cell =root;
        return searchRec(cell,word);

    }

    private boolean searchRec(Cell cell,String word){
        while (true){
            if(cell==null){
                return false;
            }
            if(word.isEmpty()){
                return cell.nexts.containsKey(null);
            }
            if(word.charAt(0)=='.'){
                for(Character ch : cell.nexts.keySet()){
                    boolean match = searchRec(cell.nexts.get(ch),word.substring(1));
                    if(match){
                        return true;
                    }
                }
                return false;
            }
            if(!cell.nexts.containsKey(word.charAt(0))){
                return false;
            }
            cell = cell.nexts.get(word.charAt(0));
            word = word.substring(1);
        }
    }
}
