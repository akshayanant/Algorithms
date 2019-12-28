package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 10/16/2019.
 * Hi, here's your problem today. This problem was recently asked by Google:

 Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.

 Example 1:
 Input: [3, 3, 2, 1, 3, 2, 1]
 Output: [1, 1, 2, 2, 3, 3, 3]
 def sortNums(nums):
 # Fill this in.

 print sortNums([3, 3, 2, 1, 3, 2, 1])
 # [1, 1, 2, 2, 3, 3, 3]

 Challenge: Try sorting the list using constant space.

 */
public class SortListWithUnique {
 private void solution(int[] nums){
     int c1=0;
     int c2=0;
     for (int num : nums) {
         if (num == 1) {
             c1++;
         } else if (num == 2) {
             c2++;
         }
     }
     c2 = c1+c2;
     for (int i = 0; i < nums.length; i++) {
         if (i<c1){
             nums[i]=1;
         }
         else if(i<c2){
             nums[i] = 2;
         }
         else{
             nums[i] = 3;
         }
     }
 }

    public static void main(String[] args) {
        int[] in = new int[]{3, 3, 2, 1, 3, 2, 1,2};
        new SortListWithUnique().solution(in);
        System.out.println(Arrays.toString(in));
    }
}
