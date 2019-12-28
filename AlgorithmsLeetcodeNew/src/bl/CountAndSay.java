package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 5/10/2019.
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.



 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        String newStr = "1";
        for (int i = 1; i < n; i++) {
            newStr ="";
            for (int j = 0; j < str.length(); j++) {
                int current = str.charAt(j)-48;
                int count = 1;
                while(j<str.length()-1&&str.charAt(j+1)-48==current){
                    count++;
                    j++;
                }
                newStr = newStr+count+""+current;
            }
            str = newStr;
        }
        return str;
    }

    public String countAndSayMap(int n) {
        String str = "1";
        Map<Character,Integer> map;
        for (int i = 1; i < n; i++) {
            map = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                if(map.containsKey(str.charAt(j))){
                    int count = map.get(str.charAt(j));
                    count++;
                    map.put(str.charAt(j),count);
                }
                else{
                    map.put(str.charAt(j),1);
                }
            }
            str = "";
            for (Character ch : map.keySet()) {
                str = str +""+map.get(ch) +""+ch;
            }
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSayMap(4));
    }
}
