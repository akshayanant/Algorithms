package bl;

/**
 * Created by Akshay Hegde on 10/22/2019.
 */
public class CheckBTBST {

    private boolean chaeck(TreeNode root){
        return rec(root,null, null);
    }

    private boolean rec(TreeNode root, Integer min, Integer max){
        if(root==null){
            return true;
        }
        if((min!=null&&root.val<=min)||(max!=null&&root.val>max)){
            return false;
        }
        boolean left = rec(root.left,min,root.val);
        if(!left){
            return false;
        }
        boolean right = rec(root.right,root.val,max);
        if(!right){
            return false;
        }
        return true;
    }
}
