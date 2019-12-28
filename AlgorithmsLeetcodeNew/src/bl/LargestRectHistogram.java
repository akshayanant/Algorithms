package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 5/25/2019.
 * <p>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class LargestRectHistogram {

    public int largestRectangleArea(int[] heights) {
//        if(heights.length==0){
//            return 0;
//        }
//        int maxArea = heights[0];
//        for (int i = 1; i < heights.length; i++) {
//            int min = heights[i];
//            if(heights[i]>maxArea){
//                maxArea = heights[i];
//            }
//            for (int j = i-1; j >-1 ; j--) {
//                if(min>heights[j]){
//                    min = heights[j];
//                }
//                int area = min*(i-j+1);
//                if (area>maxArea){
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;
        return usngStack(heights);
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
