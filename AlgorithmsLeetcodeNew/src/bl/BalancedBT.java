package bl;

/**
 * Created by Akshay Hegde on 6/1/2019.
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example 1:

 Given the following tree [3,9,20,null,null,15,7]:

 3
 / \
 9  20
 /  \
 15   7
 Return true.

 Example 2:

 Given the following tree [1,2,2,3,3,null,null,4,4]:

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 Return false.
 */

public class BalancedBT {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (Math.abs(leftHeight - rightHeight) < 2 && isBalanced(root.left) && isBalanced(root.right));
    }

    private int height(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(height(node.left),height(node.right));
    }
}