package bl;

/**
 * Created by Akshay Hegde on 5/23/2019.
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int charIndex = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int saveI = i;
                int saveJ =j;
                if(board[i][j] == word.charAt(charIndex)){
                    boolean[][] visisted = new boolean[board.length][board[0].length];
                    visisted[i][j] = true;
                    charIndex++;
                    while(true){
                        if(charIndex == word.length()){
                            return true;
                        }
                        int[] reply = getNeighbour(board,i,j,word.charAt(charIndex),visisted);
                        if(reply[0]!=-1) {
                            charIndex++;
                            visisted[reply[0]][reply[1]] = true;
                            i=reply[0];
                            j=reply[1];
                        }
                        else{
                            break;
                        }
                    }
                    charIndex = 0;
                    i = saveI;
                    j=saveJ;
                }
            }
        }
        return false;
    }

    private int[] getNeighbour(char[][] board, int i, int j, char ch,boolean[][] visisted){
        if(i-1>-1 && board[i-1][j]==ch&&!visisted[i-1][j]){
            return new int[]{i-1,j};
        }
        if(i+1<board.length&&board[i+1][j]==ch&&!visisted[i+1][j]){
            return new int[]{i+1,j};
        }
        if(j-1>-1 && board[i][j-1]==ch&&!visisted[i][j-1]){
            return new int[]{i,j-1};
        }
        if(j+1<board[0].length &&board[i][j+1]==ch&&!visisted[i][j+1]){
            return new int[]{i,j+1};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(new WordSearch().exist(input,"ABCCED"));
    }
}
