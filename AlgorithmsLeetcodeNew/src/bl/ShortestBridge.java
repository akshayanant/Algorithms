package bl;

import java.util.LinkedList;

/**
 * Created by Akshay Hegde on 2/6/2020.
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

 Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

 Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)



 Example 1:

 Input: [[0,1],[1,0]]
 Output: 1
 Example 2:

 Input: [[0,1,0],[0,0,0],[0,0,1]]
 Output: 2
 Example 3:

 Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 Output: 1


 Note:

 1 <= A.length = A[0].length <= 100
 A[i][j] == 0 or A[i][j] == 1

 */
public class ShortestBridge {
    class Cell{
        int x;
        int y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] vect = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int fill = -1;
        int[][] B = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j]==1){
                    dfs(A,i,j,fill--);
                }
                if(A[i][j]==0){
                    A[i][j] = Integer.MAX_VALUE;
                    B[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j]==-1){
                    A[i][j] = 0;
                    bfs(A,i,j);
                    A[i][j] = -1;
                }
                if(A[i][j]==-1||A[i][j]==-2){
                    B[i][j]=A[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(B[i][j]==-2){
                    B[i][j] = 0;
                    bfs(B,i,j);
                    B[i][j] = -2;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j]);
                if(A[i][j]>0&&A[i][j]!=Integer.MAX_VALUE&&B[i][j]!=Integer.MAX_VALUE){
                    min = Math.min(min,A[i][j]+B[i][j]-1);
                }
            }
            System.out.println();
        }
        return min;
    }

    private void dfs(int[][] A,int i, int j,int fill){
        if(i<0||j<0||i>A.length-1||j>A[0].length-1||A[i][j]!=1){
            return;
        }
        A[i][j] = fill;
        dfs(A,i-1,j,fill);
        dfs(A,i,j-1,fill);
        dfs(A,i+1,j,fill);
        dfs(A,i,j+1,fill);
    }

    private void bfs(int[][] A,int i, int j){
        LinkedList<Cell> q = new LinkedList<>();
        q.add(new Cell(i,j));
        while(!q.isEmpty()){
            Cell cell = q.poll();
            for (int k = 0; k < vect.length; k++) {
                int nextI = cell.x+vect[k][0];
                int nextJ = cell.y+vect[k][1];
                if(nextI<0||nextJ<0||nextI>A.length-1||nextJ>A[0].length-1||
                        A[nextI][nextJ]<=A[cell.x][cell.y]+1){
                    continue;
                }
                A[nextI][nextJ] = 1+A[cell.x][cell.y];
                q.add(new Cell(nextI,nextJ));
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,1},{1,0}};
        System.out.println(new ShortestBridge().shortestBridge(input));
    }
}
