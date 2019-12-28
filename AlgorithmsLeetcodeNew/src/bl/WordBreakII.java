package bl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshay Hegde on 12/26/2019.
 */
public class WordBreakII {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            int n = s.length();
            List<String>[] dp = new List[n+1];
            dp[0]=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(dp[i]==null){
                    continue;
                }
                for(int j = i+1;j<=n;j++){
                    if(set.contains(s.substring(i,j))){
                        if(dp[j]==null){
                            dp[j] = new ArrayList<>();
                        }
                        dp[j].add(s.substring(i,j));
                    }
                }
            }
            List<String> res = new ArrayList<>();
            dfs(dp,n,res,"");
            return res;
        }

        private void dfs(List<String>[] dp,int end,List<String> res,String st) {
            if (end <= 0) {
                if (st.length() > 0) {
                    res.add(st.substring(0, st.length() - 1));
                }
                return;
            }
            if (dp[end] == null) {
                return;
            }
            for (String word : dp[end]) {
                dfs(dp, end - word.length(), res, word + " " + st);
            }
        }
}
