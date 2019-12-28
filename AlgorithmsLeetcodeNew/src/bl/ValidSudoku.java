package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 5/10/2019.
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:

 Input:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true
 Example 2:

 Input:
 [
 ["8","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (char[] aBoard : board) {
            if (!charsValid(aBoard)) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            char[] col = new char[board.length];
            for (int j = 0; j < board.length; j++) {
                col[j] = board[j][i];
            }
            if(!charsValid(col)){
                return false;
            }
        }
        int rowStart =0;
        int colStart = 0;
        for (int i = 0; i < 9; i++) {
            if(i>2&&i<6){
                rowStart = 3;
            }
            else if(i>5){
                rowStart = 6;
            }
            colStart = (i%3)*2;

            char[] box = new char[board.length];
            int pos =0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    box[pos] = board[j+rowStart][k+colStart];
                    pos++;
                }
            }
            if(!charsValid(box)){
                return false;
            }

        }
        return true;
    }

    private boolean charsValid(char[] chars){
        Map<Character,Boolean> map = new HashMap<>(9);
        for (char aRow : chars) {
            if (map.containsKey(aRow)) {
                return false;
            }
            if (aRow != '.') {
                map.put(aRow, true);
            }

        }
        return true;
    }
}
