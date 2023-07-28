class RemoveNthNodeListNode {
    int val;
    RemoveNthNodeListNode next;

    RemoveNthNodeListNode(int val) {
        this.val = val;
    }
}

/**
 * From Leetcode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * **/

public class RemoveNthNodeFromEnd {
    public RemoveNthNodeListNode removeNthFromEnd(RemoveNthNodeListNode head, int n) {
        RemoveNthNodeListNode dummy = new RemoveNthNodeListNode(0);
        dummy.next = head;
        RemoveNthNodeListNode first = dummy;
        RemoveNthNodeListNode second = dummy;

        // Move the first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end of the list
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }

    // Utility method to create a linked list from an array
    public static RemoveNthNodeListNode createLinkedList(int[] arr) {
        RemoveNthNodeListNode dummy = new RemoveNthNodeListNode(0);
        RemoveNthNodeListNode current = dummy;
        for (int value : arr) {
            current.next = new RemoveNthNodeListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Utility method to print the linked list
    public static void printLinkedList(RemoveNthNodeListNode head) {
        RemoveNthNodeListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
        RemoveNthNodeListNode head = createLinkedList(arr);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        RemoveNthNodeListNode newHead = solution.removeNthFromEnd(head, n);

        System.out.println("Linked List after removing the " + n + "th node from the end:");
        printLinkedList(newHead);
    }
}
