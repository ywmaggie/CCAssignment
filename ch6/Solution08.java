import java.util.Random;

/**
 * Created by zhangyuwei on 10/7/15.
 */
public class Solution08 {
    /*
        We can do a similar thing as binary search.
        We first look at floor 50, if the egg breaks, we look at floor 25, or we look at floor 75.
        Wr shrink the size be half each time. In the worst case, we have shrink the size from
        100 -> 50 -> 25 -> 13 -> 7 -> 4 -> 2 -> 1
        and it will take up to 8 times.
     */

    public static void main(String[] args){
        Random rand = new Random();
        int level = rand.nextInt(101);
        dropEgg(level);
    }
    public static void dropEgg(int level){
        System.out.println("Drop level: "+level);
        int start = 0, end = 100;
        while(start<end){
            int mid = (start+end)/2;
            System.out.print("Level:" + mid+"  ");
            if(mid < level){//not break
                start = mid+1;
                System.out.println("Safe!");
            }
            else{ //break
                end = mid;
                System.out.println("Break!");
            }
        }
        System.out.println("N = " + start);
    }
}
