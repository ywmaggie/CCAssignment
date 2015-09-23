import java.util.Stack;

/**
 * Created by zhangyuwei on 9/22/15.
 */

/*
    we use the second stack as a buffer, we insert all elements to buffer stack.
    we pop an element from the original stack, move all elements smaller than that element in buffer stack
    to the original stack, push that element and push back all the smaller ones back.
 */
public class Solution05 {
    public Stack<Integer> sort(Stack<Integer> unsorted){
        Stack<Integer> buf = new Stack<Integer>();
        while (!unsorted.isEmpty()){
            int temp = unsorted.pop();
            int count = 0;
            while(!buf.isEmpty() && buf.peek()<temp){
                count ++;
                unsorted.push(buf.pop());
            }
            buf.push(temp);
            for(int i = 0; i != count; i ++){
                buf.push(unsorted.pop());
            }
        }
        return buf;
    }

}
