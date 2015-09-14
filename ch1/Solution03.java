import java.util.Scanner;

public class Solution03 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        URLify(s, s.length());
        return;
    }


    // Given hint#52 to modify string from end to the beginning
    // convert string to a char array, and modify in place
    // move every char to the end if it is not a ' '
    // or add "%20" to the end if it is ' '
    // notice that 'end' will be larger than 'cur'
    // so it will not run the risk of overwriting the character ar position cur.
    public static void URLify(String s, int len){
        //System.out.println(len);
        char[] ca = s.toCharArray();
        int cur=len-1, end=len-1;
        while(ca[cur] == ' ')
            cur --;
        for(; cur >= 0; cur --){
            if(ca[cur] != ' ')
                ca[end--] = ca[cur];
            else{
                ca[end--] = '0';
                ca[end--] = '2';
                ca[end--] = '%';
            }
        }
        String str = new String(ca);
        System.out.println(str);
    }
}
