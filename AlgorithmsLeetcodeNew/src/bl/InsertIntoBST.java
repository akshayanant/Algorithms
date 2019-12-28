package bl;

/**
 * Created by Akshay Hegde on 10/21/2019.
 * 701. Insert into a Binary Search Tree
 Medium

 472

 53

 Favorite

 Share
 Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

 Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 For example,

 Given the tree:
 4
 / \
 2   7
 / \
 1   3
 And the value to insert: 5
 You can return this binary search tree:

 4
 /   \
 2     7
 / \   /
 1   3 5
 This tree is also valid:

 5
 /   \
 2     7
 / \
 1   3
 \
 4

 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        rec(root,val);
        return root;
    }

    private void rec(TreeNode root, int val){
        if(root.val>val){
            if(root.left==null){
                root.left = new TreeNode(val);
                return;
            }
            rec(root.left,val);
            return;
        }
        //New Value doesn't exist in original BST (mentioned in the question)
        if(root.right==null){
            root.right=new TreeNode(val);
            return;
        }
        rec(root.right,val);
    }
}
