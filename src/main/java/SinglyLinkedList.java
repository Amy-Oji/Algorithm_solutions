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
        }
        head = previous;
        return linkedList;
    }


    public  int calcSize(Node head){
        int size = 0;
        Node node = head;
        // traverse to the last node each time incrementing the size
        while(node!=null){
            size++;
            node = node.next;
        }
        System.out.print("The size of the linkedList is: " + size);
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
     * You are given the list of a linked list, and an integer k.
     *
     * Return the list of the linked list after swapping the values of the kth node from the beginning
     * and the kth node from the end (the list is 1-indexed).
     *
     * Example 1:
     * Input: list = [1,2,3,4,5], k = 2
     * Output: [1,4,3,2,5]
     *
     * Example 2:
     * Input: list = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output: [7,9,6,6,8,7,3,0,9,5]
     * **/
    public static SinglyLinkedList swapNodesWithIndex(SinglyLinkedList list, int k) {

        int len = 0;
        Node current = list.head;

        // Calculate length of linked list
        while (current != null) {
            len++;
            current = current.next;
        }

        // If k is greater than length of list, return list
        if (len < k) return list;

        Node first = list.head;

        // Traverse to kth node from beginning
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        Node second = list.head;

        // Traverse to kth node from end
        for (int i = 1; i <= len - k; i++) {
            second = second.next;
        }

        // Swap values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return list;
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

    public SinglyLinkedList insertNodeAtHead(SinglyLinkedList list, int data) {
        Node newNode = new Node(data);
//        Node head = list.head;
        if(list.head == null){
            list.head = newNode;
        }else{
            Node currentNode = list.head;
            list.head = newNode;
            list.head.next = currentNode;
        }
        return list;
    }
    /**
     * From Hackeranck
     * Link : https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
     *
     * Description:
     * Given the pointer to the head node of a linked list and an integer to insert at a certain position,
     * create a new node with the given integer as its  data attribute, insert this node at the desired position and return the head node.
     *
     * A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
     * The head pointer given may be null meaning that the initial list is empty.
     *
     *
     * Example
     * head refers to the first node in the list: 1 -> 2 -> 3
     * data = 4
     * position = 2
     * Insert a node at position 2 with 4. The new list is 1 -> 2 -> 4 -> 3
     *
     *
     * insertNodeAtPosition has the following parameters:
     *
     * head: a SinglyLinkedListNode pointer to the head of the list
     * data: an integer value to insert as data in your new node
     * position: an integer position to insert the new node, zero based indexing
     * Returns
     *
     * SinglyLinkedListNode pointer: a reference to the head of the revised list
     * **/
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        Node previous = null;
        int index = 0;
        while (current != null && index != position) {
            previous = current;
            current = current.next;
            index++;
        }
        if (index == position) {
            previous.next = newNode;
            newNode.next = current;
        }
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode( 1);
        list.insertNode( 2);
        list.insertNode( 3);
        list.insertNode( 4);
        list.insertNode( 5);

        printList(list);

        System.out.println();

        list.insertAtPosition(18, 2);
        list.insertNodeAtHead(list, 0);
        list.swapPairs(list.head);
        list.reverseLinkedList(list);
        swapNodesWithIndex(list, 3);
        list.calcSize(list.head);

        System.out.println();
        printList(list);
    }
}
