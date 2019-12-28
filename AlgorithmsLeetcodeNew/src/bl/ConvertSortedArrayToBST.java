package bl;

/**
 * Created by Akshay Hegde on 6/1/2019.
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int nums[], int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end+1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.right = construct(nums, mid+1, end);
        node.left = construct(nums,start,mid-1);
        return node;
    }
}
