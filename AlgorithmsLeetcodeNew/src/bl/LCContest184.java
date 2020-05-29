package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 4/11/2020.
 */
public class LCContest184 {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i==j){
                    continue;
                }
                if(words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i < m; i++) {
            list.add(i+1);
        }
        for (int i = 0; i < n; i++) {
            int num = queries[i];
            int pos = list.indexOf(num);
            res[i] = pos;
            list.removeFirstOccurrence(num);
            list.addFirst(num);
        }
        return res;
    }

    public String entityParser(String text) {
        Map<String,String> map = new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        int min =-1;
        while (true){
            int index = Integer.MAX_VALUE;
            String val = "";
            for(String key: map.keySet()){
                int temp = sb.indexOf(key);
                if(temp==-1){
                    continue;
                }
                if(index>temp && temp>min){
                    index = temp;
                    val =key;
                }
            }
            if(index==Integer.MAX_VALUE){
                break;
            }
            String tag = map.get(val);
            String s = sb.substring(0,index)+val+sb.substring(index+tag.length());
            min = index +val.length()-1;
            sb = new StringBuilder();
            sb.append(s);

        }
        return sb.toString();
    }

}
