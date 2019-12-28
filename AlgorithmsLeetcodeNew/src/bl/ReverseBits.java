package bl;

/**
 * Created by Akshay Hegde on 8/18/2019.
 * Reverse bits of a given 32 bits unsigned integer.



 Example 1:

 Input: 00000010100101000001111010011100
 Output: 00111001011110000010100101000000
 Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 Example 2:

 Input: 11111111111111111111111111111101
 Output: 10111111111111111111111111111111
 Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.


 Note:

 Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.


 Follow up:

 If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    public int reverseBits(int n) {
       int mask =1;
       int rev =0;
        for (int i = 0; i < 32; i++) {
            rev*=2;
            if((n&mask)!=0){
                rev = rev+1;
            }
            mask<<=1;
        }
        return rev;
    }

    public static void main(String[] args) {
        String bin = "11111111111111111111111111111101";
        int in = 0;
        for (int i = 0; i < bin.length(); i++) {
            in=in*2+(bin.charAt(i)-48);
        }
        System.out.println(new ReverseBits().reverseBits(in));
    }
}
