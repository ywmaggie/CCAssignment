import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    This is a very naive implementation. We simply construct an array to contain all nodes in the tree.
    We get a random index and choose that from the array.
 */

public class Solution11 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class randomTree{
        TreeNode root;
        ArrayList<TreeNode> nodeArray;

        randomTree(){root = null;}

        public int getRandom(){
            buildArray(nodeArray, root);
            Random r = new Random();
            return nodeArray.get(r.nextInt(nodeArray.size())).val;
        }

        public void buildArray(ArrayList<TreeNode> nodeArray, TreeNode root){
            if(root == null)
                return;
            buildArray(nodeArray, root.left);
            nodeArray.add(root);
            buildArray(nodeArray, root.right);
        }
    }
}
