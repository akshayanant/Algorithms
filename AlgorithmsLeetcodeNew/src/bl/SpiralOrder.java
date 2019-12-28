package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/16/2019.
 * -----------------------------------------------------------------------------------------
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
 Memory Usage: 33.9 MB, less than 99.93% of Java online submissions for Spiral Matrix.
 *------------------------------------------------------------------------------------------
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example 1:

 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:

 Input:
 [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
 ]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>(matrix.length*matrix[0].length);
        int i=0;
        while(res.size()< matrix.length*matrix[0].length){
            traverseLayer(matrix,res,i);
            i++;
        }
        return res;
    }

    private void traverseLayer(int[][] matrix, List<Integer> res,int layer){
        int len = matrix.length*matrix[0].length;
        int i=layer,j;
        for ( j = layer; j < matrix[0].length - layer; j++) {
            res.add(matrix[i][j]);
        }
        if(res.size()==len){
            return;
        }
        j--;
        i++;
        for ( ; i <matrix.length-layer ; i++) {
            res.add(matrix[i][j]);
        }
        if(res.size()==len){
            return;
        }
        i--;
        j--;
        for ( ; j>layer-1 ; j--) {
            res.add(matrix[i][j]);
        }
        if(res.size()==len){
            return;
        }
        j++;
        i--;
        for ( ; i >layer ; i--) {
            res.add(matrix[i][j]);
        }

    }
}
