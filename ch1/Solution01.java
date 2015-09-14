import java.lang.System;
import java.util.HashSet;
import java.util.Scanner;

public class Solution01{
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            System.out.println(method1(s));
            System.out.println(method2(s));
        }

        // Method1: add each character to a hashset (or a hashmap, hashtable),
        //          check if the character has already existed
        public static boolean method1(String s){
            HashSet<Character> unique = new HashSet<>();
            for(int i = 0; i < s.length(); i ++){
                if(unique.add(s.charAt(i)) == false)
                    return false;
            }
            return true;
        }

        // Method2: compare each two chars in the string, this takes O(n^2) time
        public static boolean method2(String s){
            for(int i = 0; i < s.length(); i++){
                for(int j = i+1; j < s.length(); j ++){
                    if(s.charAt(i) == s.charAt(j))
                        return false;
                }
            }
            return true;
        }
}