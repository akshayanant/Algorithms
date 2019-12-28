package bl;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 5222. Split a String in Balanced Strings
 User Accepted:4
 User Tried:4
 Total Accepted:4
 Total Submissions:4
 Difficulty:Easy
 Balanced strings are those who have equal quantity of 'L' and 'R' characters.

 Given a balanced string s split it in the maximum amount of balanced strings.

 Return the maximum amount of splitted balanced strings.



 Example 1:

 Input: s = "RLRRLLRLRL"
 Output: 4
 Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 Example 2:

 Input: s = "RLLLLRRRLR"
 Output: 3
 Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 Example 3:

 Input: s = "LLLLRRRR"
 Output: 1
 Explanation: s can be split into "LLLLRRRR".

 */
public class SplitStringBalanced {
    public int balancedStringSplit(String s) {
        int lCount =0;
        int rCount = 0;
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='L'){
                lCount++;
            }
            else if(s.charAt(i)=='R'){
                rCount++;
            }
            if(lCount==rCount){
                res++;
                lCount=0;
                rCount=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SplitStringBalanced().balancedStringSplit("RRLRRLRLLLRL"));
    }
}
