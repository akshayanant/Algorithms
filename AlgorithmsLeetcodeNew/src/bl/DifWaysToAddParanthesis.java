package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 11/9/2019.
 * 241. Different Ways to Add Parentheses
 * Medium
 * <p>
 * 1202
 * <p>
 * 61
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * Example 1:
 * <p>
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 * <p>
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DifWaysToAddParanthesis {
    public List<Integer> diffWaysToCompute(String input) {
        return rec(input);
    }

    private List<Integer> rec(String input) {
        List<Integer> res = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.parseInt(input));
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = rec(input.substring(0, i));
                List<Integer> right = rec(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (input.charAt(i) == '+') {
                            res.add(l + r);
                        } else if (input.charAt(i) == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new DifWaysToAddParanthesis().diffWaysToCompute("2-1-1"));
    }
}
