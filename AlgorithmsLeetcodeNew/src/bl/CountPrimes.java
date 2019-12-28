package bl;

/**
 * Created by Akshay Hegde on 8/21/2019.
 * Count the number of prime numbers less than a non-negative number, n.

 Example:

 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean prime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j==0){
                    prime=false;
                    break;
                }
            }
            if (prime){
                count++;
            }
        }
        return count;
    }
}
