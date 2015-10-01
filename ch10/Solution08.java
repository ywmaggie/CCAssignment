import java.util.Scanner;

/**
 * Created by zhangyuwei on 9/30/15.
 */

/*
    we are also going to use bit-vector in this problem.
    4KB mem has 32k bits, in which we can record 32,000 integers. We mark a 1 when a number appears, and before that
    we check whether the number has appeared or not.
    If so, we should print it out.

    Also, I didn't read from array, but rather to test this program, I design it to read from stdin.
    We can test this program by typing a series of numbers, ending with -1, and output the duplicate numbers.
 */
public class Solution08 {
    public static void main(String[] args) {
        findDuplicate();
    }

    public static void findDuplicate() {
        byte[] bitVector = new byte[4000];
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (num != 0) {
            int pos = num / 8;
            if ((bitVector[pos] & (1 << num % 8)) > 0)
                System.out.println(num);
            else
                bitVector[pos] |= (1 << num % 8);
            num = scan.nextInt();
        }
        return;
    }
}