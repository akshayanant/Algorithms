package bl;

/**
 * Created by Akshay Hegde on 7/31/2019.
 * Given an integer n, return the number of trailing zeroes in n!.

 Example 1:

 Input: 3
 Output: 0
 Explanation: 3! = 6, no trailing zero.
 Example 2:

 Input: 5
 Output: 1
 Explanation: 5! = 120, one trailing zero.
 Note: Your solution should be in logarithmic time complexity.

 Accepted
 164,151
 Submissions
 437,528
 Seen this question in a real interview before?

 Yes

 No
 Contributor
 shtian

 Problems

 Pick One

 Prev
 172/1142

 Next






 1
 class Solution {
 2
 public int trailingZeroes(int n) {
 3

 4
 }
 5
 }


 */
public class FactorialTrailingZero {
    public int trailingZeroes(int n) {
        if(n==0){
            return 0;
        }
        int count = 0;
        for (int i = 5; (n/i)>=1 ; i*=5) {
            count+=(n/i);
        }
        return count;
    }
}
