package bl;

import java.util.List;

/**
 * Created by Akshay Hegde on 6/4/2019.
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:

 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

 */
public class TrainglePath {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        //return recursion(triangle,0,0,0);
        return dp(triangle);
    }

    private int recursion(List<List<Integer>> triangle, int row, int index, int sum) {
        if (row == triangle.size()) {
            return sum;
        }
        sum += triangle.get(row).get(index);
        return Math.min(recursion(triangle, row + 1, index, sum), recursion(triangle, row+1, index + 1, sum));
    }

    private int dp(List<List<Integer>> triangle){
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int[] prev = dp;
            dp = new int[triangle.get(triangle.size()-1).size()];
            dp[i] = prev[i-1]+triangle.get(i).get(triangle.get(i).size()-1);
            dp[0] = prev[0]+triangle.get(i).get(0);
            int j;
            for (j=i-1; j > 0 ; j--) {
                dp[j] = triangle.get(i).get(j)+Math.min(prev[j],prev[j-1]);
            }
        }
        int small = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if(dp[i]<small){
                small = dp[i];
            }
        }
        return small;
    }
}