package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 6/18/2019.
 *
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.



 Example:



 Input:
 {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

 Explanation:
 Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 Node 4's value is 4, and it has two neighbors: Node 1 and 3.


 Note:

 The number of nodes will be between 1 and 100.
 The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 You must return the copy of the given node as a reference to the cloned graph.


 */



public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node> visited = new HashMap<>();
        return recursion(node,visited);
    }

    private Node recursion(Node node,Map<Node,Node> visited){
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        visited.put(node,newNode);
        List<Node> neighbors = new ArrayList<>();
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node node1 = recursion(node.neighbors.get(i),visited);
            neighbors.add(node1);
        }
        newNode.neighbors = neighbors;
        return newNode;
    }
}
