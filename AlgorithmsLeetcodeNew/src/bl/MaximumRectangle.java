package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 5/25/2019.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 Example:

 Input:
 [
 ["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]
 ]
 Output: 6
 */

public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            heights[i] = matrix[0][i]-48;
        }
        int maxArea = usngStack(heights);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='0'){
                    heights[j] = 0;
                }
                else{
                    heights[j]++;
                }
            }
            int area = usngStack(heights);
            if(area>maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int usngStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        int i;
        for (i = 0; i < nums.length; ) {
            int h = nums[i];
            if (stack.isEmpty() || nums[stack.peek()] <= h) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    int area = nums[top] * (i);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                } else {
                    int area = nums[top] * (i - stack.peek() - 1);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                int area = nums[top] * i;
                if (area > maxArea) {
                    maxArea = area;
                }
            } else {
                int area = nums[top] * (i - stack.peek() - 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;

    }
}
