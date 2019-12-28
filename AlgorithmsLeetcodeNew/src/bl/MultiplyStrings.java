package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/11/2019.
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        List<List<Integer>> mul = new ArrayList<>();
        for (int i = num2.length()-1; i >-1 ; i--) {
            int a = num2.charAt(i)-48;
            int carry =0;
            List<Integer> line = new ArrayList<>();
            for (int j = num1.length()-1; j >-1 ; j--) {
                int b = num1.charAt(j)-48;
                int res = a*b+carry;
                int dig = res%10;
                carry = res/10;
                line.add(0,dig);
            }
            if(carry>0){
                line.add(0,carry);
            }
            for (int j = 0; j < num2.length()-1-i; j++) {
                line.add(0);
            }
            mul.add(line);
        }
        System.out.println(mul);
        String ret = "";
        int len = mul.get(mul.size()-1).size();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int res = 0;
            for (int j = 0; j <mul.size(); j++) {
                int size = mul.get(j).size() - i - 1;
                if(size>-1) {
                    res = res + mul.get(j).get(size);
                }
            }
            res+=carry;
            int dig = res%10;
            carry = res/10;
            ret = dig+ret;
        }

        if(carry>0){
            ret = carry + ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123","456"));
    }
}
