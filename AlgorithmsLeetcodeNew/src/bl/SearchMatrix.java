package bl;

/**
 * Created by Akshay Hegde on 5/21/2019.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true
 Example 2:

 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 13
 Output: false
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int l=0;
        int h = matrix.length-1;
        while(l<h){
            int mid = (l+h)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            if(target<matrix[mid][0]){
                h = mid-1;
            }
            else if(target<=matrix[mid][matrix[0].length-1]){
                l = mid;
                break;
            }
            else{
                l = mid+1;
            }
        }
        int row = l;

        l =0;
        h = matrix[row].length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(target>matrix[row][mid]){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return false;

    }
}
