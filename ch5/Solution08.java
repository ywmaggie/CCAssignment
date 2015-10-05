/**
 * Created by zhangyuwei on 10/4/15.
 */

/*
    First get the byte in each line form x1 to x2, then get the position of bit in the byte.
 */
public class Solution08 {
    public static void main(String[] args){
        byte[] screen = {1,2,3,4,5,6,7,8,9};
        drawLine(screen, 8, 2, 8, 6);
    }

    public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
        for(int i = x1; i <= x2; i ++){
            int pos = (i-1)*width/8+y/8;
            int result = (screen[pos] >> (7-y%8))&1;
            System.out.println(result);
        }
    }
}
