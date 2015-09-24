import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zhangyuwei on 9/23/15.
 */
/*
    This is a topological sort problem. We can either do it by constantly remove root in the graph, or do a DFS on
    the graph and record the time of visiting and leaving.
    This algorithm goes with the first one.
    Assume we already have the graph based on dependencies, here is a suedo code.
 */
public class Solution07 {
    public ArrayList<Integer> topo(ArrayList<Integer> projects, Graph G){
        ArrayList<Integer> indeg = new ArrayList<>();
        for(vlist:vertex){
            for(v:vlist){
                indeg.get(v) ++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(node: G){
            if (indeg(node) == 0){
                queue.add(node);
            }
        }
        ArrayList<Integer> topolist = new ArrayList<>();
        while(queue.size() != 0){
            v = queue.poll();
            topolist.add(v);
            for(neighbor:v){
                indeg.get(neighbor)--;
                if(indeg.get(neighbor) == 0){
                    queue.add(neighbor);
                }
            }
        }
        return topolist;
    }
}
