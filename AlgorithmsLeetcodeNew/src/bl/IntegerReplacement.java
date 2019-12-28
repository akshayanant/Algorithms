package bl;

/**
 * Created by Akshay Hegde on 10/4/2019.
 * Given a positive integer n and you can do operations as follow:

 If n is even, replace n with n/2.
 If n is odd, you can replace n with either n + 1 or n - 1.
 What is the minimum number of replacements needed for n to become 1?

 Example 1:

 Input:
 8

 Output:
 3

 Explanation:
 8 -> 4 -> 2 -> 1
 Example 2:

 Input:
 7

 Output:
 4

 Explanation:
 7 -> 8 -> 4 -> 2 -> 1
 or
 7 -> 6 -> 3 -> 2 -> 1

 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        return rec((long) n);
    }

    public int rec(long n) {
        if(n<=0){
            return Integer.MAX_VALUE;
        }
        if(n==1){
            return 0;
        }
        if(n%2==0){
            return 1+rec(n/2);
        }
        if((n-1)%4==0){
            return rec(n-1);
        }
        return rec(n+1);
    }

}
