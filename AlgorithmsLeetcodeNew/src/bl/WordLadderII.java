package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 12/26/2019.
 */

public class WordLadderII {
    class Node{
        String word;
        List<String> next;
        public Node(String w,List<String> l){
            word = w;
            next = l;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        Map<String,List<String>> adj = new HashMap<>();
        int n = wordList.size();
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                String st1 =wordList.get(i) ;
                String st2 = wordList.get(j);
                if(oneChange(st1,st2)){
                    if(!adj.containsKey(st1)){
                        adj.put(st1,new ArrayList<>());
                    }
                    adj.get(st1).add(st2);
                    if(!adj.containsKey(st2)){
                        adj.put(st2,new ArrayList<>());
                    }
                    adj.get(st2).add(st1);
                }
            }
        }
        return bfs(adj,beginWord,endWord);
    }

    private List<List<String>> bfs(Map<String,List<String>> adj,String begin,String end){
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(begin, Collections.singletonList(begin)));
        q.add(null);
        boolean done = false;
        List<List<String>> res = new ArrayList<>();
        Set<String> visit = new HashSet<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node==null){
                if(!q.isEmpty()&&!done){
                    q.add(null);
                    continue;
                }
                else{
                    return res;
                }
            }
            if(node.word.equals(end)){
                done = true;
                res.add(node.next);
                continue;
            }
            List<String> words= adj.get(node.word);
            if(words!=null){
                for(String s:words){
                    if(visit.contains(s)){
                        continue;
                    }
                    List<String> nexts = new ArrayList<>();
                    nexts.addAll(node.next);
                    nexts.add(s);
                    q.add(new Node(s,nexts));
                }
            }
            visit.add(node.word);
        }
        return res;
    }

    private boolean oneChange(String s1,String s2){
        boolean change = false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(change){
                    return false;
                }
                change = true;
            }
        }
        return true;
    }
}
