package bl;

/**
 * Created by Akshay Hegde on 10/3/2019.
 * 371. Sum of Two Integers
 Easy

 869

 1621

 Favorite

 Share
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example 1:

 Input: a = 1, b = 2
 Output: 3
 Example 2:

 Input: a = -2, b = 3
 Output: 1

 */
public class SumOfIntegers {
    public int getSum(int a, int b) {
        int sum =0;
        int mask =1;
        int car = 0;
        for (int i = 0; i < 32; i++) {
            int bita = (a&mask)==0?0:1;
            int bitb = (b&mask)==0?0:1;
            int bitsum = bita^bitb^car;
            car = (bita&bitb)|(bitb&car)|(car&bita);
            sum|=(bitsum<<i);
            mask<<=1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfIntegers().getSum(-100,-10));
    }
}
