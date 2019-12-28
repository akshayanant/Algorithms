package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/4/2019.
 * You need to find the largest value in each row of a binary tree.

 Example:
 Input:

 1
 / \
 3   2
 / \   \
 5   3   9

 Output: [1, 3, 9]

 */
public class LargestValueEachRowBT {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode deque = queue.remove(0);
            if (deque == null) {
                res.add(max);
                max = Integer.MIN_VALUE;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (deque.val > max) {
                    max = deque.val;
                }
                if (deque.left != null) {
                    queue.add(deque.left);
                }
                if (deque.right != null) {
                    queue.add(deque.right);
                }
            }
        }
        return res;
    }
}
