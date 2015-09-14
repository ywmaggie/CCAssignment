import java.util.Scanner;

public class Solution04 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(palindromePermutation(s));
        return;
    }

    // if a string is a permutation of a palindrome, all characters in the string
    // must appear even times, except for at most one, which can be in the middle
    // of the palindrome.
    // thus we count the times each character appears in the string and keep them in an array
    // note that 'A' and 'a' are regarded as the same
    public static boolean palindromePermutation(String s){
        int[] hash = new int[26];
        for(int i= 0; i < 26; i ++)
            hash[i] = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) != ' ') {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    hash[s.charAt(i) - 'A']++;
                else
                    hash[s.charAt(i) - 'a']++;
            }
        }

        int warning = 0;
        for(int i=0; i < 26; i ++) {
            if (hash[i] % 2 == 1) {
                if (warning == 0)
                    warning = 1;
                else
                    return false;
            }
        }
        return true;
    }
}
