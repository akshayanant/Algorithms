package bl;

import java.util.ArrayList;

/**
 * Created by Akshay Hegde on 10/27/2019.
 */
public class Rivers {

}


class Program {
    class UnionFind{
        int[] parents;
        int[] ranks;

        public UnionFind(int size){
            parents= new int[size];
            ranks = new int[size];
            init();
        }

        private void init(){
            for(int i=0;i<parents.length;i++){
                parents[i] = i;
                ranks[i] = 0;
            }
        }

        public int getParent(int x){
            if(parents[x]!=x){
                return getParent(parents[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int parentX = getParent(x);
            int parentY = getParent(y);
            if(parentX==parentY){
                return;
            }
            if(ranks[parentX]>ranks[parentY]){
                parents[parentY] = parentX;
            }
            else if(ranks[parentX]<ranks[parentY]){
                parents[parentX] = parentY;

            }
            else{
                parents[parentY] = parentX;
                ranks[parentX]++;
            }
        }
    }

    public ArrayList<Integer> riverSizes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        UnionFind union = new UnionFind(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    if(getMatrix(matrix,i-1,j)==1){
                        union.union(i*n+j,(i-1)*n+j);
                    }if(getMatrix(matrix,i+1,j)==1){
                        union.union(i*n+j,(i+1)*n+j);
                    }if(getMatrix(matrix,i,j-1)==1){
                        union.union(i*n+j,(i)*n+j-1);
                    }if(getMatrix(matrix,i,j+1)==1){
                        union.union(i*n+j,(i)*n+j+1);
                    }
                }
            }
        }
        int[] count = new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    int p = union.getParent(i*n+j);
                    count[p]++;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<m*n;i++){
            if(count[i]>0){
                res.add(count[i]);
            }
        }
        return res;
    }

    private static int getMatrix(int[][] a, int i, int j){
        if(i<0||i>a.length-1||j<0||j>a[0].length-1){
            return 0;
        }
        return a[i][j];
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}};
        System.out.println(new Program().riverSizes(in));
    }
}

