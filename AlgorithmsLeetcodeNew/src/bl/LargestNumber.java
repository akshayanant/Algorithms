package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 8/17/2019.
 * Given a list of non negative integers, arrange them such that they form the largest number.

 Example 1:

 Input: [10,2]
 Output: "210"
 Example 2:

 Input: [3,30,34,5,9]
 Output: "9534330"

 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> strings = new ArrayList<>();
        for (int num : nums) {
            strings.add(String.valueOf(num));
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1);
            }
        });
        if(strings.get(0).equals("0")){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
