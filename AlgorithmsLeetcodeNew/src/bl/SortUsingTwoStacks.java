package bl;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * 912. Sort an Array
 Medium

 164

 141

 Favorite

 Share
 Given an array of integers nums, sort the array in ascending order.



 Example 1:

 Input: [5,2,3,1]
 Output: [1,2,3,5]
 Example 2:

 Input: [5,1,1,2,0,0]
 Output: [0,0,1,1,2,5]

 */
public class SortUsingTwoStacks {
    public int[] sortArray(int[] nums) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int num:nums){
            stack1.push(num);
        }
        while (!stack1.isEmpty()){
            int pop = stack1.pop();
            while (!stack2.isEmpty()&&stack2.peek()<pop){
                stack1.push(stack2.pop());
            }
            stack2.push(pop);
        }
        int[] res = new int[nums.length];
        for (int i = 0; !stack2.isEmpty(); i++) {
            res[i] = stack2.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,5,3,1,6,7,0,0};
        System.out.println(Arrays.toString(new SortUsingTwoStacks().sortArray(input)));
    }

}
