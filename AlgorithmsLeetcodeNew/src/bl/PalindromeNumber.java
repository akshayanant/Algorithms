package bl;

/**
 * Created by Akshay Hegde on 3/19/2019.
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n =x;
        int rev = 0;
        while(n!=0){
            int rem = n%10;
            if(n>Integer.MAX_VALUE/10 ||(n==Integer.MAX_VALUE/10 && rem>7 )){
                return false;
            }
            rev = rev*10+rem;
            n/=10;
        }
        return rev == x;
    }
}
