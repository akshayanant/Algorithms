package bl;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Akshay Hegde on 11/24/2019.
 * 632. Smallest Range Covering Elements from K Lists
 Hard

 820

 22

 Favorite

 Share
 You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

 We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.



 Example 1:

 Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 Output: [20,24]
 Explanation:
 List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 List 2: [0, 9, 12, 20], 20 is in range [20,24].
 List 3: [5, 18, 22, 30], 22 is in range [20,24].


 Note:

 The given list may contain duplicates, so ascending order means >= here.
 1 <= k <= 3500
 -105 <= value of elements <= 105.

 */
public class SmallestRangeKLists {
    class ListDetais{
        List<Integer> list;
        int index;
        public ListDetais(List<Integer> list){
            this.list = list;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<ListDetais> minHeap = new PriorityQueue<>(new Comparator<ListDetais>() {
            @Override
            public int compare(ListDetais o1, ListDetais o2) {
                return o1.list.get(o1.index)-o2.list.get(o2.index);
            }
        });
        PriorityQueue<ListDetais> maxHeap = new PriorityQueue<>(new Comparator<ListDetais>() {
            @Override
            public int compare(ListDetais o1, ListDetais o2) {
                return -o1.list.get(o1.index)+o2.list.get(o2.index);
            }
        });
        for(List<Integer> num:nums){
            minHeap.add(new ListDetais(num));
            maxHeap.add(new ListDetais(num));
        }
        int[] range = new int[2];
        int dif = Integer.MAX_VALUE;
        while (minHeap.size()==nums.size()) {
            ListDetais min = minHeap.poll();
            ListDetais max = maxHeap.peek();
            maxHeap.remove(min);
            if(dif<max.list.get(max.index)-min.list.get(min.index)){
                dif = max.list.get(max.index)-min.list.get(min.index);
                range[0] = min.list.get(min.index);
                range[1] = max.list.get(max.index);
            }
            if(min.index<min.list.size()-1){
                min.index++;
                minHeap.add(min);
                maxHeap.add(min);
            }
        }
        return range;
    }
}
