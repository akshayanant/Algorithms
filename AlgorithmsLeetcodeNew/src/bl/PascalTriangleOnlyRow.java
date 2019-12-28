package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/4/2019.
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

 Note that the row index starts from 0.


 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 3
 Output: [1,3,3,1]
 Follow up:

 Could you optimize your algorithm to use only O(k) extra space?

 */
public class PascalTriangleOnlyRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex==0){
            return res;
        }
        res.add(1);
        if(rowIndex==1){
            return res;
        }

        for (int i = 2; i < rowIndex+1; i++) {
            List<Integer> prev = res;
            res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j <prev.size(); j++) {
                res.add(prev.get(j)+prev.get(j-1));
            }
            res.add(1);
        }
        return res;
    }
}
