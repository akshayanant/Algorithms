package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 8/27/2019.
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

 Example 1:

 Input: "aacecaaa"
 Output: "aaacecaaa"
 Example 2:

 Input: "abcd"
 Output: "dcbabcd"


 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        List<Character> queue= new ArrayList<>();
        for (int i = s.length(); i>0; i--) {
            if(!isPalindrome(s.substring(0,i))) {
                queue.add(s.charAt(i-1));
            }
            else{
                StringBuilder sb = new StringBuilder();
                while (!queue.isEmpty()){
                    sb.append(queue.remove(0));
                }
                sb.append(s);
                return sb.toString();
            }
        }
        return s;
    }
    
    private boolean isPalindrome(String s){
        for (int i = 0, j=s.length()-1; i<j; i++,j--) {
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
