package bl;

/**
 * Created by Akshay Hegde on 6/2/2019.
 *
 * Given a binary tree, flatten it to a linked list in-place.

 For example, given the following tree:

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6


 */
public class FlattenBTToList {
    public void flatten(TreeNode root) {
        convertToList(root);
    }

    private TreeNode convertToList(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.left==null){
            if(node.right==null){
                return node;
            }
            node.right= convertToList(node.right);
            return node;
        }
        TreeNode next  = node.right;
        node.right = convertToList(node.left);
        node.left = null;
        TreeNode temp = node;
        while (temp.right!=null){
            temp = temp.right;
        }
        temp.right = convertToList(next);
        return node;
    }

}
