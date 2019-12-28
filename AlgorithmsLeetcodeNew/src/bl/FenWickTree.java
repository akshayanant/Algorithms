package bl;

/**
 * Created by Akshay Hegde on 12/27/2019.
 */
public class FenWickTree {
    private int[] nums;
    private int[] fen;
    private int size;

    public FenWickTree(int[] nums){
        this.nums = nums;
        size = nums.length+1;
        fen = new int[size];
        for (int i = 0; i < nums.length; i++) {
            update(i,nums[i]);
        }
    }

    public void updateNum(int index,int newNum){
        int delta = newNum - nums[index];
        update(index,delta);
    }

    public int getPrefixSum(int index){
        return getSum(index);
    }

    private void update(int index, int delta){
        int next = index+1;
        while(next<size) {
            fen[next] += delta;
            next = getNext(next);
        }
    }

    private int getSum(int index){
        int sum =0;
        int parent = index+1;
        while(parent>0){
            sum+=fen[parent];
            parent = (parent&(parent-1));
        }
        return sum;
    }

    private int getNext(int index){
        int twosComplement = (~index)+1;
        int and = twosComplement&index;
        return index+and;
    }
}
