package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/17/2019.
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]

 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length()==0){
            return res;
        }
        if(s.length()==1){
            List<String> one = new ArrayList<>();
            one.add(s);
            res.add(one);
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (isPalindrome(str)) {
                String next = s.substring(i + 1);
                if(next.isEmpty()){
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    res.add(list);
                    return res;
                }
                List<List<String>> append = partition(next);
                if (!append.isEmpty()) {
                    for (List<String> anAppend : append) {
                        List<String> pal = new ArrayList<>();
                        pal.add(str);
                        pal.addAll(anAppend);
                        res.add(pal);
                    }
                }
            }
        }
        return res;
    }



        private boolean isPalindrome(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
