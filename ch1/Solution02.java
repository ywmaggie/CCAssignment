import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution02 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        System.out.println(checkPermutation(s1, s2));
    }

    // Sort these two given strings, if they contain all the same characters,
    // after sorting, they should be exactly the same.
    // Time: O(nlongn) Space: O(n)
    public static boolean checkPermutation(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        if(Arrays.equals(str1, str2))
            return true;
        else
            return false;
    }
}
