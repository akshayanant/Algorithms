package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 4/27/2019.
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:

 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"
 Example 2:

 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        if(s.length()<1){
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                dp[i] = 0;
            }
            else if(s.charAt(i)==')'){
                if(i==0){
                    dp[i] = 0;
                }
                else if(s.charAt(i-1) =='('){
                  dp[i] = getVal(dp,i-2)+2;
                }
                else{
                    if(getChar(s,i-getVal(dp,i-1)-1)=='('){
                        dp[i] = getVal(dp,i-1)+getVal(dp,i-getVal(dp,i-1)-2)+2;
                    }
                    else{
                        dp[i]=0;
                    }
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i <dp.length ; i++) {
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }

    private int getVal(int[] dp,int i){
        if(i<0){
            return 0;
        }
        return dp[i];

    }

    private char getChar(String st, int i){
        if(i<0){
            return ' ';
        }
        return st.charAt(i);
    }
}
