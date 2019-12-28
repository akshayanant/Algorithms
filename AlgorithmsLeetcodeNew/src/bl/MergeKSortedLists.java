package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akshay Hegde on 4/12/2019.
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        Collections.addAll(list, lists);
        while(list.size()>2){
            for (int i = 0; i < list.size()-1; i++) {
                ListNode l1 = list.get(i);
                ListNode l2 = list.get(i+1);
                list.remove(l1);
                list.remove(l2);
                while(l2!=null) {
                    ListNode node = new ListNode(l2.val);
                    l1 = merge(l1,node);
                    l2 = l2.next;
                }
                list.add(l1);
            }
        }
        ListNode l1 = list.get(0);
        ListNode l2 = list.get(1);
        l1 = merge(l1,l2);
        return l1;
    }

    private ListNode merge(ListNode res,ListNode node){
        ListNode prev = null;
        ListNode cur = res;
        while(cur!=null){
            if(node.val<=cur.val){
                node.next = cur;
                if(prev==null){
                    prev=node;
                    return prev;
                }
                prev.next = node;
                return res;
            }
            prev = cur;
            cur = cur.next;
        }
        if(prev==null){
            return node;
        }
        prev.next = node;
        node.next = null;
        return res;
    }
}
