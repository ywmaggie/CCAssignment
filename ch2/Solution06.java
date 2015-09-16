import java.util.Scanner;

public class Solution06 {
    public static class Node{
        int val;
        Node next;
        public Node(int d){
            val = d;
        }
        public Node(Node n){
            val = n.val;
        }
    }

    // main function used to create a test linkedlist, and test on method
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input;
        Node tail = null, n, head;
        for( int i = 0; i < 5; i ++){
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
        System.out.println(palindrome(head));
        return;
    }

    // We create a new reversed linkedlist of the original linkedlist
    // and compare if they are the same
    public static boolean palindrome(Node h){
        Node rh = reverse(h);
        return same(h, rh);
    }

    public static Node reverse(Node h){
        if(h == null)
            return h;
        Node prev, cur = h, next = h.next;
        Node cloneCur = new Node(cur);
        cloneCur.next = null;
        while(next != null){
            prev = cloneCur;
            cur = next;
            next = next.next;
            cloneCur = new Node(cur);
            cloneCur.next = prev;
        }
        return cloneCur;
    }

    public static boolean same (Node h1, Node h2){
        Node p1 = h1, p2 = h2;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 != null || p2 != null){
            return false;
        }
        return true;
    }
}
