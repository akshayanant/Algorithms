package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/31/2019.
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]
 Return the following binary tree:

 3
 / \
 9  20
 /  \
 15   7

 */
public class ConstructBTFromPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preIndex = new ArrayList<>(1);
        preIndex.add(0);
        return buildRec(preorder,inorder,0,preorder.length-1,preIndex);
    }

    private TreeNode buildRec(int[] preOrder, int[] inOrder, int start, int end,List<Integer> preIndex){

        if(start>end||preIndex.get(0)>=preOrder.length){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preIndex.get(0)]);
        int pre = preIndex.get(0);
        pre++;
        preIndex.set(0,pre);
        int rootIndex = search(inOrder,node.val,start);
        node.left = buildRec(preOrder,inOrder,start,rootIndex-1,preIndex);
        node.right = buildRec(preOrder,inOrder,rootIndex+1,end,preIndex);
        return node;
    }


    private int search(int[] inOrder, int num, int start) {
        while (start < inOrder.length && inOrder[start] != num) {
            start++;
        }
        return start;

    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{-1};
        int[] inOrder = new int[]{-1};
        System.out.println(new ConstructBTFromPreInOrder().buildTree(preOrder,inOrder).val);
    }
}
