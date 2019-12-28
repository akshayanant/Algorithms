package bl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Akshay Hegde on 8/21/2019.
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example:

 Input: 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int digSum = n;
        Set<Integer> visit = new HashSet<>();
        while (true){
            digSum = digitSum(digSum);
            if(digSum == 1){
                return true;
            }
            if(visit.contains(digSum)){
                return false;
            }
            visit.add(digSum);
        }
    }

    private int digitSum(int num){
        int res =0;
        while (num>0){
            int rem = num%10;
            res+=(rem*rem);
            num/=10;
        }
        return res;
    }
}
