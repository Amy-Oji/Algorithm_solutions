class IsPalindromeLinkedList {

    /**
     * From LeetCode:https://leetcode.com/problems/palindrome-linked-list/
     *
     * Given the head of a singly linked list, return true if it is a
     * palindrome
     *  or false otherwise.
     *
     *
     * Example 1:
     *
     * Input: head = [1,2,2,1]
     * Output: true
     *
     *
     * Example 2:
     *
     * Input: head = [1,2]
     * Output: false
     * **/

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode secondHalf = reverseLinkedList(slow);

        // Compare the values of nodes from the first half with the reversed second half
        ListNode curr1 = head;
        ListNode curr2 = secondHalf;
        while (curr1 != null && curr2 != null) {
            if (curr1.val != curr2.val) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;

    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head1));  // Output: true

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(isPalindrome(head2));  // Output: false
    }

}