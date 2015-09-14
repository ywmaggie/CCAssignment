import java.util.Scanner;

public class Solution05 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        System.out.println(oneWay(s1, s2));
        return;
    }

    // First, if the difference in length of 2 strings are more than 2
    // they cannot be one edit away
    // Second, if there is difference in characters, we allow it for the first time
    // and increase the position we are looking at in different ways
    // but when we meet another different character, we no longer allow it and we return false
    // Time O(n) Space O(1)
    public static boolean oneWay(String s1, String s2){
        boolean differ = false;
        int len1 = s1.length(), len2 = s2.length();
        if(Math.abs(len1-len2)>1)
            return false;
        int i = 0, j = 0;
        while(i < len1 && j < len2){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else if(differ)
                return false;
            else{
                differ = true;
                if(len1 == len2){
                    i++;
                    j++;
                }
                else if(len1 > len2)
                    i ++;
                else
                    j ++;
            }
        }
        return true;
    }
}
