import java.util.Stack;

/**
 * Created by zhangyuwei on 9/22/15.
 */

/*
    we have 2 stacks, we use the first stack to contain elements that are just added in, and
    use the second stack to put elements that are to go out.
    when we enqueue an element, we push it onto stack1.
    when we dequeue an element, we check if stack2 is empty or not. if empty, we move all elements in stack1
    to stack2, thus, the bottom element in stack1 is on the top on stack2, and that is the element first came in.
    so when we pop stack2, we get what we want.
 */

public class Solution04 {
    public class myQueue{
        Stack<Integer> stack1, stack2;

        public myQueue(){
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void enqueue(int val){
            stack1.push(val);
        }

        public int dequeue(){
            if(!stack2.isEmpty()){
                return stack2.pop();
            }
            else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }

}
