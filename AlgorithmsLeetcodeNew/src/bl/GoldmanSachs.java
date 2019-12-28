package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/7/2019.
 */
public class GoldmanSachs {
    public static int play(List<List<Integer>> arr) {
        if(arr.size()==0||arr.get(0).size()==0){
            return 0;
        }
        for (int i = 0; i < arr.get(0).size(); i++) {
            int max = arr.get(0).get(i);
            for (int j = 1; j < arr.size(); j++) {
                max = Math.max(max,arr.get(j).get(i));
            }
            arr.get(0).remove(i);
            arr.get(0).add(i,max);
        }
        Collections.sort(arr.get(0));
        int sum =arr.get(0).size()%2==0?0:arr.get(0).remove(0);
        for (int i = arr.get(0).size()-1; i >-1; i--) {
            sum += arr.get(0).get(i)-arr.get(0).get(i-1);
            i--;
        }
        return sum;
    }

    public static List<List<Integer>> gridGame(List<List<Integer>> grid, int k, List<String> rules) {
        if(grid.size()==0||grid.get(0).size()==0){
            return new ArrayList<>();
        }
        Set<Integer> alive = new HashSet<>();
        for (int i = 0; i < rules.size(); i++) {
            if(rules.get(i).equals("alive")) {
                alive.add(i);
            }
        }
        int[][] neighbors = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < k; i++) {
            computeNeighbors(neighbors,grid);
            for (int j = 0; j < grid.size(); j++) {
                for (int l = 0; l < grid.get(0).size(); l++) {
                    if(alive.contains(neighbors[j][l])){
                        grid.get(j).remove(l);
                        grid.get(j).add(l,1);
                    }
                    else {
                        grid.get(j).remove(l);
                        grid.get(j).add(l,0);
                    }
                }
            }
        }
        return grid;
    }

    private static void computeNeighbors(int[][] neighbors,List<List<Integer>> grid){
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                neighbors[i][j] = getNeighborStat(grid,i+1,j)+getNeighborStat(grid,i,j+1)+
                        getNeighborStat(grid,i-1,j)+getNeighborStat(grid,i,j-1)+
                        getNeighborStat(grid,i+1,j+1)+getNeighborStat(grid,i+1,j-1)+
                        getNeighborStat(grid,i-1,j+1)+getNeighborStat(grid,i-1,j-1);
            }
        }
    }
    private static int getNeighborStat(List<List<Integer>> grid,int i,int j){
        if(i<0||i>grid.size()-1||j<0||j>grid.get(0).size()-1){
            return 0;
        }
        return grid.get(i).get(j);
    }

}
