import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    The whole idea comes after I read all hints in the book. That is, we treat each path from root to leaf as
    an array, and we want to find the subarray with sum equal the target.
    First, we tried to create an arraylist that contains all paths in the tree.
    Then, we find the number of possibilities to add to sum using a hashmap, as mentioned in the book.
 */
    
public class Solution12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathWithSum(TreeNode root, int sum){
        ArrayList<ArrayList<TreeNode>> treepath = new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();
        path.add(root);
        treepath.add(path);
        boolean update = true;
        while(update){
            update = false;
            for(ArrayList<TreeNode> p: treepath){
                TreeNode last = p.get(p.size()-1);
                if(last.left != null){
                    ArrayList<TreeNode> l = new ArrayList<>(p);
                    l.add(last.left);
                    treepath.add(l);
                }
                if(last.right != null){
                    ArrayList<TreeNode> r = new ArrayList<>(p);
                    r.add(last.left);
                    treepath.add(r);
                }
                if(last.left != null || last.right != null){
                    update = true;
                    treepath.remove(p);
                }

            }
        }

        int result = 0;
        for (ArrayList<TreeNode> p:treepath)
            result += findSum(p, sum);
        return result;


    }

    public int findSum(ArrayList<TreeNode> a, int t){
        int[] sum = new int[a.size()];
        HashMap<Integer, Integer> pos = new HashMap<>();
        int result = 0;
        sum[0] = a.get(0).val;
        pos.put(sum[0],0);
        for(int i = 1; i != a.size(); i++){
            sum[i] = sum[0] + a.get(i).val;
            pos.put(sum[i],i);
        }
        for(int i = 0; i != a.size(); i ++){
            if(pos.get(t-sum[i]) != null){
                if(pos.get(t-sum[i])<i)
                    result ++;
            }
        }
        return result;

    }
}
