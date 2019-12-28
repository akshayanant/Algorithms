package bl;

/**
 * Created by Akshay Hegde on 10/7/2019.
 * 372. Super Pow
 Medium

 154

 609

 Favorite

 Share
 Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example 1:

 Input: a = 2, b = [3]
 Output: 8
 Example 2:

 Input: a = 2, b = [1,0]
 Output: 1024

 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        long mult =1;
        long res = 1;
        for (int i = b.length-1; i > -1; i--) {
            long m= mult*b[i];
            long pow = (long) ((Math.pow(a,m)))%1337;
            res=  (res*pow);
            mult*=10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new SuperPow().superPow(2,new int[]{1,0}));
    }
}
