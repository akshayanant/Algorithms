package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 11/10/2019.
 */
public class MinWindowsubstringII {
    public String minWindow(String s, String t) {
        int m = t.length();
        int n = s.length();
        if(m>n){
            return "";
        }
        Map<Character,Integer> tSet = new HashMap<>();
        for(int i=0;i<m;i++){
            tSet.put(t.charAt(i),tSet.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        String res = "";
        int min = Integer.MAX_VALUE;
        while(i<n&&j<n){
            char ch = s.charAt(j);
            if(tSet.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(match(tSet,map)){
                    while(i<=j){
                        char chi = s.charAt(i);
                        if(tSet.containsKey(chi)){
                            int c = map.get(chi);
                            c--;
                            map.put(chi,c);
                            if(tSet.get(chi)>map.get(chi)){
                                i++;
                                break;
                            }
                        }
                        i++;
                    }
                    if(min>j-i){
                        min = j-i;
                        res = s.substring(i-1,j+1);
                    }
                }

            }
            j++;

        }
        return res;

    }

    private boolean match(Map<Character,Integer> m1, Map<Character,Integer> m2){
        for(char ch:m1.keySet()){
            if(!m2.containsKey(ch)){
                return false;
            }
            if(m1.get(ch)>m2.get(ch)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindowsubstringII().minWindow("ADOBECODEBANCBA","DOBECODEBANCB"));
    }
}
