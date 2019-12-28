package bl;

/**
 * Created by Akshay Hegde on 5/16/2019.
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 A sudoku solution must satisfy all of the following rules:

 Each of the digits 1-9 must occur exactly once in each row.
 Each of the digits 1-9 must occur exactly once in each column.
 Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 Empty cells are indicated by the character '.'.


 A sudoku puzzle...


 ...and its solution numbers marked in red.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        System.out.println(backTracking(board));
    }

    private boolean backTracking(char[][] board) {
        boolean complete = true;
        int row = 0;
        int col = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    complete = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (!complete) {
                break;
            }
        }
        if (complete) {
            return true;
        }

        for (char k = '1'; k <= '9'; k++) {
            if (isSafe(board, row, col, k)) {
                board[row][col] = k;
                System.out.println(" added at "+row+" , "+col+"  --> "+k );
                if (backTracking(board)) {
                    return true;
                }
                System.out.println(" removed "+k );

                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char num){
        return rowSafe(board,row,num)&&colSafe(board,col,num)&&boxSafe(board,col,row,num);
    }

    private boolean rowSafe(char[][] board, int row, char num){
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num){
                return false;
            }
        }
        return true;
    }

    private boolean colSafe(char[][] board, int col, char num){
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == num){
                return false;
            }
        }
        return true;
    }

    private boolean boxSafe(char[][] board, int col,int row, char num){
        int startI =0;
        int startJ = 0;
        if(row>2 && row<6){
            startI = 3;
        }
        else if(row>5){
            startI = 6;
        }
        if(col>2 && col<6){
            startJ = 3;
        }
        else if(col>5){
            startJ = 6;
        }
        int endI = startI+3;
        int endJ = startJ+3;
        for (int i = startI; i <endI ; i++) {
            for (int j = startJ; j < endJ; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input;
        input = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        new SudokuSolver().solveSudoku(input);
        for (int i = 0; i < 9; i++) {
            System.out.println(input[i]);
        }
    }
}
