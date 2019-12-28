package bl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Akshay Hegde on 9/1/2019.
 *
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

 Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

 Example 1:
 Input: nums = [1,2,2,4]
 Output: [2,3]
 Note:
 The given array size will in the range [2, 10000].
 The given array's numbers won't have any order.

 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set =new HashSet<>();
        int dupl = nums[0];
        int sum =0;
        for (int num : nums) {
            if (set.contains(num)) {
                dupl = num;
            }
            else{
                set.add(num);
            }
            sum+=num;
        }
        int[] res = new int[2];
        nums[0] = dupl;
        int expectedSum = nums.length*(nums.length+1)/2;
        sum -=dupl;
        res[1] = expectedSum-sum;
        return res;

    }
}
