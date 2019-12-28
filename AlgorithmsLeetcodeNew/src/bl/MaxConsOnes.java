package bl;

/**
 * Created by Akshay Hegde on 10/12/2019.
 * 1004. Max Consecutive Ones III
 Medium

 381

 7

 Favorite

 Share
 Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

 Return the length of the longest (contiguous) subarray that contains only 1s.



 Example 1:

 Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 Output: 6
 Explanation:
 [1,1,1,0,0,1,1,1,1,1,1]
 Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 Example 2:

 Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 Output: 10
 Explanation:
 [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.


 Note:

 1 <= A.length <= 20000
 0 <= K <= A.length
 A[i] is 0 or 1

 */
public class MaxConsOnes {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int max = 0;
        for (int i = 0; i < n&&max<n-i; i++) {
            int count =0;
            int flip =0;
            for (int j = i; j < n&&flip<=K; j++) {
                if(A[j]!=1){
                    flip++;
                    if(flip>K){
                        break;
                    }
                }
                count++;
                max = Math.max(count,max);
            }
        }
        return max;
    }

    private int slidingWindow(int[] A,int K){
       int max =0;
       int i=0;
       int j=0;
       int k = K;
       while (i<A.length&&j<A.length){
           if(A[j]==1){
               j++;
               max = Math.max(j-i,max);
           }
           else{
               if(k<=0){
                   if(A[i]==0) {
                       k++;
                   }
                   i++;
               }else{
                   k--;
                   j++;
                   max = Math.max(j-i,max);
               }
           }
       }
       return max;
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{0,0,0,1,1,1,0,0,1,0,0,1,0,1};
        int k=2;
        System.out.println(new MaxConsOnes().slidingWindow(inputs,k));
    }
}