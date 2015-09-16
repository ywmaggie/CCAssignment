import java.util.Scanner;

public class Solution05 {
    public static class Node {
        int val;
        Node next;

        public Node(int d) {
            val = d;
        }
    }

    // main function used to create 2 test linkedlists, and test on method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;
        Node tail = null, n, head1, head2;
        for (int i = 0; i < 3; i++) {
            input = scan.nextInt();
            n = new Node(input);
            n.next = tail;
            tail = n;
        }
        head1 = tail;
        tail = null;
        for (int i = 0; i < 3; i++) {
            input = scan.nextInt();
            n = new Node(input);
            n.next = tail;
            tail = n;
        }
        head2 = tail;
        Node head = addReverse(head1, head2);
        n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        return;
    }

    // Maintain 1 pointer for each linkedlist, use the carry/remian method to add up two digits
    // until 1 of the pointers get to the end.
    // then we add carry and the remaining list
    public static Node add(Node h1, Node h2){
        if(h1 == null && h2 == null)
            return null;
        Node head = new Node(-1);
        Node tail = head;
        Node p1 = h1, p2 = h2, p;
        int remain = 0, carry = 0;
        while(p1!=null && p2 != null){
            remain = (p1.val + p2.val + carry) % 10;
            carry = (p1.val + p2.val + carry) /10;
            tail.next = new Node(remain);
            tail = tail.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null)
            p = p2;
        else
            p = p1;

        while(p != null){
            remain = (p.val + carry) % 10;
            carry = (p.val + carry) /10;
            tail.next = new Node(remain);
            tail = tail.next;
            p = p.next;
        }
        if(carry != 0){
            tail.next = new Node(carry);
            tail = tail.next;
        }
        return head.next;
    }

    //Follow up: Forward order
    //Reverse the linklist, get the answer, and then reverse the answer
    public static Node addReverse(Node h1, Node h2){
        h1 = reverse(h1);
        h2 = reverse(h2);
        return reverse(add(h1, h2));
    }

    public static Node reverse(Node h){
        if(h == null || h.next == null)
            return h;
        Node prev = null, cur = h, next = h.next;
        cur.next = prev;
        while(next != null){
            prev = cur;
            cur = next;
            next = next.next;
            cur.next = prev;
        }
        return cur;
    }
}

