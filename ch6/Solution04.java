/**
 * Created by zhangyuwei on 10/7/15.
 */
public class Solution04 {
    /*
        For 3 ants, the scenario when they don't collide is they all choose left or right. Each of the possibility is
        1/2*1/2*1/2 = 1/8

        So, P(collision) = 1-1/8-1/8 = 3/4

        For n ants, the possibility of choosing the same direction is (1/2)^n

        So, P(collision) = 1-(1/2)^n - (1/2)^n = 1-(1/2)^(n-1)
     */
}
