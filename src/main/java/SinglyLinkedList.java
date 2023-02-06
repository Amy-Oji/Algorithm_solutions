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

//    https://leetcode.com/problems/reverse-linked-list/
    /**
     * From LeetCode
     * Link: https://leetcode.com/problems/reverse-linked-list/
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
        node.insertNode(1);
        node.insertNode(2);
        node.insertNode(3);
        node.insertNode(4);
        printList(node);
        node.reverseLinkedList(node);
        System.out.println();
        printList(node);



    }
}
