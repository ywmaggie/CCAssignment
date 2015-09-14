import java.util.Scanner;

public class Solution09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        System.out.println(stringRotation(s1, s2));
        return;
    }

    public static boolean isSubstring(String sub, String s){
        return s.contains(sub);
    }

    // if s1 is the rotation of s2, first they must be of the same length.
    // in addition, we can find that s2+s2, (eg s2 = "erbottlewat", s2+s2 = "erbottlewaterbottlewat"
    // it must contains the original s1, which is "waterbottle"
    public static boolean stringRotation(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        String doubles2 = s2 + s2;
        return isSubstring(s1, doubles2);
    }

}