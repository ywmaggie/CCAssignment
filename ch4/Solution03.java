import java.util.ArrayList;

/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    We use BFS in this problem. We look at each node at the last level, when there is a left node or right node,
    we add it to the current level. After that, we set the current level to the past level.
    Until there is no element in the current level, we have gone through the whole tree and created depth list
    for all levels.
 */
public class Solution03 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public class Node{
        TreeNode val;
        Node next;
        Node(TreeNode x){val = x;}
    }

    public ArrayList<Node> treeToList(TreeNode root){
        ArrayList<Node> depth = new ArrayList<>();
        if (root == null)
            return depth;
        Node n = new Node(root);
        n.next = null;
        Node lastLevel = new Node(null);
        lastLevel.next = n;
        while (lastLevel.next != null){
            depth.add(lastLevel.next);
            Node curLevel = new Node(null);
            Node cur = curLevel;
            Node trav = lastLevel.next;
            while (trav != null){
                if(trav.val.left != null) {
                    n = new Node(trav.val.left);
                    n.next = null;
                    cur.next = n;
                    cur = n;
                }
                if(trav.val.right != null) {
                    n = new Node(trav.val.right);
                    n.next = null;
                    cur.next = n;
                    cur = n;
                }
            }
            lastLevel = curLevel;
        }
        return depth;
    }
}
