public class SinglyLinkedList {
    /**
     * Working with Singly linkedList
     * **/
    Node head;
    Node tail;
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

    /**
     * From LeetCode
     * Link: <a href="https://leetcode.com/problems/reverse-linked-list/">...</a>
     * **/
    public SinglyLinkedList reverseLinkedList(SinglyLinkedList linkedList) {

        Node previous = null;
        Node current = linkedList.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            if(previous.next != null){
                System.out.println(previous.next.val);
                System.out.println(current.next.val);

            }
        }
       head = previous;
        return linkedList;

    }


    public  int calcSize(Node list3){
        int size = 0;
        Node node = list3;
        // traverse to the last node each time incrementing the size
        while(node!=null){
            size++;
            node = node.next;
        }
        System.out.print("The size of the linkedList is: ");
        return size;
    }

    public void insertNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }
    }

    /**
     * From LeetCode.
     * Link: <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/">...</a>
     *
     * You are given the head of a linked list, and an integer k.
     *
     * Return the head of the linked list after swapping the values of the kth node from the beginning
     * and the kth node from the end (the list is 1-indexed).
     *
     * Example 1:
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [1,4,3,2,5]
     *
     * Example 2:
     * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output: [7,9,6,6,8,7,3,0,9,5]
     * **/
    public static SinglyLinkedList swapNodesWithIndex(SinglyLinkedList head, int k) {

        int len = 0;
        Node current = head.head;

        // Calculate length of linked list
        while (current != null) {
            len++;
            current = current.next;
        }

        // If k is greater than length of list, return head
        if (len < k) return head;

        Node first = head.head;

        // Traverse to kth node from beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        Node second = head.head;

        // Traverse to kth node from end
        for (int i = 1; i <= len - k; i++) {
            second = second.next;
        }

        // Swap values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    public static void printList(SinglyLinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList node = new SinglyLinkedList();
        node.insertNode(7);
        node.insertNode(9);
        node.insertNode(6);
        node.insertNode(6);
        node.insertNode(7);
        node.insertNode(8);
        node.insertNode(3);
        node.insertNode(0);
        node.insertNode(9);
        node.insertNode(5);

        printList(node);
        swapNodesWithIndex(node, 5);
        System.out.println();
        printList(node);



    }
}
