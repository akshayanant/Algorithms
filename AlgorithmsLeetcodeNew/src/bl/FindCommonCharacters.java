package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/15/2019.
 * 1002. Find Common Characters
 * Easy
 * <p>
 * 448
 * <p>
 * 56
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * <p>
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        int m = A.length;
        int n = 26;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                dp[i][A[i].charAt(j) - 'a']++;

            }
        }
        List<String> res = new ArrayList<>();
        for (char i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, dp[j][i]);
            }
            for (int k = 0; k < min; k++) {
                char ch = (char) ('a' + i);
                res.add(ch + "");
            }
        }
        return res;
    }
}
