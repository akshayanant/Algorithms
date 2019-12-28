package bl;

/**
 * Created by Akshay Hegde on 7/31/2019.
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 Example 1:

 Input: 1
 Output: "A"
 Example 2:

 Input: 28
 Output: "AB"
 Example 3:

 Input: 701
 Output: "ZY"

 */
public class ExcelheetColName {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n>0){
            n--;
            int rem = n%26;
            char ch = (char) ('A'+rem);
            res.insert(0, ch);
            n/=26;
        }
        return String.valueOf(res);
    }
}
