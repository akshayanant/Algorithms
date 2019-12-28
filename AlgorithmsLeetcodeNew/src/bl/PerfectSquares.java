package bl;

/**
 * Created by Akshay Hegde on 9/6/2019.
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 Example 1:

 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.
 Example 2:

 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.

 */
public class PerfectSquares {
    public int numSquares(int n) {
        if(n==0){
            return 0;
        }
        double sqDouble = Math.sqrt(n);
        if(sqDouble==Math.floor(sqDouble)){
            return 1;
        }
        int sqrt = (int) Math.floor(sqDouble);
        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >sqrt/2 ; i--) {
            int count = 1+numSquares(n-i*i);
            if(count<min){
                min = count;
            }
        }
        return min;
    }
}
