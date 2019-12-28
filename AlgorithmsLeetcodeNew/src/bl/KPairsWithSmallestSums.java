package bl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Akshay Hegde on 10/9/2019.
 * 373. Find K Pairs with Smallest Sums
 Medium

 823

 70

 Favorite

 Share
 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:

 Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 Output: [[1,2],[1,4],[1,6]]
 Explanation: The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:

 Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 Output: [1,1],[1,1]
 Explanation: The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:

 Input: nums1 = [1,2], nums2 = [3], k = 3
 Output: [1,3],[2,3]
 Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

 */
public class KPairsWithSmallestSums {
    class Pairs{
        int sum;
        int a,b;

        public Pairs(int sum,int a,int b) {
            this.sum = sum;
            this.a = a;
            this.b=b;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length==0||nums2.length==0||k<=0||k>nums1.length*nums2.length){
            return res;
        }
        PriorityQueue<Pairs> queue = new PriorityQueue<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs o1, Pairs o2) {
                return o1.sum-o2.sum;
            }
        });
        for (int aNums1 : nums1) {
            for (int aNums2 : nums2) {
                queue.add(new Pairs(aNums1 + aNums2, aNums1, aNums2));
            }
        }
        int index = 0;
        while (index<k&&!queue.isEmpty()){
            Pairs pairs = queue.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(pairs.a);
            pair.add(pairs.b);
            res.add(pair);
            index++;
        }
        return res;
    }
}
