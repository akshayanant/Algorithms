package bl;

/**
 * Created by Akshay Hegde on 8/20/2019.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3

 */

class DisjointUnionSet{
    int[] ranks;
    int[] parents;
    int size;

    public DisjointUnionSet(int size) {
        ranks = new int[size];
        parents = new int[size];
        this.size = size;
        init();
    }

    private void init(){
        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
    }

    public int getParent(int child){
        if(parents[child]!=child){
            return getParent(parents[child]);
        }
        return child;
    }

    public void union(int x, int y){
        int rootX = getParent(x);
        int rootY = getParent(y);
        if(rootX == rootY){
            return;
        }
        if(ranks[rootX]>ranks[rootY]){
            parents[rootY] = rootX;
        }
        else if(ranks[rootX]<ranks[rootY]){
            parents[rootX] = rootY;
        }
        else{
            parents[rootY] = rootX;
            ranks[rootX]++;
        }
    }
}
public class Islands {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(grid.length*grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='0'){
                    continue;
                }
                if(get(grid,i-1,j)=='1'){
                    disjointUnionSet.union(i*grid[0].length+j,(i-1)*grid[0].length+j);
                }
                if(get(grid,i+1,j)=='1'){
                    disjointUnionSet.union(i*grid[0].length+j,(i+1)*grid[0].length+j);
                }
                if(get(grid,i,j-1)=='1'){
                    disjointUnionSet.union(i*grid[0].length+j,(i)*grid[0].length+j-1);
                }
                if(get(grid,i,j+1)=='1'){
                    disjointUnionSet.union(i*grid[0].length+j,(i)*grid[0].length+j+1);
                }
            }
        }
        int islandCount =0;
        int[] setFrequency = new int[grid.length*grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='0'){
                    continue;
                }
                int parent = disjointUnionSet.getParent(i*grid[0].length+j);
                if(setFrequency[parent]==0){
                    islandCount++;
                }
                setFrequency[parent]++;
            }
        }
        return islandCount;
    }

    private char get(char[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return 0;
        }
        return grid[i][j];
    }

    public static void main(String[] args) {
        char[][] in = new char[][]{{'1','1','0','0','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','1','0','0'},
                                    {'0','0','0','1','1'}};
        System.out.println(new Islands().numIslands(in));
    }

}
