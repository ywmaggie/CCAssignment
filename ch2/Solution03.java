import java.util.Scanner;

public class Solution03 {
    public static class Node {
        int val;
        Node next;

        public Node(int d) {
            val = d;
        }
    }

    // main function used to create a test linkedlist, and test on method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;
        Node tail = null, n, head;
        for (int i = 0; i < 5; i++) {
            input = scan.nextInt();
            n = new Node(input);
            n.next = tail;
            tail = n;
        }
        head = tail;
        n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println("");
        deleteMiddleNode(head.next.next);
        n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        return;
    }

    // get this idea from hint and solution, which is copy data from the next node to this one
    // and delete the next node
    public static void deleteMiddleNode(Node c){
        if(c == null)
            return;
        if(c.next == null)
            return;
        c.val = c.next.val;
        c.next = c.next.next;
        return;
    }


    // *IMPORTANT* I understand this problem in a wrong way, below is what I first thought ...

    // We keep a fast pointer and a slow pointer
    // the fast pointer step moves 2 nodes each iteration, the slow pointer moves 1 ahead
    // when the fast pointer moves to the end, the slow pointer points to the middle
    // inorder to easy delete the slow pointer, we keep a fake head and a pointer points to right
    // 1 node before the slow pointer
    public static void deleteMiddle(Node head){
        Node fast = head, slow = head;
        Node fhead = new Node(0);
        fhead.next = head;
        Node prev = fhead;
        if(head == null)
            return;
        if(head.next == null){
            head = null;
            return;
        }
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
                prev = prev.next;
            }
        }
        prev.next = prev.next.next;
        return;
    }
}
