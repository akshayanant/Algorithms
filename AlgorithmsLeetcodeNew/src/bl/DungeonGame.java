package bl;

/**
 * Created by Akshay Hegde on 7/31/2019.
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.



 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

 -2 (K)	-3	3
 -5	-10	1
 10	30	-5 (P)


 Note:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 Accepted

 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int ret = rec(dungeon,0,0,0);
        if(ret==0){
            return 1;
        }
        return ret;
    }

    private int rec(int[][] dungeon, int r, int c, int pow){
        if(r==dungeon.length-1&&c==dungeon[0].length-1){
            if(dungeon[r][c]+pow<=0){
                return 0-(dungeon[r][c]+pow)+1;
            }
            return 0;
        }
        if(r==dungeon.length-1){
            if(dungeon[r][c]+pow<=0){

                return 0-(dungeon[r][c]+pow)+rec(dungeon,r,c+1,1)+1;
            }
            return rec(dungeon,r,c+1,dungeon[r][c]+pow);
        }
        if(c==dungeon[0].length-1){
            if(dungeon[r][c]+pow<=0){
                return 0-(dungeon[r][c]+pow)+rec(dungeon,r+1,c,1)+1;
            }
            return rec(dungeon,r+1,c,dungeon[r][c]+pow);
        }
        if(dungeon[r][c]+pow<=0){
            return 0-(dungeon[r][c]+pow)+Math.min(rec(dungeon,r+1,c,1),
                    rec(dungeon,r,c+1,1))+1;
        }
        return Math.min(rec(dungeon,r+1,c,dungeon[r][c]+pow),
                rec(dungeon,r,c+1,dungeon[r][c]+pow));
    }

    private int dp(int[][] dungeon){
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int[][] pow = new int[dungeon.length][dungeon[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0&&j==0){
                    dp[i][j] = dungeon[i][j]<0?(0-dungeon[i][j])+1:1;
                    pow[i][j] =  dungeon[i][j]<=0?1:dungeon[i][j]+1;
                }
                else if(i==0){
                    if(dungeon[i][j]+pow[i][j-1]>0){
                        dp[i][j] = dp[i][j-1];
                        pow[i][j] = pow[i][j-1]+dungeon[i][j];
                    }
                    else{
                        dp[i][j] = dp[i][j-1]-(pow[i][j-1]+dungeon[i][j])+1;
                        pow[i][j] = 1;
                    }
                }
                else if(j==0){
                    if(dungeon[i][j]+pow[i-1][j]>0){
                        dp[i][j] = dp[i-1][j];
                        pow[i][j] = pow[i-1][j]+dungeon[i][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j]-(dungeon[i][j]+pow[i-1][j])+1;
                        pow[i][j] = 1;
                    }
                }
                else{
                    int dp1,dp2,pow1,pow2;
                   if(dungeon[i][j]+pow[i-1][j]>0){
                        dp1 = dp[i-1][j];
                        pow1 = pow[i-1][j]+dungeon[i][j];
                    }
                    else{
                        dp1 = dp[i-1][j]-(pow[i-1][j]+dungeon[i][j])+1;
                        pow1 = 1;
                    }
                    if(dungeon[i][j]+pow[i][j-1]>0){
                        dp2 = dp[i][j-1];
                        pow2 = pow[i][j-1]+dungeon[i][j];
                    }
                    else{
                        dp2 = dp[i][j-1]-(dungeon[i][j]+pow[i][j-1])+1;
                        pow2 = 1;
                    }
                    if(dp1<dp2){
                        dp[i][j] = dp1;
                        pow[i][j] = pow1;
                    }
                    else{
                        dp[i][j] = dp2;
                        pow[i][j] = pow2;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new DungeonGame().dp(input));
    }
}
