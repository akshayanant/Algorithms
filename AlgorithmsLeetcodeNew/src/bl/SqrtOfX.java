package bl;

/**
 * Created by Akshay Hegde on 5/20/2019.
 *
 * Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
 the decimal part is truncated, 2 is returned.
 */
public class SqrtOfX {
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int sqrt =1;
        int prevSquare =1;
        for (int i = 2; i <=x / 2; i++) {
            if(i*i == x){
                return i;
            }
            if(i*i<x){
                if(i*i<prevSquare){
                    return sqrt;
                }
                prevSquare = i*i;
                sqrt = i;
            }
            else{
                return sqrt;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtOfX().mySqrt(
                2147483647));
    }
}
