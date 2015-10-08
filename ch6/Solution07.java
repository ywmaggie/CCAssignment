/**
 * Created by zhangyuwei on 10/7/15.
 */
import java.util.Random;

public class Solution07 {
    /*
       If a family has a girl at the first time P = 1/2   girl = 1 boy = 0
       second time P = 1/2*1/2 girl = 1 boy = 1
       3rd time P = 1/2*1/2*1/2 girl = 1 boy = 2
       4th time P = 1/2*1/2*1/2*1/2 girl = 1 boy = 3

       overall, we should have (1/2*0 + 1/4*1 + 1/8*2 + 1/16*3 + ...)/(1/2 + 1/4 + 1/8 + 1/16 + ...) = 1

       We are supposed to have same number of girls and boys.
     */

    public static void main(String[] args){
        girlBoy(100);
    }

    public static void girlBoy(int n){
        Random rand = new Random();
        int girls = n, boys = 0;
        boolean isGirl = false;
        for(int i = 0; i < n; i ++) {
            isGirl = rand.nextBoolean();
            while (!isGirl) {
                boys++;
                isGirl = rand.nextBoolean();
            }
        }
        System.out.println("Girls: " + girls +" Boys: "+boys + " Ratio:" + girls*1.0/boys);
    }

}
