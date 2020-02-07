package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 2/6/2020.
 * 670. Maximum Swap
 Medium

 731

 52

 Add to List

 Share
 Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

 Example 1:
 Input: 2736
 Output: 7236
 Explanation: Swap the number 2 and the number 7.
 Example 2:
 Input: 9973
 Output: 9973
 Explanation: No swap.
 Note:
 The given number is in the range [0, 108]

 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        int[] original = new int[9];
        int[] lastIndex = new int[10];
        Arrays.fill(original,Integer.MAX_VALUE);
        Arrays.fill(lastIndex,-1);
        int temp = num;
        int i = 8;
        while(temp>0){
            int rem = temp%10;
            if(lastIndex[rem]==-1){
                lastIndex[rem] = i;
            }
            original[i--] = rem;
            temp/=10;
        }
        int[] copy = new int[9];
        System.arraycopy(original,0,copy,0,9);
        Arrays.sort(copy);
        i = 0;
        int j = 8;
        while(i<9){
            if(copy[j]!=original[i]){
                int t = original[i];
                original[i] = copy[j];
                original[lastIndex[copy[j]]] = t;
                break;
            }
            i++;
            j--;
        }
        i = 0;
        while (i<9&&original[i] == Integer.MAX_VALUE) {
            i++;
        }
        int res = 0;
        while(i<9){
            res = res*10+original[i++];
        }
        return res;
    }
}
