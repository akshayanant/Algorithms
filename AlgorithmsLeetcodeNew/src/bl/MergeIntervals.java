package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 5/16/2019.
 *
 * Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0]<o2[0]){
                return -1;
            }
            if(o1[0]==o2[0]){
                return 0;
            }
            return 1;
        });
        boolean[] merged = new boolean[intervals.length];
        for (int i = 0; i < intervals.length-1; i++) {
            mergeTwo(intervals[i],intervals[i+1],merged,i,i+1);
        }
        int mergeCount = 0;
        for (boolean aMerged : merged) {
            if(aMerged) {
                mergeCount++;
            }
        }
        int resIndex = 0;
        int[][] res = new int[mergeCount][2];
        for (int i = 0; i < merged.length; i++) {
            if(merged[i]){
                res[resIndex++] = intervals[i];
            }
        }
        return res;
    }

    private void mergeTwo(int[] a, int[] b, boolean[] merged, int i, int j){
        if(a[1]<b[0]){
            merged[i] = true;
            merged[j] = true;
            return;
        }
        b[0] = a[0];
        merged[i] = false;
        merged[j] = true;
        if(a[1]>b[1]){
            b[1] = a[1];
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(input)));
    }

}
