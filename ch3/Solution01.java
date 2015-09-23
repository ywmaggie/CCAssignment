/**
 * Created by zhangyuwei on 9/21/15.
 */

// We keep 3 pointers to each points to the begining of the stack
// When we push a value onto the stack, we simply increase the pointer and write the value
// When we pop a value from the stack, we read the value and decrease the pointer
public class Solution01 {
    public class myStack{
        int begin1, begin2, begin3;
        int[] nums;
        int size;

        // init
        public myStack(int arraysize){
            nums = new int[arraysize];
            size = arraysize;
            begin1 = －1;
            begin2 = arraysize/3－1;
            begin3 = 2*arraysize/3－1;
        }

        public void push(int index, int val){
            switch (index){
                case 1:
                    if(begin1 < size/3-1)
                        nums[++begin1] = val;
                    break;
                case 2:
                    if(begin2 < 2*size/3-1)
                        nums[++begin2] = val;
                    break;
                case 3:
                    if(begin3 < size-1)
                        nums[++begin3] = val;
                    break;
            }
        }

        public int pop(int index){
            switch (index){
                case 1:
                    if(begin1>-1 )
                        return nums[begin1--];
                case 2:
                    if(begin2>size/3－1 )
                        return nums[begin2--];
                case 3:
                    if(begin3 > 2*size/3－1)
                        return nums[begin3--];
            }
        }

        public int peek(int index){
            switch (index){
                case 1:
                    if(begin1>-1 )
                        return nums[begin1];
                case 2:
                    if(begin2>size/3－1 )
                    return nums[begin2];
                case 3:
                    if(begin3 > 2*size/3－1)
                    return nums[begin3];
            }
        }

        public boolean isEmpty(){
            return begin1 == -1 && begin2 == size/3－1 && begin3 == 2*size/3－1;
        }

    }

}
