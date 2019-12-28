package bl;

/**
 * Created by Akshay Hegde on 5/31/2019.
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3


 But the following [1,2,2,null,3,null,3] is not:

 1
 / \
 2   2
 \   \
 3    3


 Note:
 Bonus points if you could solve it both recursively and iteratively.

 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root,root);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
