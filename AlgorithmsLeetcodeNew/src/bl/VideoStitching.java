package bl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Akshay Hegde on 10/9/2019.
 * 1024. Video Stitching
 Medium

 232

 17

 Favorite

 Share
 You are given a series of video clips from a sporting event that lasted T seconds.  These video clips can be overlapping with each other and have varied lengths.

 Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].

 Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.



 Example 1:

 Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 Output: 3
 Explanation:
 We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
 Then, we can reconstruct the sporting event as follows:
 We cut [1,9] into segments [1,2] + [2,8] + [8,9].
 Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
 Example 2:

 Input: clips = [[0,1],[1,2]], T = 5
 Output: -1
 Explanation:
 We can't cover [0,5] with only [0,1] and [0,2].
 Example 3:

 Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 Output: 3
 Explanation:
 We can take clips [0,4], [4,7], and [6,9].
 Example 4:

 Input: clips = [[0,4],[2,8]], T = 5
 Output: 2
 Explanation:
 Notice you can have extra video after the event ends.


 Note:

 1 <= clips.length <= 100
 0 <=0000 clips[i][0], clips[i][1] <= 100
 0 <= T <= 100

 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        return dp(clips,T);
//        int res= rec(clips,T,0,0);
//        return res==Integer.MAX_VALUE?-1:res;
    }

    private int rec(int[][] clips,int T,int index,int start){
        if(index==clips.length){
            return Integer.MAX_VALUE;
        }
        if(clips[index][0]>start){
            return Integer.MAX_VALUE;
        }
        if(clips[index][1]>=T){
            return 1;
        }
        int include = rec(clips,T,index+1,clips[index][1]);
        int exclude = rec(clips,T,index+1,start);
        if(include==Integer.MAX_VALUE&&exclude==Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(include==Integer.MAX_VALUE){
            return exclude;
        }
        if(exclude==Integer.MAX_VALUE){
            return 1+include;
        }
        return Math.min(1+include,exclude);
    }

    private int dp(int[][] clips, int T){
        int m = clips.length;
        int n = T+1;
        int[][] dp= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(clips[i][0]==0&&clips[i][1]>=j){
                    dp[i][j] = 1;
                    continue;
                }
                if(clips[i][1]<j){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = i-1; k >-1; k--) {
                    min = Math.min(getDP(dp,k,clips[i][0]),min);
                }
                if(min!=Integer.MAX_VALUE){
                    dp[i][j] = 1+min;
                }
                else{
                    dp[i][j] = min;
                }
            }
        }

        int min = dp[m-1][T];
        for (int i = m-1; i >-1&&clips[i][1]>=T; i--) {
            min = Math.min(min,dp[i][T]);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

    private int getDP(int[][] dp, int i,int j){
        if(i<0||j<0||i>dp.length-1||j>dp[0].length-1){
            return Integer.MAX_VALUE;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new VideoStitching().videoStitching(new int[][]{{0,2},{4,8}},5));
    }
}
