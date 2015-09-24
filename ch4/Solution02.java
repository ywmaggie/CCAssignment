/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    We recursively solve this problem. First we set the middle element in the array to be the root,
    then we recursively build the left subtree using the left side of the array, whose elements are
    all smaller than the middle element.

    We build the tree recursively until we get to the condition there is no element in an array, we set
    the subtree to null.
 */
public class Solution02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return sort(nums, 0, nums.length -1);
    }

    public TreeNode sort(int[] nums, int begin, int end){
        int mid = (begin + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = (mid - 1 >= begin) ? sort(nums, begin, mid -1) : null;
        root.right = (mid + 1 <= end) ? sort(nums, mid+1, end) : null;
        return root;
    }
}
