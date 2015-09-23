import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhangyuwei on 9/22/15.
 */


// we keep track of the last stack, when we push a value onto the stack, we check if the last stack is full
// if so, we create a new stack and push the value.
// when we pop a value, we check if there is only one element in the last stack, if so, we pop the element and
// remove the last stack.

public class Solution03 {
    public class SetOfStacks{
        int stackNum;
        int size;
        ArrayList<Stack> stack;
        Stack<Integer> laststack;

        public SetOfStacks(int limit){
            stackNum = 1;
            size = limit;
            stack= new ArrayList<Stack>();
            laststack = new Stack<Integer>();
        }

        public void push(int v){
            if(laststack.size() == size){
                stackNum ++;
                laststack = new Stack<Integer>();
                stack.add(laststack);
            }
            laststack.push(v);
        }

        public int pop(){
            int val;
            if(laststack.size() == 1){
                val = laststack.pop();
                if(stackNum != 1){
                    stackNum --;
                    stack.remove(laststack);
                }
                laststack = stack.get(stack.size()-1);
            }
            else{
                val = laststack.pop();
            }
            return val;
        }

    }
}
