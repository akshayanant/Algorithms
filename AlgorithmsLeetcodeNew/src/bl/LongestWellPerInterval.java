package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/9/2019.
 * 1124. Longest Well-Performing Interval
 * Medium
 * <p>
 * 215
 * <p>
 * 43
 * <p>
 * Favorite
 * <p>
 * Share
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * <p>
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * <p>
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 * <p>
 * Return the length of the longest well-performing interval.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 */
public class LongestWellPerInterval {
    public int longestWPI(int[] hours) {
        int m =hours.length;
        int max =0;
        for (int i = 0; i < m; i++) {
            if(hours[i]>8){
                hours[i]=1;
                max =1;
            }
            else{
                hours[i]= -1;
            }
        }
        Map<Integer,Integer> sumMap = new HashMap<>();
        if(hours[0]==-1){
            sumMap.put(-1,0);
        }
        for (int i = 1; i < m; i++) {
            hours[i] = hours[i]+hours[i-1];
            if(hours[i]>0){
                max = Math.max(max,i+1);
            }
            else if(sumMap.containsKey(hours[i]-1)){
                max = Math.max(max,i-sumMap.get(hours[i]-1));
            }
            if(!sumMap.containsKey(hours[i])){
                sumMap.put(hours[i],i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWellPerInterval().longestWPI(new int[]{8,10,6,16,5}));
    }
}

