package bl;

/**
 * Created by Akshay Hegde on 6/17/2019.
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 Example:

 Input: "aab"
 Output: 1
 Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

 */
public class PalindromePartitionMinCut {

    public int minCut(String s) {
       int[] lazy = new int[s.length()];
        for (int i = 0; i < lazy.length; i++) {
            lazy[i] = -1;
        }
        return minCutRec(s,lazy,0);
    }

    private boolean isPalindrome(String s){
        for (int i = 0; i <=s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    private int minCutRec(String s,int[] lazy, int index){
        if(s.length()==0){
            return 0;
        }
        if(lazy[index]==-1) {
            int min = s.length();
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(0, i + 1);
                if (isPalindrome(str)) {
                    String next = s.substring(i + 1);
                    if (next.isEmpty()) {
                        return 0;
                    }
                    int cuts = 1 + minCutRec(next, lazy, index + i+1);
                    if (cuts < min) {
                        min = cuts;
                    }
                }
            }
            lazy[index] = min;
            return min;
        }
        return lazy[index];
    }

    private int minCutDP(String s){
        if(s.length()==0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                if(isPalindrome(s.substring(i,i+len+1))){
                    dp[i][i+len] = 0;
                }
                else{
                    int row = len+i;
                    int col = len+i-1;
                    dp[i][i+len] = len;
                    while (row>i&&col>=i){
                        if(1+dp[row][i+len]+dp[i][col]<dp[i][i+len]){
                            dp[i][i+len] = 1+dp[row][i+len]+dp[i][col];
                        }
                        row--;
                        col--;
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        String input = "leet";
        System.out.println(new PalindromePartitionMinCut().minCutDP(input));
    }
}
