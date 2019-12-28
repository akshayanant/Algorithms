package bl;

/**
 * Created by Akshay Hegde on 9/7/2019.
 * 5182. Maximum Subarray Sum with One Deletion
 User Accepted:84
 User Tried:421
 Total Accepted:85
 Total Submissions:623
 Difficulty:Medium
 Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

 Note that the subarray needs to be non-empty after deleting one element.



 Example 1:

 Input: arr = [1,-2,0,3]
 Output: 4
 Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 Example 2:

 Input: arr = [1,-2,-2,3]
 Output: 3
 Explanation: We just choose [3] and it's the maximum sum.
 Example 3:

 Input: arr = [-1,-1,-1,-1]
 Output: -1
 Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.




 */
public class MaxSubArraySumOneDel {
    public int maximumSum(int[] arr) {
        if(arr.length==0){
            return 0;
        }
        int[] forward = new int[arr.length];
        int[] back = new int[arr.length];
        int sum = arr[0];
        forward[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i],sum+arr[i]);
            forward[i] = sum;
        }
        sum = arr[arr.length-1];
        int max = sum;
        for (int i = arr.length-2; i >-1; i--) {
            sum = Math.max(arr[i],sum+arr[i]);
            max = Math.max(max,sum);
            back[i] = sum;
        }
        int res = max;
        for (int i = 1; i < arr.length - 1; i++) {
            res = Math.max(res,forward[i-1]+back[i+1]);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new MaxSubArraySumOneDel().maximumSum(new int[]{-7,6,1,2,1,4,-1}));
        System.out.println(new MaxSubArraySumOneDel().maximumSum(new int[]{11,-10,-11,8,7,-6,9,4,11,6,5,0}));
    }
}
