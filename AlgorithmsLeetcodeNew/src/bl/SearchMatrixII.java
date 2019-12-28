package bl;

/**
 * Created by Akshay Hegde on 9/4/2019.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 Example:

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.

 */
public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        for (int[] aMatrix : matrix) {
            if(target<aMatrix[0]){
                return false;
            }
            if(target>aMatrix[aMatrix.length-1]){
                continue;
            }
            if (binarySearch(target, aMatrix)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int a,int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==a){
                return true;
            }
            if(nums[mid]>a){
                right=mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        System.out.println(new SearchMatrixII().searchMatrix(input,5));
    }
}
