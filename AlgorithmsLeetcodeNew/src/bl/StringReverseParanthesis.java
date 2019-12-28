package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 9/14/2019.
 * 5190. Reverse Substrings Between Each Pair of Parentheses
 User Accepted:630
 User Tried:758
 Total Accepted:630
 Total Submissions:864
 Difficulty:Medium
 Given a string s that consists of lower case English letters and brackets.

 Reverse the strings in each pair of matching parentheses, starting from the innermost one.

 Your result should not contain any bracket.





 Example 1:

 Input: s = "(abcd)"
 Output: "dcba"
 Example 2:

 Input: s = "(u(love)i)"
 Output: "iloveu"
 Example 3:

 Input: s = "(ed(et(oc))el)"
 Output: "leetcode"
 Example 4:

 Input: s = "a(bcdefghijkl(mno)p)q"
 Output: "apmnolkjihgfedcbq"


 Constraints:

 0 <= s.length <= 2000
 s only contains lower case English characters and parentheses.
 It's guaranteed that all parentheses are balanced.

 */
public class StringReverseParanthesis {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] input = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(s.charAt(i)==')'){
                int from = stack.pop();
                reverse(input,from+1,i-1);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char anInput : input) {
            if (anInput != '(' && anInput != ')') {
                res.append(anInput);
            }
        }
        return String.valueOf(res);
    }

    private void reverse(char[] chars,int from, int to){
        Stack<Character> stack = new Stack<>();
        for (int i = from; i <= to; i++) {
            stack.push(chars[i]);
        }
        for (int i = from; i <= to; i++) {
            chars[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringReverseParanthesis().reverseParentheses("(abcd)"));
    }
}
