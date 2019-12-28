package bl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akshay Hegde on 10/15/2019.
 */
public class ZeroSumSubArray {
    private int[] solution(int[] nums){
        int n = nums.length;
        Map<Integer,Integer> sumMap = new HashMap<>();
        int sum =0;
        sumMap.put(0,-1);
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            if(sumMap.containsKey(sum)) {
                int start = sumMap.get(sum) + 1;
                int[] res = new int[i-start+1];
                for (int j = 0; j+start <= i; j++) {
                    res[j] = nums[j+start];
                }
                return res;
            }
            sumMap.put(sum,i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, -8, 3, -2, -1,8};
        System.out.println(Arrays.toString(new ZeroSumSubArray().solution(input)));
    }
}
