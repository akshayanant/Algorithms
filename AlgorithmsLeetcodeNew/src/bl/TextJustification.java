package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/20/2019.
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 Note:

 A word is defined as a character sequence consisting of non-space characters only.
 Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 The input array words contains at least one word.
 Example 1:

 Input:
 words = ["This", "is", "an", "example", "of", "text", "justification."]
 maxWidth = 16
 Output:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Example 2:

 Input:
 words = ["What","must","be","acknowledgment","shall","be"]
 maxWidth = 16
 Output:
 [
 "What   must   be",
 "acknowledgment  ",
 "shall be        "
 ]
 Explanation: Note that the last line is "shall be    " instead of "shall     be",
 because the last line must be left-justified instead of fully-justified.
 Note that the second line is also left-justified becase it contains only one word.
 Example 3:

 Input:
 words = ["Science","is","what","we","understand","well","enough","to","explain",
 "to","a","computer.","Art","is","everything","else","we","do"]
 maxWidth = 20
 Output:
 [
 "Science  is  what we",
 "understand      well",
 "enough to explain to",
 "a  computer.  Art is",
 "everything  else  we",
 "do                  "
 ]

 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int space = maxWidth;
        List<String> justified = new ArrayList<>();
        List<String> thisLine = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < space) {
                thisLine.add(words[i]);
                space = space - words[i].length() - 1;
            } else if (words[i].length() == space) {
                StringBuilder builder = new StringBuilder();
                for (String aThisLine : thisLine) {
                    builder.append(aThisLine).append(' ');
                }
                builder.append(words[i]);
                justified.add(String.valueOf(builder));
                space = maxWidth;
                thisLine = new ArrayList<>();
            } else if (thisLine.size() == 1) {
                StringBuilder builder = new StringBuilder();
                builder.append(thisLine.get(0));
                while(builder.length()<maxWidth){
                    builder.append(" ");
                }
                justified.add(String.valueOf(builder));
                i--;
                space = maxWidth;
                thisLine = new ArrayList<>();
            } else {
                int whiteSpaces = space + 1;
                int index = 0;
                for (; whiteSpaces > 0; ) {
                    String addSpace = thisLine.remove(index);
                    addSpace = addSpace + " ";
                    thisLine.add(index, addSpace);
                    index = (index + 1) % (thisLine.size() - 1);
                    whiteSpaces--;
                }
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < thisLine.size() - 1; j++) {
                    builder.append(thisLine.get(j)).append(' ');
                }
                builder.append(thisLine.get(thisLine.size() - 1));
                justified.add(String.valueOf(builder));
                i--;
                space = maxWidth;
                thisLine = new ArrayList<>();
            }
        }
        if(!thisLine.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            while (builder.length() < maxWidth) {
                if(thisLine.size()>0) {
                    builder.append(thisLine.remove(0));
                }
                if(builder.length()<maxWidth)
                builder.append(" ");
            }
            justified.add(String.valueOf(builder));
        }
        return justified;

    }

}
