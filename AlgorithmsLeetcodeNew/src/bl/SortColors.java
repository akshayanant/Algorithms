package bl;

/**
 * Created by Akshay Hegde on 5/21/2019.
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:

 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Follow up:

 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with a one-pass algorithm using only constant space?


 */
public class SortColors {

    public void sortColors(int[] nums) {
        int zero = 0;
        int one =0;
        int two = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                zero++;
            }
            else if(nums[i] == 1){
                one++;
            }
            else{
                two++;
            }
        }
        int count = 0;
        for (; count < zero; count++) {
            nums[count] = 0;
        }
        one = zero+one;
        for(;count<one;count++){
            nums[count] = 1;
        }
        two = one+two;
        for(;count<two;count++){
            nums[count] = 2;
        }
    }
}
