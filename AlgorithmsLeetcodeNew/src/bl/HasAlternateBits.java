package bl;

/**
 * Created by Akshay Hegde on 10/4/2019.
 * 693. Binary Number with Alternating Bits
 Easy

 327

 73

 Favorite

 Share
 Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 Example 1:
 Input: 5
 Output: True
 Explanation:
 The binary representation of 5 is: 101
 Example 2:
 Input: 7
 Output: False
 Explanation:
 The binary representation of 7 is: 111.
 Example 3:
 Input: 11
 Output: False
 Explanation:
 The binary representation of 11 is: 1011.
 Example 4:
 Input: 10
 Output: True
 Explanation:
 The binary representation of 10 is: 1010.

 */
public class HasAlternateBits {
    public boolean hasAlternatingBits(int n) {
        int mask = 1<<30;
        boolean msb = false;
        int prev = 0;
        while (mask!=0){
            if(msb){
                if(prev==1) {
                    if ((n & mask) != 0) {
                        return false;
                    }
                    else{
                        prev = 0;
                    }
                }
                else {
                    if ((n & mask) == 0) {
                        return false;
                    }
                    else{
                        prev = 1;
                    }
                }
            }
            else{
                if((n&mask)!=0){
                    msb = true;
                    prev = 1;
                }
            }
            mask>>>=1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new HasAlternateBits().hasAlternatingBits(10));
    }
}
