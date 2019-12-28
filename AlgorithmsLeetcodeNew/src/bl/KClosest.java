package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/6/2019.
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]
 Note:
 The value k is positive and will always be smaller than the length of the sorted array.
 Length of the given array is positive and will not exceed 104
 Absolute value of elements in the array and x will not exceed 104
 */
public class KClosest {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int anArr : arr) {
            list.add(anArr);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - x) > Math.abs(o2 - x)) {
                    return 1;
                } else if (Math.abs(o1 - x) < Math.abs(o2 - x)) {
                    return -1;
                }
                return 0;
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = k-1; i > -1; i--) {
           res.add(list.get(i));
        }
        Collections.sort(res);
        return res;

    }

    public List<Integer> findClosestElementsMaxHeap(int[] arr, int k, int x) {
        PriorityQueue<PairOfInt> queue = new PriorityQueue<>(new Comparator<PairOfInt>() {
            @Override
            public int compare(PairOfInt o1, PairOfInt o2) {
                if(o1.key>o2.key){
                    return 1;
                }
                if(o1.key<o2.key){
                    return -1;
                }
                return 0;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(new PairOfInt(Math.abs(arr[i]-x),i));
        }
        for (int i = k; i <arr.length ; i++) {
            if(queue.peek().key>Math.abs(arr[i]-x)){
                queue.remove();
                queue.add(new PairOfInt(Math.abs(arr[i]-x),i));
            }
        }
        List<Integer> res = new ArrayList<>(k);
        for (; queue.size()>0; ) {
            res.add(0,arr[queue.remove().value]);
        }
        return res;
    }

    class PairOfInt{
        public int key,value;
        public PairOfInt(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
     int[] arr = {1,2,3,4,5};
        System.out.println(new KClosest().findClosestElementsMaxHeap(arr,4,3));
    }

}
