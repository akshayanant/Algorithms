package bl;

import java.util.ArrayList;
import java.util.List;


//---------------------INCOMPLETE--------------------
/**
 * Created by Akshay Hegde on 5/16/2019.
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        if (n == 2 || n == 3) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        if(n==1){
            List<String> lis = new ArrayList<>();
            lis.add("Q");
            res.add(lis);
            return res;
        }
        boolean[] firstRow = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(firstRow[i] && n%2==0){
                continue;
            }
            List<String> board = generateList(n);
            boolean exists = backTracking(board, i, i);
            if (exists) {
                if(!(firstRow[board.get(0).indexOf('Q')] &&n%2==0)) {
                    firstRow[board.get(0).indexOf('Q')] = true;
                    res.add(board);
                }
            }
        }
        System.out.println(res.size());
        return res;
    }


    private List<String> generateList(int n) {
        List<String> empty = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            empty.add(String.valueOf(row));
        }
        return empty;
    }

    private boolean backTracking(List<String> board, int col, int offset) {
        if (col >= board.size() + offset) {
            return true;
        }
        int oldCol = col;
        for (int i = 0; i < board.size(); i++) {
            col = col % board.size();
            if (isSafe(board, i, col)) {
                String row = board.get(i);
                String first = "";
                if (col != 0) {
                    first = row.substring(0, col);
                }
                String next = "";
                if (col < board.size() - 1) {
                    next = row.substring(col + 1);
                }
                board.remove(i);
                board.add(i, first + "Q" + next);
                col = oldCol;
                if (backTracking(board, col + 1, offset)) {
                    return true;
                }
                board.remove(i);
                board.add(i, row);
            }

        }
        return false;
    }

    private boolean isSafe(List<String> board, int row, int col) {
        if(board.get(row).contains("Q")){
            return false;
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (board.get(i).charAt(j) == 'Q' && (i == row || j == col || Math.abs(i - row) == Math.abs(j - col))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(5));
    }
}
