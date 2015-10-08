import java.util.Random;

/**
 * Created by zhangyuwei on 10/7/15.
 */
public class Solution10 {
    /*
        Naive Solution:
        Day 1: Group 100 bottles together and drop them on 1 piece of strip. Looking at the result of
                10 strips, we can narrow down the poisonous bottle to 100. And we have 9 clean strip and
                1 dirty strip.

        Day 8: Group 10 bottles together and do the same. We narrow down to 10. and we get at most 2 dirty
                strips.

        Day 15: We have a drop of each bottle on each strip. Hopefully, it the poisonous drop is exactly on a
                clean strip, we can find out that. Otherwise we cannot tell apart 2 bottle whose experienments
                 are on dirty strips. we wait for a next loop.

        Day 22: Now still have 8 clean strips and 2 bottles to distinguish. We can find that out on day 28!


        7-day solution:
        As we have 10 pieces of strips, according to their final pattern, we can actually present 2^10 = 1024
        bottles.

        In this way, for example 356 in its binary representation is 0101100100, so we drop the 365th bottle
        on the 2, 4, 5, 8 pieces of strip. So if the result turns to be like 0101100100, we know exactly
        365 is the poisonous bottle.
     */
    public static void main(String[] args){
        Random rand = new Random();
        int bottle = rand.nextInt(1000);
        findBottle(bottle);
    }

    public static void findBottle(int bottle){
        System.out.println("Poisonous bottle: "+bottle);
        int strips[] = {0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < 1000; i ++){
            if(i == bottle){
                for(int bit = 0; bit < 10; bit ++){
                    strips[bit] = (i >> bit)&1;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < 10; i ++){
            System.out.print(strips[i]);
            if(strips[i] == 1)
                result += Math.pow(2,i);
        }
        System.out.println("\nChoose bottle: " + result);
    }

}
