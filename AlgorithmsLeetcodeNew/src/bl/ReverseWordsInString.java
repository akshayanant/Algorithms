package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 6/25/2019.
 *
 * Given an input string, reverse the string word by word.



 Example 1:

 Input: "the sky is blue"
 Output: "blue is sky the"
 Example 2:

 Input: "  hello world!  "
 Output: "world! hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.
 Example 3:

 Input: "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


 Note:

 A word is defined as a sequence of non-space characters.
 Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if(s.length()==0){
            return s;
        }
        Stack<String> words = new Stack<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                if(word.length()>0){
                    words.push(word.toString());
                }
                word = new StringBuilder();
            }
            else{
                word.append(s.charAt(i));
            }
        }
        if(word.length()>0){
            words.push(word.toString());
        }
        if(words.empty()){
            return "";
        }
        StringBuilder rev = new StringBuilder();
        while (words.size()>1){
            rev.append(words.pop());
            rev.append(" ");
        }

        rev.append(words.pop());
        return String.valueOf(rev);
    }
}
