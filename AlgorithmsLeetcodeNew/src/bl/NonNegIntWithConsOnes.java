package bl;

/**
 * Created by Akshay Hegde on 10/6/2019.
 * 600. Non-negative Integers without Consecutive Ones
 Hard

 262

 65

 Favorite

 Share
 Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

 Example 1:
 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 Note: 1 <= n <= 109

 */
public class NonNegIntWithConsOnes {
    public int findIntegers(int num) {
        int count = 1;
        for (int i = 1; i < num + 1; i++) {
            if((i&(i<<1))==0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NonNegIntWithConsOnes().findIntegers(20));
    }
}
