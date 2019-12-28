package bl;

/**
 * Created by Akshay Hegde on 5/11/2019.
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int[] dpL = new int[height.length];
        dpL[0] = 0;
        for (int i = 1; i < height.length; i++) {
            dpL[i] = Math.max(dpL[i-1],height[i-1]);
        }

        int[] dpR = new int[height.length];
        dpL[height.length-1] = 0;
        for (int i = height.length-2; i > -1; i--) {
            dpR[i] = Math.max(dpR[i+1],height[i+1]);
        }
        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            int v = Math.min(dpL[i],dpR[i])-height[i];
            if(v>0){
                volume+=v;
            }
        }
        return volume;
    }
}
