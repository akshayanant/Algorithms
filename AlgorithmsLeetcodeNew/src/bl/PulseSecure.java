package bl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshay Hegde on 4/6/2020.
 */
public class PulseSecure {
    public static int minCost(List<List<Integer>> cost) {
        if(cost.size()==0){
            return 0;
        }
        int[][] dp = new int[cost.size()][3];
        dp[0][0] = cost.get(0).get(0);
        dp[0][1] = cost.get(0).get(1);
        dp[0][2] = cost.get(0).get(2);

        for(int i=1;i<cost.size();i++){
            dp[i][0] += Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] += Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] += Math.min(dp[i-1][1],dp[i-1][0]);
        }
        return Math.min(Math.min(dp[dp.length-1][0],dp[dp.length-1][1]),dp[dp.length-1][2]);

    }

    public static int fewestCoins(String coins) {
        int n = coins.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(coins.charAt(i));
        }
        int min = n;
        for (int i = 0; i < n; i++) {
            Set<Character> copy = new HashSet<>();
            copy.addAll(set);
            int count =0;
            int j = i;
            for (;j<n&&!copy.isEmpty(); j++) {
                if(copy.contains(coins.charAt(j))){
                    copy.remove(coins.charAt(j));
                    count++;
                }
            }
            if(count==set.size()) {
                min = Math.min(min, j - i);
            }
        }
        return min;
    }

    public static int minDiff(List<Integer> arr) {
        Collections.sort(arr);
        int sum  =0;
        for (int i = 1; i < arr.size(); i++) {
            sum+= Math.abs(arr.get(i)-arr.get(i-1));
        }
        return sum;
    }
}
