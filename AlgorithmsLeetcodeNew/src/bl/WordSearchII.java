package bl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Akshay Hegde on 10/15/2019.
 * 212. Word Search II
 Hard

 1466

 81

 Favorite

 Share
 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



 Example:

 Input:
 board = [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 words = ["oath","pea","eat","rain"]

 Output: ["eat","oath"]


 Note:

 All inputs are consist of lowercase letters a-z.
 The values of words are distinct.

 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word:words){
            if(exist(board,word)){
                res.add(word);
            }
        }
        return res;
    }

    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n = board[0].length;
        if(word.length()>m*n){
            return false;
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(dfs(word,i,j,board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(String s, int i, int j, char[][] board){
        if(s.length()==1&&s.charAt(0)==board[i][j]){
            return true;
        }
        boolean res;
        char ch = board[i][j];
        board[i][j] = ' ';
        if(s.charAt(1)==getNeighbor(i+1,j,board)){
            res = dfs(s.substring(1),i+1,j,board);
            if(res){
                board[i][j] = ch;

                return true;
            }
        }
        if(s.charAt(1)==getNeighbor(i,j+1,board)){
            res = dfs(s.substring(1),i,j+1,board);
            if(res){
                board[i][j] = ch;
                return true;
            }
        }
        if(s.charAt(1)==getNeighbor(i-1,j,board)){
            res = dfs(s.substring(1),i-1,j,board);
            if(res){
                board[i][j] = ch;
                return true;
            }
        }
        if(s.charAt(1)==getNeighbor(i,j-1,board)){
            res = dfs(s.substring(1),i,j-1,board);
            if(res){
                board[i][j] = ch;
                return true;
            }
        }
        board[i][j] = ch;
        return false;
    }


    private boolean bfs(String s, int i, int j, char[][] board){
        boolean[][] visit = new boolean[board.length][board[0].length];
        LinkedList<Integer> rowQue = new LinkedList<>();
        LinkedList<Integer> colQue = new LinkedList<>();
        rowQue.add(i);
        colQue.add(j);
        rowQue.add(-1);
        colQue.add(-1);
        int index =1;
        boolean found = true;
        while (!rowQue.isEmpty()&&index<s.length()){
            int row = rowQue.poll();
            int col = colQue.poll();
            if(row==-1){
                index++;
                if(index!=s.length()){
                    found = false;
                }
                rowQue.add(-1);
                colQue.add(-1);
                continue;
            }
            visit[row][col] =true;
            List<int[]> nexts = getNexts(visit,row,col);
            for(int[] cell : nexts){
//                if(visit[cell[0]][cell[1]]){
//                    continue;
//                }
                if(board[cell[0]][cell[1]]==s.charAt(index)){
                    rowQue.add(cell[0]);
                    colQue.add(cell[1]);
                    found = true;
                }
            }
        }
        return found;
    }

    private List<int[]> getNexts(boolean[][] visit, int i, int j){
        List<int[]> nexts = new ArrayList<>();
        if(i!=0&&!visit[i-1][j]){
            int[] top = new int[]{i-1,j};
            nexts.add(top);
        }
        if(j!=0&&!visit[i][j-1]){
            int[] left = new int[]{i,j-1};
            nexts.add(left);
        }
        if(i!=visit.length-1&&!visit[i+1][j]){
            int[] down = new int[]{i+1,j};
            nexts.add(down);
        }
        if(j!=visit[0].length-1&&!visit[i][j+1]){
            int[] right = new int[]{i,j+1};
            nexts.add(right);
        }
        return nexts;
    }

    private char[][] copy(char[][] board){
        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, board[0].length);
        }
        return copy;
    }

    private char getNeighbor(int i, int j,char[][] board){
        if(i<0||j<0||i>board.length-1||j>board[0].length-1){
            return '*';
        }
        return board[i][j];
    }
}
