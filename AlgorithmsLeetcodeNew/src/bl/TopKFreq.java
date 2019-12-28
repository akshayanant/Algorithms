package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 10/6/2019.
 * 347. Top K Frequent Elements
 Medium

 1887

 117

 Favorite

 Share
 Given a non-empty array of integers, return the k most frequent elements.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]
 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
public class TopKFreq {
    class Pair{
        int num;
        int count;
        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Pair> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.get(num).count++;
            } else {
                Pair pair = new Pair(num, 1);
                map.put(num,pair);
            }
        }
        List<Pair> list = new ArrayList<>();
        for(int key:map.keySet()){
            list.add(map.get(key));
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count-o1.count;
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).num);
        }
        return res;
    }
}
