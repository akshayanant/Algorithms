package bl;

import java.util.Stack;

/**
 * Created by Akshay Hegde on 7/19/2019.
 */
class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}

