package bl;

/**
 * Created by Akshay Hegde on 10/1/2019.
 * 326. Power of Three
 Easy

 329

 1175

 Favorite

 Share
 Given an integer, write a function to determine if it is a power of three.

 Example 1:

 Input: 27
 Output: true
 Example 2:

 Input: 0
 Output: false
 Example 3:

 Input: 9
 Output: true
 Example 4:

 Input: 45
 Output: false
 Follow up:
 Could you do it without using any loop / recursion?

 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        int three_pow_19 = (int) Math.pow(3,19);
        return n>0&&three_pow_19%n==0;
    }
}
