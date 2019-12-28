package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 6/1/2019.
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 inorder = [9,3,15,20,7]
 postorder = [9,15,7,20,3]
 Return the following binary tree:

 3
 / \
 9  20
 /  \
 15   7
 */

public class ConstructBTFromInPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> postIndex = new ArrayList<>(1);
        postIndex.add(postorder.length-1);
        return buildRec(postorder,inorder,0,postorder.length-1,postIndex);
    }

    private TreeNode buildRec(int[] postOrder, int[] inOrder, int start, int end,
                              List<Integer> postIndex){

        if(start>end||postIndex.get(0)>=postOrder.length){
            return null;
        }
        TreeNode node = new TreeNode(postOrder[postIndex.get(0)]);
        int post = postIndex.get(0);
        post--;
        postIndex.set(0,post);
        int rootIndex = search(inOrder,node.val,start);
        node.right = buildRec(postOrder,inOrder,rootIndex+1,end,postIndex);
        node.left = buildRec(postOrder,inOrder,start,rootIndex-1,postIndex);
        return node;
    }


    private int search(int[] inOrder, int num, int start) {
        while (start < inOrder.length && inOrder[start] != num) {
            start++;
        }
        return start;

    }



}
