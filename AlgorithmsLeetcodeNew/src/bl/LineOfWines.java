package bl;

/**
 * Created by Akshay Hegde on 10/11/2019.
 */
public class LineOfWines {
    private int maxProfit(int[] bottles) {
        int n = bottles.length;
        return rec(bottles, 0, n - 1, 1);
    }

    private int rec(int[] bootles, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        return Math.max(k * bootles[l] + rec(bootles, l + 1, r, k + 1), k * bootles[r] + rec(bootles, l, r - 1, k + 1));
    }

    private int getDP(int[][] dp, int i, int j) {
        if (i < 0 || i > dp.length - 1 || j < 0 || j > dp[0].length - 1) {
            return 0;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new LineOfWines().maxProfit(new int[]{2, 4, 6, 2, 5}));
    }
}
