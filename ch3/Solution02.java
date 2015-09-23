import java.util.Stack;

/**
 * Created by zhangyuwei on 9/21/15.
 */




// We add an addition parameter in each Node of stack to record the MIN of the cuurent stack
// when we push a new node on to the stack, we can compare the value of current node with the MIN value
// in the previous stack. When we pop a node, we do it in the same way as a normal stack

public class Solution02 {
    public class Node {
        public int val;
        public int min;
        public Node(int v, int m){
            val = v;
            min = m;
        }
    }

    // I get the idea of inheritance (which is extend of a class from the solution of book)
    public class myStack extends Stack<Node> {
        public void push(int v){
            if (this.isEmpty()){
                Node n = new Node(v, v);
                super.push(n);
            }
            else{
                int m = this.min();
                Node n = new Node(v, m);
                super.push(n);
            }
        }

        public int min(){
            if (this.isEmpty())
                return Integer.MAX_VALUE;
            else
                return this.peek().min;
        }
    }
}