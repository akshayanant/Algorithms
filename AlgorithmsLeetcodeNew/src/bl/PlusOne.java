package bl;

/**
 * Created by Akshay Hegde on 5/18/2019.
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    public int[] plusOne(int[] digits){
        int carry =1;
        for (int i = digits.length-1; i > -1; i--) {
            int sum = carry + digits[i];
            if(sum<10){
                digits[i] = sum;
                return digits;
            }
            digits[i] = sum%10;
            carry = sum/10;
        }
        int[] res = new int[digits.length+1];
        res[0] = carry;
        System.arraycopy(digits, 0, res, 1, digits.length);
        return res;
    }
}
