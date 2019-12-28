package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/8/2019.
 * 315. Count of Smaller Numbers After Self
 Hard

 1352

 62

 Favorite

 Share
 You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Input: [5,2,6,1]
 Output: [2,1,1,0]
 Explanation:
 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.

 */
public class CountSmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        for (int i = 0; i < nums.length-1; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[i]){
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        return res;
    }

    public List<Integer> opt(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = nums.length-1; i > -1; i--) {
            res.add(0,findPos(nums[i],cur));
        }
        return res;
    }

    private int findPos(int num,List<Integer> cur){
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
        return index;
    }
}
