/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    As all numbers in the left subtree is smaller than the value of root and all numbers in right subtree is larger,
    we can set a boundary for each node to check if this node is valid or not.
 */

public class Solution05 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root){
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, int boundl, int boundr){
        if(root == null)
            return true;
        return root.val < boundr && root.val > boundl && isValid(root.left, boundl, root.val) && isValid(root.right, root.val, boundr);
    }
}
