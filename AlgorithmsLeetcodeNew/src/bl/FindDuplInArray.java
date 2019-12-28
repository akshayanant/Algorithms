package bl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 442. Find All Duplicates in an Array
 Medium

 1341

 123

 Favorite

 Share
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]

 */
public class FindDuplInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0){
                set.add(Math.abs(nums[i]));
            }
            else{
                nums[index]*=-1;
            }
        }
        res.addAll(set);
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,4};
        System.out.println(new FindDuplInArray().findDuplicates(input));
    }
}
