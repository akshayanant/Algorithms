package bl;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Akshay Hegde on 9/4/2019.
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 Output: [3,3,5,5,6,7]
 Explanation:

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?

 */
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length-k; i++) {
            res[i] = priorityQueue.peek();
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[i+k]);
        }
        res[res.length-1] = priorityQueue.peek();
        return res;
    }
}
