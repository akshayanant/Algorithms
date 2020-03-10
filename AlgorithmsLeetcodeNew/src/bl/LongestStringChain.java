package bl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * Created by Akshay Hegde on 3/4/2020.
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Map<String,Integer> map = new HashMap<>();
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            map.put(words[i],i);
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String sub = word.substring(0,j)+word.substring(j+1);
                if(map.containsKey(sub)){
                    adj[map.get(sub)].add(i);
                }
            }
        }
        int res = 0;
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++){
            if(visit[i]){
                continue;
            }
            res = Math.max(res,dfs(adj,i,visit));
        }
        return res;
    }

    private int dfs(List<Integer>[] adj, int node,boolean[] visit){
        if(visit[node]){
            return 0;
        }
        visit[node] = true;
        List<Integer> next = adj[node];
        int max = 0;
        for(int i:next){
            max = Math.max(max,dfs(adj,i,visit));
        }
        return max+1;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"sgtnz","sgtz","sgz","ikrcyoglz","ajelpkpx","ajelpkpxm","srqgtnz","srqgotnz","srgtnz","ijkrcyoglz"};
        System.out.println(new LongestStringChain().longestStrChain(input));
    }
}
