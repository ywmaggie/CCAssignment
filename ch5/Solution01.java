/**
 * Created by zhangyuwei on 10/4/15.
 */

/*
    I would first clear all bits from j to i in N to zero, and then move M to the right position and
    do an "OR" operation with M and N.
 */
public class Solution01 {
    public static void main(String[] args){
        insertion(2048,19,2,6); //n = 100000000000, m = 10011
    }

    public static void insertion(int n, int m, int i, int j){
        int result = n;
        for(int k = i; k <= j; k ++){
            int mask = ~(1<<k);
            result &= mask;
        }
        result |= m << i;
        System.out.println(Integer.toBinaryString(result));
    }
}
