import java.util.HashSet;
import java.util.Scanner;

public class Solution08 {
    public static class Node{
        int val;
        Node next;
        public Node(int d){
            val = d;
        }
    }

    // First, we keep two pointers to run, one at speed 2 and one at speed 1
    // if there is a circle in the linked list, they two will meet, and the time they meet
    // the fast pointer has the length of circle steps beyond the slow one
    // then we can get the length of the circle
    // else, the fast one will reach the end of the list

    // Second, when we let the fast pointer fisrt step the length of circle steps ahead,
    // and both of them move at speed 1
    // the point where they meet is the beginning of the loop
    public static Node loopDetection(Node head){
        if(head == null)
            return null;
        Node slow = head, fast = head;
        int circle_length = 0;
        while(fast != null && fast.next != null){
            if(fast == slow)
                break;
            fast = fast.next.next;
            slow = slow.next;
            circle_length ++;
        }
        if(fast == null || fast.next == null)
            return null;
        fast = head;
        slow = head;
        while(circle_length>0){
            circle_length --;
            fast = fast.next;
        }
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
