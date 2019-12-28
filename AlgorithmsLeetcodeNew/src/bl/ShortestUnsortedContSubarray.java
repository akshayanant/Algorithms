package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 9/5/2019.
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 */
public class ShortestUnsortedContSubarray {
    public int findUnsortedSubarray(int[] nums) {
//        int start = 0;
//        int end = -1;
//        boolean startFound = false;
//        for (int i = 0; i < nums.length-1; i++) {
//            if(nums[i]>nums[i+1]){
//                if(!startFound){
//                    startFound = true;
//                    start = i;
//                    end = i+1;
//                }
//                else{
//                    end = i+1;
//                }
//            }
//            if(nums[i]==nums[i+1]&&startFound){
//                end++;
//            }
//        }
        if(nums.length<2){
            return 0;
        }

        int[] sort = nums.clone();
        Arrays.sort(sort);
        boolean startFound = false;
        int start =0;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=sort[i]){
                if(!startFound){
                    startFound = true;
                    start = i;
                }
                else{
                    end = i;
                }
            }
        }
        return end-start+1;
    }
}
