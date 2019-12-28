package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Akshay Hegde on 5/29/2019.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.empty()) {
                    return true;
                }
                root = stack.pop();
                if (res.isEmpty() || root.val > res.get(res.size() - 1)) {
                    res.add(root.val);
                } else {
                    return false;
                }
                res.add(root.val);
                root = root.right;
            }
        }
    }
}