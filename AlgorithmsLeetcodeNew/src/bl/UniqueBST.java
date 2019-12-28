package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 5/27/2019.
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

 Example:

 Input: 3
 Output:
 [
 [1,null,3,2],
 [3,2,null,1],
 [3,1,null,null,2],
 [2,1,3],
 [1,null,2,null,3]
 ]
 Explanation:
 The above output corresponds to the 5 unique BST's shown below:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class UniqueBST {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        recusrsion(nums,1,res,null);
        return res;

    }
    private void recusrsion(int[] nums,int l,List<TreeNode> res,TreeNode node){
        if(l>nums.length){
            res.add(node);
            return;
        }
        for (int i = l; i <= nums.length; i++) {
            TreeNode newNode = new TreeNode(i);
            if(node==null){
                node = newNode;
            }
            else{
                insertNode(node,newNode);
            }
            swap(nums,i,l);
            recusrsion(nums,l+1,res,node);
            swap(nums,i,l);
        }

    }
    private void swap(int[] a,int i, int j){
        int temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

    private void insertNode(TreeNode root, TreeNode node){
        TreeNode tracker = root;
        while (true){
            TreeNode prev = tracker;
            if(node.val<tracker.val){
                tracker = tracker.left;
                if(tracker == null){
                    prev.left = node;
                    return;
                }
            }
            else{
                tracker = tracker.right;
                if(tracker==null){
                    prev.right = node;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBST().generateTrees(3));
    }
}
