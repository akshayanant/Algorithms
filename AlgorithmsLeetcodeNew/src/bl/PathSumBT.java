package bl;

/**
 * Created by Akshay Hegde on 6/1/2019.
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 Note: A leaf is a node with no children.

 Example:

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 */
public class PathSumBT {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasPathSumRec(root, sum);
    }

    private boolean hasPathSumRec(TreeNode root, int sum) {
        if(root==null){
            return sum==0;
        }
        if(root.left==null){
            if(root.right!=null){
                return hasPathSumRec(root.right,sum-root.val);
            }
        }
        else{
            if(root.right==null){
                return hasPathSumRec(root.left,sum-root.val);
            }
        }
        return hasPathSumRec(root.left,sum-root.val)
                || hasPathSumRec(root.right,sum-root.val);
    }
}
