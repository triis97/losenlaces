package org.losenlaces.datastructures;


/*
A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations.
The elements in a linked list are linked using pointers
 */
public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(4);

        Node currentElement = linkedList.head;
        while (currentElement!=null){
            System.out.println(currentElement.data);
            currentElement = currentElement.next;
        }
        System.out.println("No more elements");
    }

    static class LinkedList {
        public Node head;
        public Node tail;

        public int elements = 0;

        public LinkedList() {
            this.head = null;
            this.tail = null;

        }

        public void insertNode(int nodeData) {
            elements++;
            Node node = new Node(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static class Node{
        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

}
