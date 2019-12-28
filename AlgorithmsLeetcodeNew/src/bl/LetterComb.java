package bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Akshay Hegde on 3/23/2019.
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 Example:

 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterComb {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        HashMap<Integer,String> keys = new HashMap<>();
        keys.put(2,"abc");
        keys.put(3,"def");
        keys.put(4,"ghi");
        keys.put(5,"jkl");
        keys.put(6,"mno");
        keys.put(7,"pqrs");
        keys.put(8,"tuv");
        keys.put(9,"wxyz");
        String first = keys.get(digits.charAt(0)-48);
        for (int i = 0; i < first.length(); i++) {
            res.add(String.valueOf(first.charAt(i)));
        }
        for (int i = 1; i < digits.length(); i++) {
            String val = keys.get(digits.charAt(i)-48);
            res = combine(res,val);
        }
        return res;

    }
    private List<String> combine(List<String> res, String val){
        List<String> newRes = new ArrayList<>();
        for (String re : res) {
            for (int j = 0; j < val.length(); j++) {
                newRes.add(re + val.charAt(j));
            }
        }
        res.clear();
        return newRes;
    }
}
