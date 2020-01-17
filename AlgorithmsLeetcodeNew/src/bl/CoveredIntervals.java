package bl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Akshay Hegde on 1/17/2020.
 */
public class CoveredIntervals {
    class Interval{
        private int start;
        private int end;

        public Interval(int s,int e){
            start = s;
            end = e;
        }

    }
    public int removeCoveredIntervals(int[][] intervals) {
        int n  = intervals.length;
        Interval[] ints = new Interval[n];
        for(int i=0;i<n;i++){
            ints[i] = new Interval(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(ints,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                if(o1.start==o2.start){
                    return o2.end-o1.end;
                }
                return o1.start-o2.start;

            }
        });
        int count =0;
        for(int i=0;i<n;i++){
            int j = i+1;
            count++;
            while(j<n&&cover(ints[i],ints[j])){
                j++;
            }
            i = j-1;
        }
        return count;
    }

    private boolean cover(Interval a,  Interval b){
        return a.start<=b.start&&a.end>=b.end;
    }
}
