package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 8/28/2019.
 *
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 Example 1:

 Input: "1 + 1"
 Output: 2
 Example 2:

 Input: " 2-1 + 2 "
 Output: 3
 Example 3:

 Input: "(1+(4+5+2)-3)+(6+8)"
 Output: 23
 Note:
 You may assume that the given expression is always valid.
 Do not use the eval built-in library function.
 Accepted

 */
public class BasicCalculator {
    public int calculate(String s) {
        String clean = cleanUp(s);
        List<Integer> nums = new ArrayList<>();
        List<Character> signs = new ArrayList<>();
        extract(clean,nums,signs);
        while (nums.size()>1){
            int ans = calculate(nums.get(0),nums.get(1),signs.get(0));
            nums.remove(1);
            nums.remove(0);
            nums.add(0,ans);
            signs.remove(0);
        }
        return nums.get(0);
    }

    private String cleanUp(String s){
        boolean negate = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i)=='('){
                if(i>0&&s.charAt(i-1)=='-'){
                    negate = !negate;
                }
            }
            else if(s.charAt(i)==')'){
                if(negate){
                    negate = false;
                }
            }
            else if(s.charAt(i)=='+'){
                if(negate){
                    sb.append('-');
                }
            }
            else if(s.charAt(i)=='-'){
                if(negate){
                    sb.append('+');
                }
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private void extract(String s,List<Integer> nums, List<Character> signs){
        int num =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                nums.add(num);
                signs.add(s.charAt(i));
                num = 0;
            }
            else{
                num = num*10+(s.charAt(i)-48);
            }
        }
        nums.add(num);
    }

    private int calculate(int a, int b,char op){
        return op == '+' ? a + b : a - b;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("1+1"));
    }

}
