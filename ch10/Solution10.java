/**
 * Created by zhangyuwei on 9/30/15.
 */

/*
    From the hint, we could build a modified binary search tree.
    We can record the number of values on the left subtree of the current node. Later, when we want to get the total
    number of values smaller than this node, we could go through from the root. If the target value is larger than
    root, we add the number recorded in root to the result. We keep doing this, until we find the target number.
 */
public class Solution10 {
    public static class TreeNode{
        int value;
        int numberOfLeft;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            value = x;
            numberOfLeft = 0;
            left = null;
            right = null;
        }
    }

    public static class binarySearchTree{
        TreeNode root;
        binarySearchTree(TreeNode r){
            root = r;
        }
        void track(int x){
            TreeNode cur = root;
            while(true){
                if(x == cur.value){
                    break;
                }
                else if(x < cur.value){
                    cur.numberOfLeft ++;
                    if(cur.left == null){
                        TreeNode t = new TreeNode(x);
                        cur.left = t;
                        break;
                    }
                    else{
                        cur = cur.left;
                    }
                }
                else{
                    if(cur.right == null){
                        TreeNode t = new TreeNode(x);
                        cur.right = t;
                        break;
                    }
                    else{
                        cur = cur.right;
                    }
                }
            }
        }

        int getRankOfNumber(int x){
            TreeNode cur = root;
            int result = 0;
            while(cur != null){
                if(x == cur.value){
                    return result + cur.numberOfLeft;
                }
                else if(x > cur.value){
                    result += cur.numberOfLeft;
                    cur = cur.right;
                }
                else{
                    cur = cur.left;
                }
            }
            return result;
        }
    }
}
