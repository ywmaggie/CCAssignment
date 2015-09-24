import java.util.ArrayList;

/**
 * Created by zhangyuwei on 9/23/15.
 */
/*
    We do DFS on the graph, beginning at Node a, if during the traversal we find b, that means a can reach b.
    So we begin from both a and b, to check if it can reach the other node.
 */
public class Solution01 {
    class GraphNode {
        int label;
        boolean visited;
        ArrayList<GraphNode> neighbors;
        GraphNode(int x) { label = x; neighbors = new ArrayList<GraphNode>(); visited = false;}
    };

    public boolean findRoute(GraphNode a, GraphNode b){
        if(route(a,b) || route(b,a))
            return true;
        else
            return false;
    }

    public boolean route(GraphNode a, GraphNode b){
        a.visited = true;
        for(GraphNode n: a.neighbors){
            if(n == b){
                return true;
            }
            if(n.visited == false){
                if(route(n,b) == true)
                    return true;
            }
        }
        return false;
    }
}
