import java.util.Scanner;

public class Solution06 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(stringCompression(s));
        return;
    }

    // Go through the whole string and count how many times each character appears
    // if the compressed string is not shorter than the original one, return the original one
    public static String stringCompression(String s){
        String cStr  = "";
        int cur = 0, count = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == s.charAt(cur))
                count ++;
            else{
                cStr = cStr + s.charAt(cur) + count;
                count = 1;
                cur = i;
            }
        }
        cStr = cStr + s.charAt(cur) + count;
        if(cStr.length() < s.length())
            return cStr;
        else
            return s;
    }

}
