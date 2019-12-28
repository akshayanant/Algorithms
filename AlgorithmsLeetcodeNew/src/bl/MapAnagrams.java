package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/15/2019.
 *
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.

 */
public class MapAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Character,Integer>> strMaps = new ArrayList<>(strs.length);
        for (String str : strs) {
            Map<Character, Integer> map = new HashMap<>(str.length());
            for (int j = 0; j < str.length(); j++) {
                if (map.containsKey(str.charAt(j))) {
                    int count = map.get(str.charAt(j));
                    map.put(str.charAt(j), count + 1);
                } else {
                    map.put(str.charAt(j), 1);
                }
            }
            strMaps.add(map);
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] added = new boolean[strs.length];
        for (int i = 0; i <strMaps.size()-1 ; i++) {
            if(added[i]){
                continue;
            }
            Map<Character,Integer> mapMaster = strMaps.get(i);
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[i]);
            for (int j = i+1; j <strMaps.size() ; j++) {
                if(added[j]){
                    continue;
                }
                Map<Character,Integer> mapSlave = strMaps.get(j);
                if(mapSlave.size()!=mapMaster.size()){
                    continue;
                }
                boolean allMatch = true;
                Set<Character> characters = mapSlave.keySet();
                for (Character ch: characters) {
                    if(mapMaster.containsKey(ch)) {
                        int count = mapSlave.get(ch);
                        if (count != mapMaster.get(ch)) {
                            allMatch = false;
                            break;
                        }
                    }
                    else{
                        allMatch = false;
                        break;
                    }

                }
                if(allMatch){
                    added[j] = true;
                    anagrams.add(strs[j]);
                }
            }
            if(!anagrams.isEmpty()){
                res.add(anagrams);
            }
        }
        return res;
    }

    private List<List<String>> usingSort(String[] str){
        Map<String, List<String>> res = new HashMap<>();
        for (String aStr : str) {
            char[] chars = aStr.toCharArray();
            Arrays.sort(chars);
            String st = new String(chars);
            if (res.containsKey(st)) {
                res.get(st).add(aStr);
            } else {
                List<String> list = new ArrayList<>();
                list.add(aStr);
                res.put(st, list);
            }
        }
        return (List<List<String>>) res.values();
    }

    public static void main(String[] args) {
        System.out.println(new MapAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
