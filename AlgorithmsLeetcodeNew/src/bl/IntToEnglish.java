package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 11/10/2019.
 */
public class IntToEnglish {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        List<String> res = new ArrayList<>();
        rec(num,res);
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < res.size() - 1; i++) {
            sb.append(res.get(i));
            sb.append(" ");
        }
        sb.append(res.get(res.size()-1));
        return sb.toString();
    }

    private void rec(int num, List<String> res){
        int mult = 1000000000;
        if(num/mult>=1){
            getVal(num/mult,res);
            res.add("Billion");
            num = num%mult;
        }
        mult/=1000;
        if(num/mult>=1){
            getVal(num/mult,res);
            res.add("Million");
            num = num%mult;
        }
        mult/=1000;
        if(num/mult>=1){
            getVal(num/mult,res);
            res.add("Thousand");
            num = num%mult;
        }
        mult/=1000;
        if(num/mult>=1) {
            getVal(num / mult, res);
        }
    }

    private void getVal(int num, List<String> list){
        int div = num/100;
        if(div>0){
             list.add(getDigit(div));
             list.add("Hundred");
        }
        int rem = num%100;
        div = rem/10;
        if(div>0){
            if(div==1){
                list.add(getTeens(rem));
                return;
            }
            list.add(getTens(div));
        }
        if(rem%10!=0){
            list.add(getDigit(rem%10));
        }
    }

    private String getDigit(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private String getTens(int num){
        switch(num){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    private String getTeens(int num){
        switch(num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new IntToEnglish().numberToWords(1000));
    }
}
