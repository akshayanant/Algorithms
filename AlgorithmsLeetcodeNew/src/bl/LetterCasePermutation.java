package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/4/2019.
 * 784. Letter Case Permutation
 Easy

 782

 92

 Favorite

 Share
 Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 Note:

 S will be a string with length between 1 and 12.
 S will consist only of letters or digits.

 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        return rec(S,0);
    }

    private List<String> rec(String S,int index){
        if(index==S.length()-1){
            List<String> res = new ArrayList<>();
            if (Character.isDigit(S.charAt(index))){
                res.add(String.valueOf(S.charAt(index)));
                return res;
            }
            res.add(String.valueOf(Character.toLowerCase(S.charAt(index))));
            res.add(String.valueOf(Character.toUpperCase(S.charAt(index))));
            return res;
        }
        if(Character.isDigit(S.charAt(index))){
             return appendDig(rec(S,index+1),S.charAt(index));
        }
        return merge(rec(S,index+1),S.charAt(index));
    }

    private List<String> appendDig(List<String> res,char ch){
        List<String> ans = new ArrayList<>();
        for (String s : res) {
            s = ch + s;
            ans.add(s);
        }
        return ans;
    }

    private List<String> merge(List<String> res,char ch){
        List<String> ans = new ArrayList<>();
        for (String s : res) {
            ans.add(Character.toLowerCase(ch) + s);
            ans.add(Character.toUpperCase(ch) + s);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("b2"));
    }

}
