package bl;

import java.util.ArrayList;

/**
 * Created by Akshay Hegde on 4/10/2019.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='['||ch=='{'||ch=='('){
                stack.add(0,ch);
            }
            else if(ch=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.remove(0)!='{'){
                    return false;
                }
            }
            else if(ch==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.remove(0)!='('){
                    return false;
                }
            }
            else if(ch==']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.remove(0)!='['){
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
