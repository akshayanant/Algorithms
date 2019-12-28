package bl;

/**
 * Created by Akshay Hegde on 6/13/2019.
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 Explanation:

 Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length < 3) {
            return;
        }
        if (board[0].length < 3) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = '-';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][0]=='-'){
                recursion(board,i,0,'-','O');
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i]=='-'){
                recursion(board,0,i,'-','O');
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][board[0].length-1]=='-'){
                recursion(board,i,board[0].length-1,'-','O');
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[board.length-1][i]=='-'){
                recursion(board,board.length-1,i,'-','O');
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if(board[i][j]=='-'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void recursion(char[][] board, int i, int j,char prev, char next){
        if(i>board.length-1 ||i<0||j<0||j>board[0].length-1){
            return;
        }
        if(board[i][j]!=prev){
            return;
        }
        board[i][j] = next;
        recursion(board,i-1,j,prev,next);
        recursion(board,i,j-1,prev,next);
        recursion(board,i+1,j,prev,next);
        recursion(board,i,j+1,prev,next);
    }
}
