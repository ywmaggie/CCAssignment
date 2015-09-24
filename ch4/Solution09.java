
import java.util.ArrayList;

/**
 * Created by zhangyuwei on 9/23/15.
 */

/*
    This is like a topological sort, we pick the root, and than randomly pick the left or right. The sequence in the
    left subtree and the sequence of the right subtree can be mixed in any way, as long as the order in itself doesn't
    change.
    So we define combine to combine all possibilities of left sequences and right sequences.
    mix to get all possibilities of the combination of one single left sequence and one single right sequence.
 */

public class Solution09 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> BSTSequences(TreeNode root){
        ArrayList<ArrayList<Integer>> left, right,result,temp;
        left = BSTSequences(root.left);
        right = BSTSequences(root.right);
        temp = combine(left, right);
        result = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> t:temp){
            t.add(0,root.val);
            result.add(t);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> combine(ArrayList<ArrayList<Integer>> left, ArrayList<ArrayList<Integer>> right){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (ArrayList<Integer> l: left){
            for(ArrayList<Integer> r:right){
                result.addAll(mix(l, r));
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> mix(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a.size() == 0 && b.size() == 0)
            return result;
        if(a.size() == 0){
            result.add(b);
            return result;
        }
        if(b.size() == 0){
            result.add(a);
            return result;
        }
        int begin1 = a.get(0);
        ArrayList<Integer> asub = new ArrayList<Integer>(a.subList(1,a.size()));
        ArrayList<ArrayList<Integer>> follow1 = mix(asub, b);
        for(ArrayList<Integer> follow:follow1){
            follow.add(0,begin1);
            result.add(follow);
        }

        int begin2 = a.get(0);
        ArrayList<Integer> bsub = new ArrayList<Integer>(b.subList(1,a.size()));
        ArrayList<ArrayList<Integer>> follow2 = mix(a, bsub);
        for(ArrayList<Integer> follow:follow2){
            follow.add(0,begin2);
            result.add(follow);
        }
        return result;
    }
}
