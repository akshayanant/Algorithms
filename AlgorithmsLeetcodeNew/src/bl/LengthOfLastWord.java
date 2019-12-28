package bl;

/**
 * Created by Akshay Hegde on 5/16/2019.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Input: "Hello World"
 Output: 5
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len =0;
        boolean charFound =false;
        for (int i = s.length()-1; i >-1 ; i--) {
            if(s.charAt(i)==' '){
                if(charFound) {
                    return len;
                }
            }
            else {
                charFound = true;
                len++;
            }
        }
        return len;
    }
}
