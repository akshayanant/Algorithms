package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 8/18/2019.
 */
public class RepeatDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.isEmpty()){
            return res;
        }
        Map<String,Integer> set = new HashMap<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String ten = s.substring(i,i+10);
            if (set.containsKey(ten)) {
                if (set.get(ten) == 0) {
                    res.add(ten);
                    set.put(ten, 1);
                }
            }
            else {
                set.put(ten, 0);
            }
        }
        return res;
    }
}
