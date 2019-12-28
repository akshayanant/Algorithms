package bl;

/**
 * Created by Akshay Hegde on 8/20/2019.
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

 Example 1:

 Input: [5,7]
 Output: 4
 Example 2:

 Input: [0,1]
 Output: 0
 */
public class BitwiseANDRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m==0||n==0){
            return 0;
        }
        if(m==n){
            return m;
        }
        int res = 0;
        int mPos = msbPos(m);
        int nPos = msbPos(n);
        while (mPos == nPos){
            int pow = (int) Math.pow(2,mPos);
            res+=pow;
            m-=pow;
            n-=pow;
            mPos = msbPos(m);
            nPos = msbPos(n);
        }
        return res;
    }

    private int msbPos(int num){
        int mask =1;
        mask<<=31;
        int pos = 31;
        while (mask!=0){
            if((mask&num)!=0){
                return pos;
            }
            pos--;
            mask>>>=1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDRange().rangeBitwiseAnd(2,3));
    }
}
