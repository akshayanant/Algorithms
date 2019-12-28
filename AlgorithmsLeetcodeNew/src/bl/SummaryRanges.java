package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 8/29/2019.
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 Example 1:

 Input:  [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 Example 2:

 Input:  [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

 */


public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        int count =0;
        for (int i = 0; i < nums.length-1; i++) {
            if(start){
                sb.append(nums[i]);
                start = false;
            }
            if(nums[i+1]==nums[i]+1){
                count++;
                continue;
            }
            if(count>0){
                sb.append("->").append(nums[i]);
                res.add(sb.toString());
            }
            else{
                res.add(sb.toString());
            }
            count = 0;
            start = true;
            sb = new StringBuilder();
        }
        if(!start){
            sb.append("->").append(nums[nums.length-1]);
            res.add(sb.toString());
        }
        else {
            sb.append(nums[nums.length-1]);
            res.add(sb.toString());
        }
        return res;
    }
}
