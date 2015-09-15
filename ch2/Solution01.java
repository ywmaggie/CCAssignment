import java.util.HashSet;
import java.util.Scanner;

public class Solution01 {
    public static class Node{
        int val;
        Node next;
        public Node(int d){
            val = d;
        }
    }

    // main function used to create a test linkedlist, and test on method
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input;
        Node tail = null, n, head;
        for( int i = 0; i < 10; i ++){
            input = scan.nextInt();
            n = new Node(input);
            n.next = tail;
            tail = n;
        }
        head = tail;
        n = head;
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println("");
        head = removeDup(head);
        n = head;
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        return;
    }

    // We use a hashset to keep track of what words have already appeared
    // if a word has already appeared, we delete it
    public static Node removeDup(Node head){
        HashSet<Integer> hash = new HashSet<>();
        Node n = head;
        if(head == null)
            return null;
        hash.add(head.val);
        while(n.next != null){
            if(hash.add(n.next.val) == false)
                n.next = n.next.next;
            else
                n = n.next;
        }
        return head;
    }
}
