import java.util.Scanner;

public class Solution04 {
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
        for (int i = 0; i < 10; i++) {
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
        head = partition(head, 5);
        n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        return;
    }

    // we create two linkedlist head to keep track of nodes whose value are less than x,
    // and those whose value are larger than x
    // finally we concatenate these two lists
    public static Node partition(Node head, int x) {
        Node tail = head;
        if(head == null)
            return null;
        while(tail.next != null)
            tail = tail.next;
        Node small = new Node(-1);
        Node smalltail = small;
        Node large = new Node(-1);
        Node largetail = large;
        Node n = head;
        while(n != null){
            if(n.val >= x){
                largetail.next = n;
                largetail = n;
            }
            else{
                smalltail.next = n;
                smalltail = n;
            }
            n = n.next;
        }
        largetail.next = null;
        smalltail.next = large.next;
        return small.next;
    }
}
