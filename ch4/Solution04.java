/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    We check if the difference of height of the left subtree and right subtree is larger than 1,
    or if the subtrees are already unbalanced.
    If a subtree if unbalanced, we return -1, which cannot be the actual height of a tree, so we can detect
    that.
 */
public class Solution04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return balance(root) != -1;
    }

    public int balance(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = balance(root.left);
        int rightHeight = balance(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) +1;
    }
}
