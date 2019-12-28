package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/9/2019.
 * 316. Remove Duplicate Letters
 * Hard
 * <p>
 * 871
 * <p>
 * 80
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * <p>
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplLetters {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        Set<Integer> remove = new HashSet<>();
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (s.charAt(i) > prev) {
                    remove.add(i);
                } else {
                    remove.add(map.get(s.charAt(i)));
                    map.put(s.charAt(i), i);
                    prev = s.charAt(i);
                }
            } else {
                map.put(s.charAt(i), i);
                prev = s.charAt(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
