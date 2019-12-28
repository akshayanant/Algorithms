package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/24/2019.
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary the task is to complete the function which returns a string denoting the order of characters in the language.
 Note: Many orders may be possible for a particular test case, thus you may return any valid order.
 Examples:
 Input:  Dict[] = { "baa", "abcd", "abca", "cab", "cad" }, k = 4
 Output: Function returns "bdac"
 Here order of characters is 'b', 'd', 'a', 'c'
 Note that words are sorted and in the given language "baa"
 comes before "abcd", therefore 'b' is before 'a' in output.
 Similarly we can find other orders.

 Input: Dict[] = { "caa", "aaa", "aab" }, k = 3
 Output: Function returns "cab"

 */
public class AlienDictionary {
    public String alienDict(List<String> words, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String s = words.get(i);
            for (int j = i + 1; j < words.size(); j++) {
                String t = words.get(j);
                int index = 0;
                while (index < s.length() && index < t.length() && s.charAt(index) == t.charAt(index)) {
                    index++;
                }
                if (index < s.length() && index < t.length()) {
                    if (!map.containsKey(s.charAt(index) - 'a')) {
                        map.put((int)s.charAt(index)-'a', new HashSet<>());
                    }
                    map.get((int)s.charAt(index) - 'a').add((int)t.charAt(index) - 'a');
                }
            }
        }
        Stack<Integer> res = new Stack<>();
        Set<Integer> black = new HashSet<>();
        for(int i=0;i<k;i++){
            dfs(map,black,res,i);
        }
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()){
            sb.append((char)(res.pop()+'a'));
        }
        return sb.toString();
    }

    private void dfs(Map<Integer,Set<Integer>> white,Set<Integer> black,
                     Stack<Integer> stack,int node){
        if(black.contains(node)){
            return;
        }
        Set<Integer> children = white.remove(node);
        if(children==null||children.isEmpty()){
            stack.push(node);
            black.add(node);
            return;
        }
        for(int child:children){
            dfs(white,black,stack,child);
        }
        black.add(node);
        stack.push(node);
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("caa");
        words.add("aaa");
        words.add("aab");
        System.out.println(new AlienDictionary().alienDict(words,3));
    }
}
