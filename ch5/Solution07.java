/**
 * Created by zhangyuwei on 10/4/15.
 */
/*
    Shift the original number to left by 1 bit and & 0x101010101010...., which will remain the right bit in the pair
    and put it at the left position in the pair. So does the left bit.
 */

public class Solution07 {
    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(pairSwap(1456)));
    }

    public static int pairSwap(int a){
        System.out.println(Integer.toBinaryString(a));
        int low_to_high = (a << 1) & 0xaaaaaaaa;
        int high_to_low = (a >> 1) & 0x55555555;
        return low_to_high | high_to_low;
    }

}
