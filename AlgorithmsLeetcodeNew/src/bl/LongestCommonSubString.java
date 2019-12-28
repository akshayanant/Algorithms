package bl;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * Question : Given two strings, write a function that returns the longest common
 substring.
 ● Eg.
 longestSubstring("ABAB", "BABA") = "ABA"

 */
public class LongestCommonSubString {
    private String longestCommonSubString(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(a.charAt(i)==b.charAt(j)){
                    dp[i][j] = 1+getDP(dp,i-1,j-1);
                }
            }
        }
        int max = -1;
        int maxI = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j]>max){
                    max = dp[i][j];
                    maxI = i;
                }
            }
        }
        if(max==-1){
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (max>0){
            res.insert(0,a.charAt(maxI));
            max--;
            maxI--;
        }
        return res.toString();
    }

    private int getDP(int[][] dp, int i, int j){
        if(i<0||j<0||i>dp.length-1||j>dp[0].length-1){
            return 0;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        String a = "kfjenfwjkfr";
        String b = "kfjenjffwjkfr";
        System.out.println(new LongestCommonSubString().longestCommonSubString(a,b));
        System.out.println(new LongestCommonSubString().bruteForce(a,b));

    }

    private String bruteForce(String a, String b){
        String res = "";
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if(a.charAt(i)==b.charAt(j)){
                    StringBuilder ans = new StringBuilder(a.charAt(i) + "");
                    int i2 = i+1;
                    int j2 = j+1;
                    while (i2<a.length()&&j2<b.length()&&a.charAt(i2)==b.charAt(j2)){
                        ans.append(a.charAt(i2));
                        i2++;
                        j2++;
                    }
                    if(ans.toString().length()>res.length()){
                        res = ans.toString();
                    }
                }
            }
        }
        return res;
    }
}


