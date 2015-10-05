/**
 * Created by zhangyuwei on 10/4/15.
 */

/*
    As we are considering 32 bit double, we calculate the base of each bit. If the number is greater or equal than
    the base, we add a '1' to the result at that position and minus that base, else we get an '0'.
    Repeat this until we get to 32 bits or we get the number to 0.
 */

public class Solution02 {
    public static void main(String[] args){
        System.out.println(binaryToString(0.75));
    }

    public static String binaryToString(double number){
        if(number == 0)
            return "0";
        if(number == 1)
            return "1";

        String result = "0.";
        double base = 1;
        for(int i=1; i <= 32; i ++){
            if(number == 0)
                return result;
            base /= 2;
            if(number >= base) {
                result += "1";
                number -= base;
            }
            else
                result += "0";
        }
        if(number == 0)
            return result;
        else
            return "Error";
    }
}
