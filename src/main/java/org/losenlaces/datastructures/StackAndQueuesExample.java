package org.losenlaces.datastructures;

public class StackAndQueuesExample {


    public static void main(String[] args) throws Stack.StackOverFlowExecption, Stack.StackUnderFlowExecption {
        int elements = 4;
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Stack content (LIFO)");
        for (int i = 0; i < elements; i++) {
            System.out.printf("Stack element at index %d: %d\n", i, stack.pop());
        }

        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);


        System.out.println("Queue result (FIFO)");
        for (int i = 0; i < elements; i++) {
            System.out.printf("Queue element at index %d: %d\n", i, queue.dequeue());
        }
    }

    static class Stack {

        private static int MAX_SIZE = 40;

        private Element top;
        private int size = 0;

        public void push(Integer data) throws StackOverFlowExecption {
            if (size == MAX_SIZE) {
                throw new StackOverFlowExecption();
            }

            Element element = new Element(data, top);
            top = element;
            size++;
        }

        public Integer pop() throws StackUnderFlowExecption {
            if (size == 0) {
                throw new StackUnderFlowExecption();
            }
            Integer data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }

        public Integer peek() throws StackUnderFlowExecption {
            if (size == 0) {
                throw new StackUnderFlowExecption();
            }
            return top.getData();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == MAX_SIZE;
        }

        public int getSize() {
            return size;
        }

        public static class StackOverFlowExecption extends Exception {

        }

        public static class StackUnderFlowExecption extends Exception {

        }
    }

    static class Queue {
        private Stack forwardStack = new Stack();
        private Stack reverseStack = new Stack();

        public Queue() {
        }

        public boolean isFull() {
            return forwardStack.isFull() || reverseStack.isFull();
        }

        public boolean isEmpty() {
            return forwardStack.isEmpty() && reverseStack.isEmpty();
        }

        public void enqueue(Integer data) throws Stack.StackUnderFlowExecption, Stack.StackOverFlowExecption {
            if (isFull()) {
                //TODO Throw exception
            }

            try {
                if (forwardStack.isEmpty()) {
                    while (!reverseStack.isEmpty()) {
                        forwardStack.push(reverseStack.pop());
                    }
                }
                forwardStack.push(data);
            } catch (Stack.StackOverFlowExecption | Stack.StackUnderFlowExecption stackOverFlowExecption) {
                throw stackOverFlowExecption;
            }
        }

        public Integer dequeue() throws Stack.StackUnderFlowExecption, Stack.StackOverFlowExecption {
            if (isEmpty()) {
                //TODO throw exception
            }

            try {
                if (reverseStack.isEmpty()) {
                    while (!forwardStack.isEmpty()) {
                        reverseStack.push(forwardStack.pop());
                    }
                }
                return reverseStack.pop();
            } catch (Stack.StackOverFlowExecption | Stack.StackUnderFlowExecption stackOverFlowExecption) {
                throw stackOverFlowExecption;
            }
        }
    }


    static class Element {
        private Integer data;
        private Element next;

        public Element(Integer data, Element next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

}
