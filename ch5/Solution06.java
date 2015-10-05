/**
 * Created by zhangyuwei on 10/4/15.
 */

/*
    Compute a^b will gives how many bits different in a and b. we now need to count how many 1s in c, which is the
    number of different bits in a and b.
    To count how many 1s in an integer, doing c&(c-1) will clear the lowest 1. Repeat until there is no 1 in c, and we
    will get the total number of 1s in c.
 */

public class Solution06 {
    public static void main(String[] args){
        System.out.println(conversion(29,15));
    }

    public static int conversion(int a, int b){
        int c = a^b;
        int count = 0;
        while (c != 0){
            c &= (c-1);
            count ++;
        }
        return count;
    }
}
