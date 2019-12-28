package bl;

/**
 * Created by Akshay Hegde on 3/23/2019.
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 Example 1:

 Input: "III"
 Output: 3
 Example 2:

 Input: "IV"
 Output: 4
 Example 3:

 Input: "IX"
 Output: 9
 Example 4:

 Input: "LVIII"
 Output: 58
 Explanation: L = 50, V= 5, III = 3.
 Example 5:

 Input: "MCMXCIV"
 Output: 1994
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int th =0;
        int hun = 0;
        int ten=0;
        int un=0;
         th = thousand(s);
        s = s.substring(th);
        if(s.length()>0) {
             hun = hundreds(s);
            if (hun == 9 || hun == 4) {
                s = s.substring(2);
            } else if (hun > 4) {
                s = s.substring(1 + hun - 5);
            } else {
                s=s.substring(hun);
            }
            if(s.length()>0){
                 ten = tens(s);
                if (ten == 9 || ten == 4) {
                    s = s.substring(2);
                } else if (ten > 4) {
                    s = s.substring(1 + ten - 5);
                } else {
                    s= s.substring(ten);
                }
                if(s.length()>0){
                     un = units(s);
                }
            }
        }
        return th*1000+hun*100+ten*10+un;

    }

    private int thousand(String s){
        int count = 0;
        while(s.charAt(count)=='M'&&count<s.length()){
            count++;
        }
        return count;
    }

    private int hundreds(String s){
        if(s.contains("M")){
            return 9;
        }
        if(!s.contains("C")&&s.contains("D")){
            return 5;
        }
        if(!s.contains("C")&&!s.contains("D")){
            return 0;
        }
        if(s.contains("C")&&s.contains("D")&&s.indexOf('C')<s.indexOf('D')){
            return 4;
        }
        int count =0;
        int i=0;
        if(s.charAt(i)=='D'){
            count =5;
            i++;
        }
        while(s.charAt(i)=='C'&&i<s.length()){
            count++;
            i++;
        }
        return count;

    }
    private int tens(String s){
        if(s.contains("C")){
            return 9;
        }
        if(!s.contains("X")&&s.contains("L")){
            return 5;
        }
        if(!s.contains("X")&&!s.contains("L")){
            return 0;
        }
        if(s.contains("X")&&s.contains("L")&&s.indexOf('X')<s.indexOf('L')){
            return 4;
        }
        int count =0;
        int i=0;
        if(s.charAt(count)=='L'){
            count =5;
            i++;
        }
        while(i<s.length()&&s.charAt(i)=='X'){
            count++;
            i++;
        }
        return count;
    }

    private int units(String s){
        if(s.contains("X")){
            return 9;
        }
        if(!s.contains("I")&&s.contains("V")){
            return 5;
        }
        if(!s.contains("I")&&!s.contains("L")){
            return 0;
        }
        if(s.contains("I")&&s.contains("V")&&s.indexOf('I')<s.indexOf('V')){
            return 4;
        }
        int count =0;
        int i=0;
        if(s.charAt(count)=='V'){
            count =5;
            i++;
        }
        while(i<s.length()&&s.charAt(i)=='I'){
            count++;
            i++;
        }
        return count;
    }
}
