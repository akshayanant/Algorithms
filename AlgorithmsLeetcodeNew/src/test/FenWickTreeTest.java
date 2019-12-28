package test;

import bl.FenWickTree;
import org.junit.Before;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by Akshay Hegde on 12/27/2019.
 */
public class FenWickTreeTest {
    private int[] nums;
    private FenWickTree fenWickTree;

    @Before
    public void init(){
        nums = new int[]{4,-1,3,-9,8,19,-2,3,8,-7,0,10,-8};
        fenWickTree = new FenWickTree(nums);
    }

    @Test
    public void testGetPrefixSum(){
        assertSum();
        fenWickTree.updateNum(3,3);
        assertSum();
        fenWickTree.updateNum(2,-3);
        assertSum();
        fenWickTree.updateNum(10,0);
        assertSum();
        fenWickTree.updateNum(0,-7);
        assertSum();
        fenWickTree.updateNum(4,8);
        assertSum();
        fenWickTree.updateNum(12,14);
        assertSum();
        fenWickTree.updateNum(10,-1);
        assertSum();
        fenWickTree.updateNum(1,-3);
        assertSum();
        fenWickTree.updateNum(7,-2);
        assertSum();
        fenWickTree.updateNum(11,10);
        assertSum();
    }

    private void assertSum(){
        int sum =0;
        try {
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                assert sum == fenWickTree.getPrefixSum(i);
            }
            System.out.println("Test Passed!");
        }
        catch (Exception e){
            System.out.println("Test Failed");
            throw e;
        }
    }

}
