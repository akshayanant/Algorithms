package bl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Akshay Hegde on 10/12/2019.
 */
public class WeightedIntervalScheduling {
    private int opt(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //return rec(intervals, intervals.length - 1, intervals[intervals.length - 1][1]);
        return dp(intervals);
    }

    private int rec(int[][] intervals, int index, int startTime) {
        if (index < 0) {
            return 0;
        }
        int exclude = rec(intervals, index - 1, startTime);
        int include = 0;
        if (intervals[index][1] <= startTime) {
            include = intervals[index][2] + rec(intervals, index - 1, intervals[index][0]);
        }
        return Math.max(include, exclude);
    }

    private int dp(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[intervals.length - 1][1]+1;
        int[][] dp = new int[intervals.length][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = getDP(dp, i - 1, j);
                if (intervals[i][1] <= j) {
                    dp[i][j] = Math.max(dp[i][j],intervals[i][2]+getDP(dp, i - 1, intervals[i][0]));
                } ;
            }
        }
        return dp[m-1][n-1];
    }

    private int optimalDP(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[] dp = new int[intervals.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = intervals[i][2];
        }
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if(!jobsOverlap(intervals[j],intervals[i])){
                    dp[i] = Math.max(dp[j]+intervals[i][2],dp[i]);
                }
                else{
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
        }
        return dp[intervals.length-1];
    }

    private boolean jobsOverlap(int[] jobA,int[] jobB){
        return jobA[1]>jobB[0];
    }

    private int getDP(int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i > dp.length - 1 || j > dp[0].length - 1) {
            return 0;
        }
        return dp[i][j];
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] intervals = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            int[] item = new int[3];
            item[0] = startTime[i];
            item[1] = endTime[i];
            item[2] = profit[i];
            intervals[i] = item;
        }
        return optimalDP(intervals);
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1, 2, 15}, {3, 4, 7}, {1, 3, 8}, {2, 5, 6},{1,2,5}};
        System.out.println(new WeightedIntervalScheduling().optimalDP(in));
    }

}
