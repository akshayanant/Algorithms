package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 2/7/2020.
 */
public class TeleTracking {
    public static List<String> funWithAnagrams(List<String> text) {
        Set<String> visit = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(String s:text){
            String anagram = getAnagram(s);
            if(!visit.contains(anagram)){
                visit.add(anagram);
                res.add(s);
            }
        }
        Collections.sort(res);
        return res;
    }

    private static String getAnagram(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
