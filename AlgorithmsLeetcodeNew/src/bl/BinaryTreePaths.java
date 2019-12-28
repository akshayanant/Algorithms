package bl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/4/2019.
 Given a binary tree, return all root-to-leaf paths.

 Note: A leaf is a node with no children.

 Example:

 Input:

 1
 /   \
 2     3
 \
 5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3

 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        String path = ""+root.val;
        if(root.left==null&&root.right==null){
            res.add(path);
            return res;
        }
        if(root.left!=null){
            recursion(root.left,res,path);
        }
        if(root.right!=null){
            recursion(root.right,res,path);
        }
        return res;
    }

    private void recursion(TreeNode root, List<String> res,String path){
        if(root.left==null&&root.right==null){
            res.add(path+"->"+root.val);
        }
        if(root.left!=null){
            recursion(root.left,res,path+"->"+root.val);
        }
        if(root.right!=null){
            recursion(root.right,res,path+"->"+root.val);
        }
    }

}
