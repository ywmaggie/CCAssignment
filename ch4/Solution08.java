/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    We want to know if p and q are in the subtrees of root and decide if root is the common ancestor, but we don't want
     to operate a search function on each node, that's a waste of time.
    Instead, let the function itself return common ancestor if it has both p and q, or p if the root is p, or q if the root
    is q, and null if none of them exists.

 */
public class Solution08 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if ((left == p && right == q)||(left == q && right == p))
            return root;
        if(left == null && right == null)
            return null;
        if(left != null)
            return left;
        else
            return right;
    }
}
