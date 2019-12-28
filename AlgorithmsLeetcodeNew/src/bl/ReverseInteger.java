package bl;

/**
 * Created by Akshay Hegde on 3/17/2019.
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int num = x;
        if(x<0){
            num*=-1;
        }
        long rev =0;
        while(num>0){
            int rem = num%10;
            rev= rev*10+rem;
            num/=10;
        }
        if(rev>Integer.MAX_VALUE){
            return 0;
        }
        return (int) rev;
    }
}
