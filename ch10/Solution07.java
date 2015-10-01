import java.util.Scanner;

/**
 * Created by zhangyuwei on 9/30/15.
 */

/*
    From the hint and solution, I get the point that we can use a bit-vector to record the integers that have appeared.
    1GB mem has 8G bits, and we only have 4G ints, so we can do that.

    We mainly use the mem to contain the bit-vector, and we read one integer from the file each time, so we are not
    take too much memory.

    Finally, we look up the bit-vector from the beginning and find the first integer that has not appeared.

    I didn't read form file this time, but rather to test this program, I design it to read from stdin.
    We can test this program by typing a series of numbers, ending with -1, and the output will be the smallest
    integer that has not appeared yet.
 */
public class Solution07 {
    public static void main(String[] args){
        System.out.println(missingInt());
    }

    public static int missingInt(){
        byte[] bitVector = new byte[Integer.MAX_VALUE/8+1];
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num != -1){
            int pos = num/8;
            bitVector[pos] |= (1<<num%8);
            num = scan.nextInt();
        }

        for(int i = 0; i != bitVector.length; i ++){
            if(bitVector[i] != 511){
                for(int j = 0; j != 8; j ++){
                    if((bitVector[i] & (1<<j)) == 0){
                        return (i*8+j);
                    }
                }
            }
        }
        return -1;
    }
}
