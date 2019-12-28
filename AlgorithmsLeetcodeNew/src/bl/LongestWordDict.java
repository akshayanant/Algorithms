package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/18/2019.
 * 524. Longest Word in Dictionary through Deleting
 Medium

 389

 195

 Favorite

 Share
 Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"
 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"
 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.

 */
public class LongestWordDict {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String word:d){
            String match = matchingString(s,word,0,0);
            if(match.length()>res.length()){
                res = match;
            }
            else if(res.length()==match.length()&&match.compareTo(res)<0){
                res = match;
            }
        }
        return res;
    }

    private String matchingString(String s, String word,int i, int j){
        if(j==word.length()) {
            return word;
        }
        if(i==s.length()){
            return "";
        }
        if(s.charAt(i)==word.charAt(j)){
            return matchingString(s,word,i+1,j+1);
        }
        return matchingString(s,word,i+1,j);
    }

    public static void main(String[] args) {
        String s = "abmpocnpkleeyplea";
        List<String> words = new ArrayList<>();
        words.add("ale");
        words.add("apple");
        words.add("monkeyplea");
        words.add("plea");
        System.out.println(new LongestWordDict().findLongestWord(s,words));
    }
}
