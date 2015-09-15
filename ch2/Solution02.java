import java.util.Scanner;

public class Solution02 {
    public static class Node {
        int val;
        Node next;

        public Node(int d) {
            val = d;
        }
    }

    // main function used to create a test linkedlist, and test on method
    // create a linkedlist of 10 elements, typing in the terminal from tail to head
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;
        Node tail = null, n, head;
        for (int i = 0; i < 10; i++) {
            input = scan.nextInt();
            n = new Node(input);
            n.next = tail;
            tail = n;
        }
        head = tail;
        System.out.println("");
        n = findKth(head, 3);
        System.out.print(n.val);
        return;
    }

    // we keep a fast pointer and a slow pointer, the faster one is k-step ahead of the slow pointer
    // so when the fast pointer reaches the end, the slow pointer will point at the
    // kth element to the end
    public static Node findKth(Node head, int k){
        Node fast = head, slow = head;
        if(head == null)
            return null;
        for(int i = 0; i != k; i ++){
            fast = fast.next;
            if(fast == null)
                return null;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
