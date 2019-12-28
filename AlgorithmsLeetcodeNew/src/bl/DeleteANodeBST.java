package bl;

import java.util.LinkedList;

/**
 * Created by Akshay Hegde on 10/21/2019.
 * 450. Delete Node in a BST
 Medium

 1131

 65

 Favorite

 Share
 Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:

 Search for a node to remove.
 If the node is found, delete the node.
 Note: Time complexity should be O(height of tree).

 Example:

 root = [5,3,6,2,4,null,7]
 key = 3

 5
 / \
 3   6
 / \   \
 2   4   7

 Given key to delete is 3. So we find the node with value 3 and delete it.

 One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

 5
 / \
 4   6
 /     \
 2       7

 Another valid answer is [5,2,6,null,4,null,7].

 5
 / \
 2   6
 \   \
 4   7

 */
public class DeleteANodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        while (true){
            if(node==null){
                return root;
            }
            if(node.val==key){
                if(node.equals(root)) {
                    node = removeRoot(node);
                    return node;
                }
            }
            if(node.left!=null&&node.left.val==key){
                node.left = removeRoot(node.left);
                return root;
            }
            if(node.right!=null&&node.right.val==key){
                node.right = removeRoot(node.right);
                return root;
            }
            if(node.val<key){
                node = node.right;
                continue;
            }
            node = node.left;
        }
    }

    private TreeNode removeRoot(TreeNode root){
        if(root.right==null) {
            return root.left;
        }
        if(root.left==null){
            return root.right;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            rec(root.right,node.val);
        }
        return root.right;
    }

    private void rec(TreeNode root, int val){
        if(root.val>=val){
            if(root.left==null){
                root.left = new TreeNode(val);
                return;
            }
            rec(root.left,val);
            return;
        }
        if(root.right==null){
            root.right=new TreeNode(val);
            return;
        }
        rec(root.right,val);
    }
}
