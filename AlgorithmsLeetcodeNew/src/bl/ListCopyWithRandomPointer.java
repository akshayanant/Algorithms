package bl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 6/19/2019.
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.



 Example 1:



 Input:
 {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

 Explanation:
 Node 1's value is 1, both of its next and random pointer points to Node 2.
 Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
public class ListCopyWithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        Map<Node,Node> visited = new HashMap<>();
        return recusrsion(head,visited);
    }

    private Node recusrsion(Node node, Map<Node,Node> visited){
        if(node==null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        visited.put(node, newNode);
        newNode.next = recusrsion(node.next,visited);
        newNode.random = recusrsion(node.random,visited);
        return newNode;
    }
}
