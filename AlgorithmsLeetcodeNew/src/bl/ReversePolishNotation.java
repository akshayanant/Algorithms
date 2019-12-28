package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 6/25/2019.
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Note:

 Division between two integers should truncate toward zero.
 The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 Example 1:

 Input: ["2", "1", "+", "3", "*"]
 Output: 9
 Explanation: ((2 + 1) * 3) = 9
 Example 2:

 Input: ["4", "13", "5", "/", "+"]
 Output: 6
 Explanation: (4 + (13 / 5)) = 6
 Example 3:

 Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 Output: 22
 Explanation:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22

 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!(token.equals("+")
                    || token.equals("-")
                    || token.equals("*")
                    || token.equals("/"))) {
                stack.push(token);
            } else {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res;
                switch (token) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    default:
                        res = a / b;
                        break;
                }
                stack.push(String.valueOf(res));
            }

        }
        return Integer.parseInt(stack.pop());
    }
}
