package bl;

/**
 * Created by Akshay Hegde on 6/6/2019.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false

 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            while (start<s.length() &&!(Character.isAlphabetic(s.charAt(start))||Character.isDigit(s.charAt(start)))){
                start++;
            }
            if(start>end){
                return true;
            }
            while (end>-1&&!(Character.isAlphabetic(s.charAt(end))||Character.isDigit(s.charAt(end)))){
                end--;
            }
            if(end==-1){
                return false;
            }
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
