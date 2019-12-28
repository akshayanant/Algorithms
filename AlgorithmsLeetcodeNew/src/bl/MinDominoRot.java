package bl;

/**
 * Created by Akshay Hegde on 10/10/2019.
 * 1007. Minimum Domino Rotations For Equal Row
 Medium

 203

 92

 Favorite

 Share
 In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

 We may rotate the i-th domino, so that A[i] and B[i] swap values.

 Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

 If it cannot be done, return -1.



 Example 1:



 Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 Output: 2
 Explanation:
 The first figure represents the dominoes as given by A and B: before we do any rotations.
 If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 Example 2:

 Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 Output: -1
 Explanation:
 In this case, it is not possible to rotate the dominoes to make one row of values equal.


 Note:

 1 <= A[i], B[i] <= 6
 2 <= A.length == B.length <= 20000

 */
public class MinDominoRot {
    public int minDominoRotations(int[] A, int[] B) {
        int m=A.length;
        int count = 0;
        boolean top = true;
        boolean bot = true;
        for (int i = 1; i <m ; i++) {
            if(A[i]==A[i-1]&&B[i]==B[i-1]){
                continue;
            }
            if(A[i]==B[i-1]&&B[i]==A[i-1]){
                swap(A,B,i);
                count++;
                continue;
            }
            if(A[i]==A[i-1]){
                if(top) {
                    bot = false;
                    continue;
                }
                else{
                    return -1;
                }
            }
            if(B[i]==B[i-1]){
                if(bot) {
                    top = false;
                    continue;
                }
                else{
                    return -1;
                }
            }
            if(A[i-1]==B[i]){
                if(!top){
                    return -1;
                }
                count++;
                swap(A,B,i);
                bot = false;
                continue;
            }
            if(A[i]==B[i-1]){
                if(!bot){
                    return -1;
                }
                count++;
                swap(A,B,i);
                top = false;
                continue;
            }
            return -1;
        }
        return count;
    }

    private void swap(int[] A,int[] B,int i){
        int temp  = A[i];
        A[i] = B[i];
        B[i]= temp;
    }

    public static void main(String[] args) {
        System.out.println(new MinDominoRot().minDominoRotations(new int[]{2,1,2,4,2,2},
                new int[]{5,2,6,2,3,2}));
    }
}
