import java.util.ArrayList;
import java.lang.Integer;
import java.util.Arrays;

/**
 * Created by zhangyuwei on 9/27/15.
 */

/*
    I get the hint that we can check the length of the array by doing exponential count like 2,4,8...
    so we can get the upper bound of the length of the array and do binary search.
    Time to find the length of the list in O(logN).

    I tried to extends ArrayList to simulate the data structure Listy, but it's not working...
 */
public class Solution04 {
    public static class myArrayList extends ArrayList<Integer>{
        ArrayList<Integer> l;
        public myArrayList(ArrayList a){
            l =new ArrayList<>(a);
        }
        public int elementAt(int index){
           try{
               Integer e = super.get(index);
               return e.intValue();
           }
           catch(Exception e){
               return -1;
           }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 0; i != 5; i ++){
            l.add(i);
        }
        myArrayList m = new myArrayList(l);
        System.out.println(sortedSearch(3,m));
        return;
    }

    public static int sortedSearch(int target, myArrayList l){
        if(l.elementAt(0) == -1){
            System.out.println("hello");
            return -1;
        }
        int i = 1;
        while(l.elementAt(i) != -1){
            i *= 2;
        }
        int left = 0, right = i;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (l.elementAt(mid) == target)
                return mid;
            else if (l.elementAt(mid) == -1 || l.elementAt(mid) > target)
                right =mid -1;
            else
                left = mid + 1;
        }
        return -1;

    }

}
