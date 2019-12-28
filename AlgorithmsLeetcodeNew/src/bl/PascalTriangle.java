package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/4/2019.
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 5
 Output:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0){
            return res;
        }
        List<Integer> first = new ArrayList<>(1);
        first.add(1);
        res.add(first);
        if(numRows==1){
            return res;
        }
        List<Integer> second = new ArrayList<>(2);
        second.add(1);
        second.add(1);
        res.add(second);
        if(numRows==2){
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(numRows);
            row.add(1);
            for (int j = 1; j < res.get(i-1).size(); j++) {
                row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
