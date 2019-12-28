package bl;

/**
 * Created by Akshay Hegde on 10/7/2019.
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example:

 Input: 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class NQueensII {
    public int totalNQueens(int n) {
        return rec(n,new int[n],0);
    }

    private int rec(int n,int[] cols, int row){
        if(row==n){
            return 1;
        }
        int[] copy = cols.clone();
        int sum =0;
        for (int i = 0; i < cols.length; i++) {
            if(canPlace(row,i,copy)){
                copy[row] = i;
                sum+=rec(n,copy,row+1);
            }
        }
        return sum;
    }

    private boolean canPlace(int row, int col,int[] cols){
        for (int i = 0; i < row; i++) {
            if(cols[i]==col||Math.abs(cols[i]-col)==Math.abs(row-i)){
                return false;
            }
        }
        return true;
    }
}
