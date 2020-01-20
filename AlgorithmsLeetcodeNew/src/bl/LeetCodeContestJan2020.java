package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Akshay Hegde on 1/18/2020.
 *
 */
public class LeetCodeContestJan2020 {
    //Given a positive integer num consisting only of digits 6 and 9.

    //Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
    public int maximum69Number (int num) {
        int first = -1;
        int t = num;
        while(t>0){
            int rem = t%10;
            if(rem==6){
                first = t;
            }
            t/=10;
        }
        if(first==-1){
            return num;
        }
        long res = 0;
        t = num;
        while (t>0){
            int rem = t%10;
            if(t==first){
                res = res*10+9;
            }
            else{
                res = res*10+rem;
            }
            t/=10;
        }
        int ans = 0;
        while(res>0){
            int rem = (int) (res%10);
            ans = ans*10+rem;
            res/=10;
        }
        return ans;
    }
//
//    Given a string s. Return all the words vertically in the same order in which they appear in s.
//    Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
//    Each word would be put on only one column and that in one column there will be only one word.

    public List<String> printVertically(String s) {
        int len =0;
        StringTokenizer tokenizer = new StringTokenizer(s);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreElements()){
            String st = tokenizer.nextToken();
            if(len<=st.length()){
                len = st.length();
            }
            tokens.add(st);
        }
        List<String> res = new ArrayList<>();
        int loc = 0;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            int last = 0;
            for (int j = 0; j < tokens.size(); j++) {
                String st = tokens.get(j);
                if(loc>=st.length()){
                    sb.append(" ");
                    continue;
                }
                sb.append(tokens.get(j).charAt(loc));
                last = j;
            }
            loc++;

            res.add(sb.toString().substring(0,last+1));
        }
        return res;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) {
            return null;
        }
        TreeNode left = removeLeafNodes(root.left,target);
        TreeNode right = removeLeafNodes(root.right,target);
        if(left==null&&right==null){
            if(root.val==target){
                return null;
            }
        }
        return root;
    }


}
