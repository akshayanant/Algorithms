package bl;

/**
 * Created by Akshay Hegde on 5/20/2019.
 *
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */


public class AddBinary {

    public String addBinary(String a, String b) {
        char carry = '0';
        StringBuilder res = new StringBuilder();
        for (int i = a.length()-1,j=b.length()-1; i >-1 || j>-1 ; i--,j--) {
            char charA = i>-1 ? a.charAt(i):'0';
            char charB = j>-1? b.charAt(j):'0';
            char bit = addBits(carry,addBits(charA,charB));
            carry = getCarry(carry,charA,charB);
             res.insert(0, bit);
        }
        if(carry=='1'){
            res.insert(0,carry);
        }
        return String.valueOf(res.toString());
    }

    private char addBits(char a, char b){
        if((a=='1' && b=='1')|| (a=='0'&&b=='0')){
            return '0';
        }
        return '1';
    }

    private char getCarry(char... c){
       int oneCount =0;
        for (char aC : c) {
            if (aC == '1') {
                oneCount++;
                if (oneCount > 1) {
                    return '1';
                }
            }
        }
        return '0';
    }

}
