package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/14/2019.
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output:
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 */
public class WordLadderAll {

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//
//    }

    private int recursion(List<String> begin, String end, List<String> words,List<List<String>> res){
        List<String> newBegin = new ArrayList<>();
        List<List<String>> soFar = new ArrayList<>();
        List<String> start = new ArrayList<>();
        start.addAll(begin);
        for (int i = 0; i < begin.size(); i++) {
            List<String> next = new ArrayList<>();
            boolean endFound = nextWords(begin.get(i),words,next,end);
            if(endFound){
            }
            words.removeAll(next);
            newBegin.addAll(next);
            if(i==begin.size()-1){
                begin.clear();
                begin.addAll(newBegin);
                newBegin.clear();
                for (int j = 0; j < soFar.size(); j++) {
                    List<String> list = soFar.remove(j);
                    for (int k = 0; k < begin.size(); k++) {
                        List<String> newSoFar = new ArrayList<>();
                        newSoFar.addAll(list);
                        newSoFar.add(begin.get(k));
                        soFar.add(j,newSoFar);
                    }
                }
                i=-1;
            }
        }
        return 0;

    }

    private boolean nextWords(String cur,List<String> words,List<String> next,String end){
        for (String word : words) {
            int diff = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) != cur.charAt(j)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1) {
                if(word.equals(end)){
                    return true;
                }
                next.add(word);
            }
        }
        return false;
    }
}
