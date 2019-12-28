package bl;

/**
 * Created by Akshay Hegde on 9/10/2019.
 *
 * 854. K-Similar Strings
 Hard

 198

 22

 Favorite

 Share
 Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

 Given two anagrams A and B, return the smallest K for which A and B are K-similar.

 Example 1:

 Input: A = "ab", B = "ba"
 Output: 1
 Example 2:

 Input: A = "abc", B = "bca"
 Output: 2
 Example 3:

 Input: A = "abac", B = "baca"
 Output: 2
 Example 4:

 Input: A = "aabc", B = "abca"
 Output: 2
 Note:

 1 <= A.length == B.length <= 20
 A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}

 */
public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        char[] chA = new char[A.length()];
        char[] chB = new char[B.length()];
        StringBuilder newA = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i)==B.charAt(i)){
                chA[i] = '*';
                newA.append(chA[i]);
                continue;
            }
            chA[i] = A.charAt(i);
            chB[i] = B.charAt(i);
            newA.append(chA[i]);
        }
        int count = 0;
        for (int i = 0; i < chA.length; i++) {
            if(chA[i]=='*'){
                newA.substring(i+1);
                continue;
            }
            if(chA[i]!=chB[i]){
                int index = newA.indexOf(String.valueOf(chB[i]),i);
                chA[index] = chA[i];
                if(chA[index]==chB[index]){
                    chA[index] = '*';
                }
                count++;
            }
            newA = new StringBuilder(String.valueOf(chA));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new KSimilarStrings().kSimilarity("bccaba",
                "abacbc"));
    }
}
