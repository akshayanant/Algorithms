package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/13/2019.
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord)) {
            List<String> begin = new ArrayList<>();
            begin.add(beginWord);
            return recursion(begin, endWord, wordList);
        }
        return 0;
    }

    private int recursion(List<String> begin, String end, List<String> words){
        List<String> newBegin = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < begin.size(); i++) {
            List<String> next = new ArrayList<>();
            boolean endFound = nextWords(begin.get(i),words,next,end);
            if(endFound){
                return count+1;
            }
            words.removeAll(next);
            newBegin.addAll(next);
            if(i==begin.size()-1){
                begin.clear();
                begin.addAll(newBegin);
                newBegin.clear();
                count++;
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


    public static void main(String[] args) {
        //String[] input = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String[] input = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> inputs = new ArrayList<>();
        Collections.addAll(inputs, input);
        System.out.println(new WordLadder().ladderLength("hit","cog", inputs));
    }
}
