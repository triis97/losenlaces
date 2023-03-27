package org.losenlaces.datastructures;

public class BinaryTreeExample {


    public static void main(String[] args) {
        Node rootNode = new Node(5);


        insertion(rootNode, new Node(2));
        insertion(rootNode, new Node(1));
        insertion(rootNode, new Node(3));
        insertion(rootNode, new Node(6));
        insertion(rootNode, new Node(7));

        Node findNode = lookup(rootNode, 3);
    }

    static class Node {
        private Integer data;
        private Node leftChild;
        private Node rightChild;


        public Node(Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static Node insertion(Node head, Node node) {
        if (head == null) {
            return node;
        }

        if (head.getData() >= node.getData()) {
            head.setLeftChild(insertion(head.getLeftChild(), node));
        } else {
            head.setRightChild(insertion(head.getRightChild(), node));
        }
        return head;
    }

    //This will return the node that contains the value we are looking for or null
    public static Node lookup(Node head, int data) {
        if (head == null) {
            return null;
        }
        if (head.getData() == data) {
            return head;
        }

        if (head.getData() >= data) {
            return lookup(head.getLeftChild(), data);
        } else {
            return lookup(head.getRightChild(), data);
        }
    }
}
