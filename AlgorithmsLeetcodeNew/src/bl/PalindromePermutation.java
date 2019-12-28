package bl;

/**
 * Created by Akshay Hegde on 10/20/2019.
 * Given a string, write a function to check if it is a permutation of
 a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 dictionary words.

 */
public class PalindromePermutation {
    private boolean solution(String s){
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch-'a']++;
        }
        int oddCount =0;
        for (int i = 0; i < 26; i++) {
            if(counts[i]%2==1){
                if(oddCount==1){
                    return false;
                }
                oddCount++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aaabbcbbaaa";
        System.out.println(new PalindromePermutation().solution(input));
    }
}
