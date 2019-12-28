package bl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Akshay Hegde on 10/11/2019.
 *
 */
public class LongestSubStringWithoutRepeat {
    private int longestSubStr(String s){
        int n = s.length();
        if(n==0){
            return 0;
        }
        Set<Character> characterHashSet = new HashSet<>();
        int max =0;
        int count;
        for (int i = 0,j=0; i < s.length()&&j<s.length();) {
            if(!characterHashSet.contains(s.charAt(j))){
                count = j-i+1;
                max = Math.max(max,count);
                characterHashSet.add(s.charAt(j++));
            }else{
                characterHashSet.remove(s.charAt(i++));
            }
        }
        return max;
     }


    private int maxKRepeat(String s, int k){
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        while (i<s.length()&&j<s.length()){
            if(set.contains(s.charAt(j))){
                if(k>0){
                    j++;
                    k--;
                    max = Math.max(max,j-i);
                }
                else{
                    i++;
                    if(s.charAt(i)==s.charAt(j)){
                        k++;
                    }
                    set.remove(s.charAt(i));
                }
            }
            else{
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,j-i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutRepeat().longestSubStr("abcdaafg"));
        System.out.println(new LongestSubStringWithoutRepeat().maxKRepeat("abcdaafg",1));

    }
}
