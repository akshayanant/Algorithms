package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 9/22/2019.
 * 332. Reconstruct Itinerary
 Medium

 931

 609

 Favorite

 Share
 Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:

 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:

 Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 Example 2:

 Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 But it is larger in lexical order.

 */
public class ReconstructItenarary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0),new ArrayList<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        for (String key:graph.keySet()){
            Collections.sort(graph.get(key));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        String node = "JFK";
        traverse(graph,node,tickets.size(),res);
        return res;
    }

    private boolean traverse(Map<String,List<String>> graph,String node,int rem,List<String> res){
        if(rem==0){
            return true;
        }
        if(graph.get(node)==null||graph.get(node).isEmpty()){
            return false;
        }
        for (int i = 0; i < graph.get(node).size(); i++) {
            res.add(graph.get(node).get(i));
            Map<String,List<String>> copy = new HashMap<>();
            for (String key: graph.keySet()){
                List<String> val = new ArrayList<>();
                val.addAll(graph.get(key));
                if(key.equals(node)){
                    val.remove(graph.get(node).get(i));
                }
                copy.put(key,val);
            }
            if(!traverse(copy,graph.get(node).get(i),rem-1,res)){
                res.remove(res.size()-1);
            }
            else{
                return true;
            }
        }
        return false;
    }

}
