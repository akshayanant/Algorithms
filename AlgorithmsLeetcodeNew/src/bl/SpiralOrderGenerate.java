package bl;

import java.util.Arrays;

/**
 * Created by Akshay Hegde on 5/17/2019.
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 Example:

 Input: 3
 Output:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 *
 *
 */
public class SpiralOrderGenerate {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        spiralOrder(spiral,n);
        return spiral;
    }

    private void spiralOrder(int[][] matrix, int n) {
        int start =1;
        int end = (n*n)+1;
        int layer =0;
        while(start<end){
            start = traverseLayer(matrix,layer,start,end);
            layer++;
        }
    }

    private int traverseLayer(int[][] matrix,int layer,int start,int end){
        int i=layer,j;
        for ( j = layer; j < matrix[0].length - layer; j++) {
            matrix[i][j] = start++;
        }
        if(start==end){
            return start;
        }
        j--;
        i++;
        for ( ; i <matrix.length-layer ; i++) {
            matrix[i][j] = start++;
        }
        if(start==end){
            return start;
        }
        i--;
        j--;
        for ( ; j>layer-1 ; j--) {
            matrix[i][j] = start++;
        }
        if(start==end){
            return start;
        }
        j++;
        i--;
        for ( ; i >layer ; i--) {
            matrix[i][j] = start++;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralOrderGenerate().generateMatrix(3)));
    }

}
