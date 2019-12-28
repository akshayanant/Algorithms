package bl;

/**
 * Created by Akshay Hegde on 11/18/2019.
 */
public class IntegerPartitions {

    public int count(int num) {
        int[] dp = new int[num+1];
        dp[0] = 1;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            for (int j = 1; j <= (i+1)/2; j++) {
                sum+=dp[i-j];
            }
            dp[i] = sum;
        }
        return dp[num];

    }

    public static void main(String[] args) {
        System.out.println(new IntegerPartitions().count(10));
    }
}
