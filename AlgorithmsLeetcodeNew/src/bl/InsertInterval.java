package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 5/16/2019.
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] input = new int[intervals.length + 1][2];
        int newIndex = 0;
        boolean intervalAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[i][0] && !intervalAdded) {
                input[newIndex++] = newInterval;
                i--;
                intervalAdded = true;
            } else {
                input[newIndex++] = intervals[i];
            }
        }
        if (!intervalAdded) {
            input[input.length - 1] = newInterval;
        }
        return merge(input);
    }


    private int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            }
            if (o1[0] == o2[0]) {
                return 0;
            }
            return 1;
        });
        boolean[] merged = new boolean[intervals.length];
        for (int i = 0; i < intervals.length - 1; i++) {
            mergeTwo(intervals[i], intervals[i + 1], merged, i, i + 1);
        }
        int mergeCount = 0;
        for (boolean aMerged : merged) {
            if (aMerged) {
                mergeCount++;
            }
        }
        int resIndex = 0;
        int[][] res = new int[mergeCount][2];
        for (int i = 0; i < merged.length; i++) {
            if (merged[i]) {
                res[resIndex++] = intervals[i];
            }
        }
        return res;
    }

    private void mergeTwo(int[] a, int[] b, boolean[] merged, int i, int j) {
        if (a[1] < b[0]) {
            merged[i] = true;
            merged[j] = true;
            return;
        }
        b[0] = a[0];
        merged[i] = false;
        merged[j] = true;
        if (a[1] > b[1]) {
            b[1] = a[1];
        }
    }
}