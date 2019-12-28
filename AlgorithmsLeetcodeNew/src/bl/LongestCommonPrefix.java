package bl;

/**
 * Created by Akshay Hegde on 3/23/2019.
 * Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int i=0;
        int shortLen = strs[0].length();
        for (int j = 1; j < strs.length; j++) {
            if(strs[j].length()<shortLen){
                shortLen = strs[j].length();
            }
        }
        while(i<shortLen){
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(ch!=strs[j].charAt(i)){
                    return res.toString();
                }
            }
            res.append(ch);
            i++;
        }
        return res.toString();
    }

}
