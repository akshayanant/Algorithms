package bl;

import java.util.*;

/**
 * Created by Akshay Hegde on 5/30/2019.
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Example 1:

 Input: [1,3,null,null,2]

 1
 /
 3
 \
 2

 Output: [3,1,null,null,2]

 3
 /
 1
 \
 2
 Example 2:

 Input: [3,1,4,null,null,2]

 3
 / \
 1   4
 /
 2

 Output: [2,1,4,null,null,3]

 2
 / \
 1   4
 /
 3
 Follow up:

 A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?

 */
public class RecoverBST {
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        inOrderSwap(root);
//        List<Integer> flat = inOrder(root);
//        Collections.sort(flat);
//        setInOrder(root,flat);

    }

    private List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.empty()){
                    return res;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
    }

    private void setInOrder(TreeNode root,List<Integer> flat){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int i =0;
        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.empty()){
                    return;
                }
                root = stack.pop();
                root.val = flat.get(i++);
                root = root.right;
            }
        }
    }

    private void inOrderSwap(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = null;
        TreeNode node = null;
        boolean firstFound = false;
        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.empty()){
                    int temp = prev.val;
                    prev.val = cur.val;
                    cur.val = temp;
                    return;
                }
                root = stack.pop();
                if(node==null){
                    node = root;
                }
                else{
                    if(node.val>root.val){
                        if(!firstFound){
                            firstFound = true;
                            prev = node;
                            cur = root;
                        }
                        else{
                            int temp = prev.val;
                            prev.val = root.val;
                            root.val = temp;
                            return;
                        }
                    }
                        node = root;
                }
                root = root.right;
            }
        }
    }
}
