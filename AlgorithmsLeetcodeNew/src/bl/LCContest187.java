package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/2/2020.
 */
public class LCContest187 {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        Set<String> source = new HashSet<>();
        for(List<String> path:paths ){
            String src = path.get(0);
            String dest = path.get(1);
            cities.add(src);
            cities.add(dest);
            source.add(src);
        }
        for(String city:cities){
            if(!source.contains(city)){
                return city;
            }
        }
        return "";
    }

    public boolean kLengthApart(int[] nums, int k) {
        int n =nums.length;
        int prev = Integer.MIN_VALUE+100;
        for (int i = 0; i < n; i++) {
            if(nums[i]==1){
                if(i-prev<=k){
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }

    public int longestSubarray(int[] nums, int limit) {
        int i=0;
        int j=0;
        int n = nums.length;
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> min  = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        max.add(nums[0]);
        min.add(nums[0]);
        j++;
        int res =0;
        while(j<n){
            int minTop = min.peek();
            int maxTop = max.peek();
            if(maxTop-minTop<=limit){
                res = Math.max(res,j-i);
                System.out.println(i);
                System.out.println(j);
                j++;
                if(j==n){
                    break;
                }
                min.add(nums[j]);
                max.add(nums[j]);
            }
            else {
                min.remove(nums[i]);
                max.remove(nums[i]);
                i++;
            }
        }
        return res;
    }

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] index = new int[m];
        for (int i = 0; i < k-1; i++) {
            int minDiff = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < m; j++) {
                if(index[j]==n-1){
                    continue;
                }
                if(mat[j][index[j]+1]-mat[j][index[j]]<minDiff){
                    minDiff = mat[j][index[j]+1]-mat[j][index[j]];
                    minIndex = j;
                }
            }
            System.out.println(minIndex);
            index[minIndex]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res+=mat[i][index[i]];
        }
        return res;
    }
}
