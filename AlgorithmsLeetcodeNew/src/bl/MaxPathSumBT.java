package bl;

/**
 * Created by Akshay Hegde on 6/6/2019.
 *
 * Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:

 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6
 Example 2:

 Input: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
 /  \
 15   7
 */
public class MaxPathSumBT {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = root.val;
        recursion(root,max);
        return max[0];
    }

    private int recursion(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }
        int left = recursion(root.left,max);
        int right = recursion(root.right,max);
        int pathSumThrough = Math.max(left+root.val,Math.max(right+root.val,root.val));
        int sumAsTop = Math.max(left+right+root.val,pathSumThrough);
        if(sumAsTop>max[0]){
            max[0] = sumAsTop;
        }
        return pathSumThrough;
    }
}
