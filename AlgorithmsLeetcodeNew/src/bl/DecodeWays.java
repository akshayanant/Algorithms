package bl;

/**
 * Created by Akshay Hegde on 5/26/2019.
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='0' && (s.charAt(i-1)!='1'&&s.charAt(i-1)!='2')){
                return 0;
            }
        }
        return 1+recursion(s,s.length()-1);
    }

    private int recursion(String s,int i){
        if(i<=0){
            return 0;
        }
        if(canSplit(s.charAt(i-1),s.charAt(i))){
            return 1+recursion(s,i-1)+recursion(s,i-2);
        }
        if(isCompound(s.charAt(i))){
            return recursion(s,i-2);
        }
        return recursion(s,i-1);
    }

    private int dp(String s,int i){
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int j = 1; j < s.length(); j++) {
            if(canSplit(s.charAt(j-1),s.charAt(j))){
                dp[j] = 1+getDP(dp,j-1)+getDP(dp,j-2);
            }
            else if(isCompound(s.charAt(j))){
                dp[j] = getDP(dp,j-2);
            }
            else{
                dp[j] = getDP(dp,j-1);
            }
        }
        return dp[s.length()-1];
    }

    private boolean canSplit(char c1, char c2) {
        return !(c1 != '1' && c1 != '2' || c2 == '0') && !(c1 == '2' && c2 > '6');
    }

    private boolean isCompound(char c){
        return c=='0';
    }

    private int getDP(int[] dp, int i){
        return i<0?0:dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
    }
}
