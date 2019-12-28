package bl;

/**
 * Created by Akshay Hegde on 10/5/2019.
 * 5216. Count Vowels Permutation
 User Accepted:455
 User Tried:537
 Total Accepted:455
 Total Submissions:763
 Difficulty:Hard
 Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

 Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 Each vowel 'a' may only be followed by an 'e'.
 Each vowel 'e' may only be followed by an 'a' or an 'i'.
 Each vowel 'i' may not be followed by another 'i'.
 Each vowel 'o' may only be followed by an 'i' or a 'u'.
 Each vowel 'u' may only be followed by an 'a'.
 Since the answer may be too large, return it modulo 10^9 + 7.



 Example 1:

 Input: n = 1
 Output: 5
 Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 Example 2:

 Input: n = 2
 Output: 10
 Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 Example 3:

 Input: n = 5
 Output: 68


 Constraints:

 1 <= n <= 2 * 10^4


 */
public class CountVowPerm {
    public int countVowelPermutation(int n) {
        return rec(n-1,'a')+rec(n-1,'e')+rec(n-1,'i')+rec(n-1,'o')+rec(n-1,'u');
    }

    private int rec(int n, char ch){
        if(n==0){
            return 1;
        }
        if(ch=='a'){
            return rec(n-1,'e');
        }
        if(ch=='e'){
            return (rec(n-1,'a')+rec(n-1,'i'));
        }
        if(ch=='i'){
            return (rec(n-1,'a')+rec(n-1,'e')+rec(n-1,'o')+rec(n-1,'u'));
        }
        if(ch=='o'){
            return ((rec(n-1,'i')+rec(n-1,'u')));
        }
        return rec(n-1,'a');
    }

    private int dp(int n){
        long[][] dp = new long[n+1][5];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 5; j++) {
                if(i==0){
                    dp[i][j] = 0;
                }
                else if(i==1){
                    dp[i][j] = 1;
                }
                else {
                    if (j==0){
                        dp[i][j] = dp[i-1][j+1];
                    }
                    else if(j==1){
                        dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%((long)1000000000+7);
                    }
                    else if(j==2){
                        dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]+dp[i-1][j-2]+dp[i-1][j+2])%((long)1000000000+7);
                    }
                    else if(j==3){
                        dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%((long)1000000000+7);
                    }
                    else{
                        dp[i][j] = dp[i-1][j-4];
                    }
                }
            }
        }
        return (int) ((dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4])%((long)1000000000+7));
    }

    public static void main(String[] args) {
        System.out.println(new CountVowPerm().dp(100));
    }
}
