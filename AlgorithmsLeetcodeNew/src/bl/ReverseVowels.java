package bl;

/**
 * Created by Akshay Hegde on 10/6/2019.
 * 345. Reverse Vowels of a String
 Easy

 447

 835

 Favorite

 Share
 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:

 Input: "hello"
 Output: "holle"
 Example 2:

 Input: "leetcode"
 Output: "leotcede"
 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        while (i<j){
            while (i<j&&(chars[i]!='a'&&chars[i]!='e'&&chars[i]!='i'&&chars[i]!='o'&&
                    chars[i]!='u'&&chars[i]!='A'&&chars[i]!='E'&&chars[i]!='I'&&chars[i]!='O'&&
                    chars[i]!='U')){
                i++;
            }
            while (j>i&&(chars[j]!='a'&&chars[j]!='e'&&chars[j]!='i'&&chars[j]!='o'&&
                    chars[j]!='u'&&chars[j]!='A'&&chars[j]!='E'&&chars[j]!='I'&&chars[j]!='O'&&
                    chars[j]!='U')){
                j--;
            }
            if(i<j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
