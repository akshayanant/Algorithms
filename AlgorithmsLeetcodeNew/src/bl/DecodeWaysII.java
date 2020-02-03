package bl;

/**
 * Created by Akshay Hegde on 2/2/2020.
 * 639. Decode Ways II
 Hard

 336

 443

 Add to List

 Share
 A message containing letters from A-Z is being encoded to numbers using the following mapping way:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

 Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: "*"
 Output: 9
 Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 Example 2:
 Input: "1*"
 Output: 9 + 9 = 18
 Note:
 The length of the input string will fit in range [1, 105].
 The input string will only contain the character '*' and digits '0' - '9'.

 */
public class DecodeWaysII {
    private static final int MOD = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        dp[n] = 1;
        if(s.charAt(n-1)=='*'){
            dp[n-1] = 9;
        }
        else if(s.charAt(n-1)!='0'){
            dp[n-1] = 1;
        }
        for (int i = n-2; i > -1; i--) {
            if(s.charAt(i)=='0'){
                dp[i] = 0;
                continue;
            }
            if(s.charAt(i)=='*'){
                if(s.charAt(i+1)=='0'){
                    dp[i] = (2*dp[i+2])%MOD;
                }
                else{
                    dp[i] = (9*dp[i+1])%MOD;
                    if(s.charAt(i+1)=='*'){
                        dp[i]=(dp[i]+(15*dp[i+2]))%MOD;
                    }
                    else if(s.charAt(i+1)<'7'){
                        dp[i]=(dp[i]+(2*dp[i+2]))%MOD;
                    }
                    else{
                        dp[i]=(dp[i]+dp[i+2])%MOD;
                    }
                }
            }
            else{
                dp[i] = dp[i+1];
                if(s.charAt(i)=='1'){
                    if(s.charAt(i+1)=='*'){
                        dp[i]=(dp[i]+(9*dp[i+2]))%MOD;
                    }
                    else{
                        dp[i]=(dp[i]+dp[i+2])%MOD;
                    }
                }
                else if(s.charAt(i)=='2'){
                    if(s.charAt(i+1)=='*'){
                        dp[i]=(dp[i]+(6*dp[i+2]))%MOD;
                    }
                    else if(s.charAt(i+1)<'7'){
                        dp[i]=(dp[i]+(dp[i+2]))%MOD;
                    }
                }
            }
        }
        return (int) dp[0];
    }
}
