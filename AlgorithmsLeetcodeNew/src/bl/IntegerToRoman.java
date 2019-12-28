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
 Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

 Example 1:

 Input: 3
 Output: "III"
 Example 2:

 Input: 4
 Output: "IV"
 Example 3:

 Input: 9
 Output: "IX"
 Example 4:

 Input: 58
 Output: "LVIII"
 Explanation: L = 50, V = 5, III = 3.
 Example 5:

 Input: 1994
 Output: "MCMXCIV"
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        int n = num;
        int digCount =0;
        StringBuilder res= new StringBuilder();
        while(n!=0){
            digCount++;
            n/=10;
        }

        if(digCount==4){
            res.append(writeThousand(num));
            int th = num/1000;
            num = num-(th*1000);
            digCount--;
        }
        if(digCount==3){
            res.append(writeHundred(num));
            int hun = num/100;
            num = num-(hun*100);
            digCount--;
        }
        if(digCount==2){
            res.append(writeTen(num));
            int ten = num/10;
            num = num-(ten*10);
        }
        res.append(writeUnit(num));
        return res.toString();


    }

    private String writeThousand(int num){
        int th = num/1000;
        StringBuilder ret = new StringBuilder();
        while(th!=0){
            ret.append('M');
            th--;
        }
        return ret.toString();
    }

    private String writeHundred(int num){
        int hun = num/100;
        StringBuilder ret = new StringBuilder();
        if(hun==9){
            ret.append("CM");
        }
        else if(hun>4){
            ret.append("D");
            hun-=5;
            while(hun!=0){
                ret.append("C");
                hun--;
            }
        }
        else if(hun==4){
            ret.append("CD");
        }
        else{
            while(hun!=0){
                ret.append("C");
                hun--;
            }
        }
        return ret.toString();
    }
    private String writeTen(int num){
        int ten = num/10;
        StringBuilder ret = new StringBuilder();
        if(ten==9){
            ret.append("XC");
        }
        else if(ten>4){
            ret.append("L");
            ten-=5;
            while(ten!=0){
                ret.append("X");
                ten--;
            }
        }
        else if(ten==4){
            ret.append("XL");
        }
        else{
            while(ten!=0){
                ret.append("X");
                ten--;
            }
        }
        return ret.toString();
    }
    private String writeUnit(int num){
        int un = num;
        StringBuilder ret = new StringBuilder();
        if(un==9){
            ret.append("IX");
        }
        else if(un>4){
            ret.append("V");
            un-=5;
            while(un!=0){
                ret.append("I");
                un--;
            }
        }
        else if(un==4){
            ret.append("IV");
        }
        else{
            while(un!=0){
                ret.append("I");
                un--;
            }
        }
        return ret.toString();
    }


}
