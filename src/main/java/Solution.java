class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int val) {
        this.val = val;
    }
}

public class Solution {

    /**
     *
     * FRom  LeetCode: https://leetcode.com/problems/middle-of-the-linked-list/
     *
     * Given the head of a singly linked list, return the middle node of the linked list.
     *
     * If there are two middle nodes, return the second middle node.
     *
     *
     * Example 1:
     *
     * Input: head = [1,2,3,4,5]
     * Output: [3,4,5]
     * Explanation: The middle node of the list is node 3.
     *
     *
     * Example 2:
     *
     * Input: head = [1,2,3,4,5,6]
     * Output: [4,5,6]
     * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
     *
     * **/
    public static ListNode2 middleNode(ListNode2 head) {
        ListNode2 slow = head;
        ListNode2 fast = head;
        
        // Move the fast pointer at double the speed of the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode2 head1 = new ListNode2(1);
        head1.next = new ListNode2(2);
        head1.next.next = new ListNode2(3);
        head1.next.next.next = new ListNode2(4);
        head1.next.next.next.next = new ListNode2(5);
        printLinkedList(middleNode(head1));  // Output: 3 -> 4 -> 5

        // Example 2
        ListNode2 head2 = new ListNode2(1);
        head2.next = new ListNode2(2);
        head2.next.next = new ListNode2(3);
        head2.next.next.next = new ListNode2(4);
        head2.next.next.next.next = new ListNode2(5);
        head2.next.next.next.next.next = new ListNode2(6);
        printLinkedList(middleNode(head2));  // Output: 4 -> 5 -> 6
    }

    private static void printLinkedList(ListNode2 head) {
        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
