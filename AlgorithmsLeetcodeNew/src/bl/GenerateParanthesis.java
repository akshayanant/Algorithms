package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 4/10/2019.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        recusion(str,res,n);
        return res;
    }

    private void recusion(String str,List<String> res,int n){
            String s1 = '('+str+')';
            String s2 = str +"()";
            String s3 = "()"+str;
            String s4 = "";
            if(n==1) {
                if(!res.contains(s1)) {
                    res.add(s1);
                }
                if (!s2.equals(s1)&&!res.contains(s2)) {
                    res.add(s2);
                }
                if (!s3.equals(s2)&&!s3.equals(s1)&&!res.contains(s3)) {
                    res.add(s3);
                }

                return;
            }
            recusion(s1,res,n-1);
            if(!s2.equals(s1)){
                recusion(s2,res,n-1);
            }
            if(!s3.equals(s2)&&!s3.equals(s1)){
                recusion(s3,res,n-1);
            }
            if(!s4.isEmpty()){
                recusion(s4,res,n-1);
            }
    }
}



