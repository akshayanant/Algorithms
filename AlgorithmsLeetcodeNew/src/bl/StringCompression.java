package bl;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * Question : Given a string, write a function to compress it by shortening every
 sequence of the same character to that character followed by the number of
 repetitions. If the compressed string is longer than the original, you should return
 the original string.
 ● Eg.
 compress(“a”) = "a"
 compress(“aaa”) = "a3"
 compress(“aaabbb”) = "a3b3"
 compress(“aaabccc”) = "a3b1c3"

 */
public class StringCompression {

    private String compress(String s){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res.append(ch);
            int j = i+1;
            int count =1;
            while (j<s.length()&&s.charAt(j)==ch){
                j++;
                count++;
            }
            res.append(count);
            i = j-1;
        }
        return res.toString().length()<=s.length()?res.toString():s;
    }

    public static void main(String[] args) {
        String s ="aabcc";
        System.out.println(new StringCompression().compress(s));
    }
}
