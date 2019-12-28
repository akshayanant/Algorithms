package bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Akshay Hegde on 9/5/2019.
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

 Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

 (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)



 Example 1:



 Input: [0,1,2,3,4,3,4]
 Output: "dba"
 Example 2:



 Input: [25,1,3,1,3,0,2]
 Output: "adz"
 Example 3:



 Input: [2,2,1,null,1,0,null,0]
 Output: "abc"


 Note:

 The number of nodes in the given tree will be between 1 and 8500.
 Each node in the tree will have a value between 0 and 25.

 */
public class SmallestStringFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        if(root==null){
            return "";
        }
        List<String> res = new ArrayList<>();
        String str = (char)(root.val+97)+"";
        if(root.left==null&&root.right==null){
            return str;
        }
        if(root.left==null){
            rootToLeaf(root.right,res,str);
        }
        else if(root.right==null){
            rootToLeaf(root.left,res,str);
        }
        else{
            rootToLeaf(root.left,res,str);
            rootToLeaf(root.right,res,str);
        }
        Collections.sort(res);
        return res.get(0);
    }

    private void rootToLeaf(TreeNode root,List<String> res,String str){
        char ch = (char) (root.val+97);
        str = ch+str;
        if(root.left==null&&root.right==null){
            res.add(str);
            return;
        }
        if(root.left==null){
            rootToLeaf(root.right,res,str);
        }
        else if(root.right==null){
            rootToLeaf(root.left,res,str);
        }
        else {
            rootToLeaf(root.left, res, str);
            rootToLeaf(root.right, res, str);
        }
    }
}
