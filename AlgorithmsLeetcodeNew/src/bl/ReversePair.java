package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/8/2019.
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

 You need to return the number of important reverse pairs in the given array.

 Example1:

 Input: [1,3,2,3,1]
 Output: 2
 Example2:

 Input: [2,4,3,5,1]
 Output: 3
 Note:
 The length of the given array will not exceed 50,000.
 All the numbers in the input array are in the range of 32-bit integer.

 */
public class ReversePair {
    public int reversePairs(int[] nums) {
        List<Integer> res= new ArrayList<>();
        List<Long> cur= new ArrayList<>();
        int count =0;
        for (int i = nums.length-1; i > -1; i--) {
            long num = nums[i];
            count+=findPos(num,cur);
        }
        return count;
    }

    private int findPos(long num,List<Long> cur){
        int index = 0;
        if(cur.size()>0){
            int l = 0;
            int r = cur.size()-1;
            while (l<=r){
                int mid = (l+r)/2;
                if(cur.get(mid)>=num){
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            if(l>r){
                index = l;
            }
        }
        insert(num*2,cur);
        return index;
    }

    private void insert(long num,List<Long> cur){
        int index = 0;
        if(cur.size()>0){
            int l = 0;
            int r = cur.size()-1;
            while (l<=r){
                int mid = (l+r)/2;
                if(cur.get(mid)>=num){
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            if(l>r){
                index = l;
            }
        }
        cur.add(index,num);
    }

    public static void main(String[] args) {
        System.out.println(new ReversePair().reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647}));
    }


}
