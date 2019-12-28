package bl;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Akshay Hegde on 10/9/2019.
 * 378. Kth Smallest Element in a Sorted Matrix
 Medium

 1485

 92

 Favorite

 Share
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.

 */
public class KThSmallestSortedMat {
    class MatElement{
        int val;
        int i,j;

        public MatElement(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<MatElement> queue = new PriorityQueue<>(new Comparator<MatElement>() {
            @Override
            public int compare(MatElement o1, MatElement o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new MatElement(matrix[i][0],i,0));
        }
        int index =0;
        MatElement element = queue.peek();
        while (index<k){
            element = queue.poll();
            index++;
            if(element.j+1==matrix[0].length){
                continue;
            }
            queue.add(new MatElement(matrix[element.i][element.j+1],element.i,element.j+1));
        }
        return element.val;
    }
}
