package bl;

/**
 * Created by Akshay Hegde on 3/19/2019.
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.





 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. \
 In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j <height.length ; j++) {
                int area = (j-i)*Math.min(height[i],height[j]);
                if(area>maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int maxAreaOpt(int[] height){
        int maxArea = 0;
        int l=0;
        int r=height.length;
        while(l<r){
            maxArea = Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
            if(height[l]>height[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return  maxArea;
    }
}
