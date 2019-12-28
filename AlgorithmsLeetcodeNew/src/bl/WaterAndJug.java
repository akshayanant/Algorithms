///**
// * Created by Akshay Hegde on 10/17/2019.
// * 365. Water and Jug Problem
// * Medium
// * <p>
// * 191
// * <p>
// * 578
// * <p>
// * Favorite
// * <p>
// * Share
// * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
// * <p>
// * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
// * <p>
// * Operations allowed:
// * <p>
// * Fill any of the jugs completely with water.
// * Empty any of the jugs.
// * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
// * Example 1: (From the famous "Die Hard" example)
// * <p>
// * Input: x = 3, y = 5, z = 4
// * Output: True
// * Example 2:
// * <p>
// * Input: x = 2, y = 6, z = 5
// * Output: False
// */
//public class WaterAndJug {
//    public boolean canMeasureWater(int x, int y, int z) {
//        if(x+y<z){
//            return false;
//        }
//        if(x==0&&y==0){
//            return z==0;
//        }
//        if(x==0){
//            x=y;
//        }
//        else if(y==0){
//            y=x;
//        }
//        if (x > y) {
//            return dp(y, x, z);
//        }
//        return dp(x, y, z);
//    }
//
//    private boolean rec(int x, int y, int z) {
//        if (z < 0) {
//            return false;
//        }
//        if (z == 0) {
//            return true;
//        }
//        boolean measureX = canMeasureWater(x, y, z - x);
//        if (measureX) {
//            return true;
//        }
//        boolean measureY = canMeasureWater(x, y, z - y);
//        if (measureY) {
//            return true;
//        }
//        if (x != y) {
//            boolean bigToSmall = canMeasureWater(x, y, z - (y - x));
//            if (bigToSmall) {
//                return true;
//            }
//            int div = y / x;
//            int rem = x * (div + 1) - y;
//            boolean smallToBig = canMeasureWater(x, y, z - rem);
//            if (smallToBig) {
//                return true;
//            }
//
//        }
//        return false;
//    }
//
//    private boolean dp(int x, int y, int z){
//        boolean[] dp = new boolean[z+1];
//        dp[0] = true;
//        for (int i = 1; i < z + 1; i++) {
//            dp[i] = getDP(dp,i-x)||getDP(dp,i-y);
//            if(x!=y){
//                dp[i] = dp[i]||getDP(dp,i-(y-x));
//                int div = y / x;
//                int rem = x * (div + 1) - y;
//                dp[i] = dp[i]||getDP(dp,z-rem);
//            }
//        }
//        return dp[z];
//    }
//
//    private boolean getDP(boolean[] dp, int i) {
//        return i >= 0 &&  dp[i];
//    }
//
//
//    public static void main(String[] args) {
//        int x = 30;
//        int y = 41;
//        int z = 55;
//        System.out.println(new WaterAndJug().canMeasureWater(x, y, z));
//    }
//}
