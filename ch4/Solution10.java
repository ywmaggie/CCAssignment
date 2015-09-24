/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    We do preorder traversal on the big tree. Each time we find a Node identical to the root of small tree,
    we check the whole subtree to see if it is identical to the small tree.
 */
public class Solution10 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean preorder(TreeNode root, TreeNode small) {
        if(root == null)
            return false;
        if (preorder(root.left, small))
            return true;
        boolean attempt = identical(root, small);
        if (preorder(root.right, small))
            return true;
        return attempt;
    }

    public boolean identical(TreeNode big, TreeNode small){
        if(big == null && small == null)
            return true;
        if(big == null || small == null)
            return false;
        if(big.val != small.val)
            return false;
        return identical(big.left, small.left) && identical(big.right, small.right);
    }
}
