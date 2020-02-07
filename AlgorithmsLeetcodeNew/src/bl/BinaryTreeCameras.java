package bl;

/**
 * Created by Akshay Hegde on 2/6/2020.
 * 968. Binary Tree Cameras
 Hard

 490

 12

 Add to List

 Share
 Given a binary tree, we install cameras on the nodes of the tree.

 Each camera at a node can monitor its parent, itself, and its immediate children.

 Calculate the minimum number of cameras needed to monitor all nodes of the tree.



 Example 1:


 Input: [0,0,null,0,0]
 Output: 1
 Explanation: One camera is enough to monitor all nodes if placed as shown.
 Example 2:


 Input: [0,0,null,0,null,0,null,null,0]
 Output: 2
 Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

 Note:

 The number of nodes in the given tree will be in the range [1, 1000].
 Every node has value 0.

 */
public class BinaryTreeCameras {
    public int minCameraCover(TreeNode root) {
        return rec(root,false,false);
    }

    private int rec(TreeNode root, boolean prev,boolean comp){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            if(prev){
                return 0;
            }
            return 1;
        }
        int res = 1+rec(root.left,true,false)+rec(root.right,true,false);
        if(comp){
            return res;
        }

        if(root.left!=null){
            res = Math.min(res,rec(root.left,false,!prev)+rec(root.right,false,false));
        }
        if(root.right!=null){
            res = Math.min(res,rec(root.left,false,false)+rec(root.right,false,!prev));
        }
        return res;
    }
}
