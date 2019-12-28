package bl;

/**
 * Created by Akshay Hegde on 9/5/2019.
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

 Example:

 Input: n = 10
 Output: 12
 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 Note:

 1 is typically treated as an ugly number.
 n does not exceed 1690.
 */
public class UglyNumbersII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        int twoMult = 2;
        int threeMult = 3;
        int fiveMult = 5;
        for (int i = 1; i < n; i++) {
            int ugly = Math.min(Math.min(twoMult,threeMult),fiveMult);
            dp[i] = ugly;
            if(ugly == twoMult){
                twoIndex++;
                twoMult = dp[twoIndex]*2;
            }
            if(ugly == threeMult){
                threeIndex++;
                threeMult=dp[threeIndex]*3;
            }
            if(ugly == fiveMult){
                fiveIndex++;
                fiveMult=dp[fiveIndex]*5;
            }
        }
        return dp[n-1];

    }
}
