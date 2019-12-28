package bl;

/**
 * Created by Akshay Hegde on 10/17/2019.
 * 387. First Unique Character in a String
 Easy

 1233

 87

 Favorite

 Share
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.

 */
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(count[ch-'a']==-1){
                count[ch-'a']=i;
            }
            else{
                count[ch-'a']=Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(count[i]!=-1&&count[i]!=Integer.MAX_VALUE) {
                if (min == Integer.MAX_VALUE) {
                    min = i;
                } else if (count[i] < count[min]) {
                    min = i;
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:count[min];
    }

    public static void main(String[] args) {
        String input = "aaaaabcc";
        System.out.println(new FirstUniqueChar().firstUniqChar(input));
    }
}
