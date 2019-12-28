package bl;

/**
 * Created by Akshay Hegde on 6/1/2019.
 */
public class FixedPoint {

    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if(A[i]==i){
                return i;
            }
        }
        return -1;
    }
}
