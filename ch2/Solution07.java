import java.util.Scanner;

public class Solution07 {
    public static class Node{
        int val;
        Node next;
        public Node(int d){
            val = d;
        }
    }

    // If 2 linkedlist have intersection, then the lengths of linkedlist after intersection are the same
    // only lengths before the intersection can differ, and we want to eliminate that difference
    // So first we count the lengths of two linked list, and move the pointer of the longer list forward
    // Now if the 2 linkedlist have intersection, and the pointers move together, they should meet
    // otherwise, there is no intersection

    public static Node intersection(Node h1, Node h2){
        Node p1 = h1, p2 = h2,p;
        int len1=0, len2 = 0, diff;
        while(p1 != null){
            len1 ++;
            p1 = p1.next;
        }
        while(p2 != null){
            len2 ++;
            p2 = p2.next;
        }
        p1 = h1;
        p2 = h2;
        if(len1>len2){
            diff = len1 -len2;
            while(diff > 0) {
                p1 = p1.next;
                diff--;
            }
        }
        else{
            diff = len2 - len1;
            while(diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }
        while(p1 != null && p2 != null){
            if(p1 == p2)
                return p1;
        }
        return null;
    }
}
