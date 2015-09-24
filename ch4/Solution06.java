/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    If the node has a right child, we return the left most child of that right child.
    If it doesn't have a right child, we look for the parent, until we find the this node is in the left tree of
     a root, then we return the root. If it is the right most node in a tree, the root we find is null,
     and that is what we want.
 */

public class Solution06 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { val = x; }
    }

    public TreeNode nextNode(TreeNode n){
        TreeNode cur;
        if(n.right != null){
            cur = n.right;
            while(cur.left != null)
                cur = cur.left;
            return cur;
        }
        else {
            cur = n;
            while (cur.parent != null && cur.parent.right == n) {
                cur = cur.parent;
            }
            return cur.parent;
        }
    }
}
