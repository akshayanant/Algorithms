package bl;

/**
 * Created by Akshay Hegde on 5/15/2019.
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 Note:

 -100.0 < x < 100.0
 n is a 32-bit signed integer, within the range [−231, 231 − 1]

 */
public class XPowN {
    public double myPow(double x, int n) {
        if (n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(x==1){
            return 1;
        }
        boolean fraction = false;
        if(n<0){
            fraction = true;
            n*=(-1);
        }
        double pow = x;
        for (int i = 1; i < n; i++) {
            pow = pow *x;
            if(x>0&&pow<=Double.MIN_NORMAL ||(x<0 && pow>(Double.MIN_NORMAL*(-1)))){
                break;
            }
        }
        if(fraction){
            return 1/pow;
        }
        return pow;
    }
}
