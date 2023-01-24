import java.util.LinkedList;

public class ListNode {

    /**
     * LeetCode: <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Link Here</a>
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You must solve the problem without modifying the values in the list's nodes
     * (i.e., only nodes themselves may be changed.)
     *
     *
     * # Approach
     * Return head if the head is null or if the next to head is null
     * (that means the LinkedList is empty or contains only one element therefore there is nothing to swap)
     *
     * Else...
     * 1. Create a temp Node.
     * 2. Assign the head to temp.next.
     * 3. Create a current Node to be used for iteration and assign temp to it.
     * 4. Iterate using a while-loop with the condition that the next two nodes are not null.
     * 6. Exchange those two Nodes’ values inside the loop and reassign current to the next two nodes after it.
     * 7. Return the head (which I initially assigned to temp.next in my case)
     * **/

    Node head;

    class Node{
        int val;
       Node next;
        Node() {
        }
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node swapPairs(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node temp = new Node(0, null);
        temp.next = head;
        Node current = temp;

        int firstVal;
        int secondVal;

        while(current.next != null && current.next.next != null) {

            firstVal = current.next.val;

            secondVal = current.next.next.val;

            current.next.val = secondVal;

            current.next.next.val = firstVal;

            current = current.next.next;

        }
        return temp.next;

    }
}
