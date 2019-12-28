package bl;

/**
 * Created by Akshay Hegde on 10/19/2019.
 * You are given an array of integers in an arbitrary order. Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.

 We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

 Example:

 [13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.

 [13, 4, 1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.

 */
public class NonDecreaseArraySingMod {
    private boolean solution(int[] nums){
        int modCount = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]>nums[i+1]){
                if(modCount>0){
                    return false;
                }
                nums[i] = prev;
                modCount++;
            }else{
                prev = nums[i];
            }
        }
        return modCount<2;
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{13,4,1};
        System.out.println(new NonDecreaseArraySingMod().solution(inputs));
    }
}
