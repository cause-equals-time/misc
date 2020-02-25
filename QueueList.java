package com.company;

import java.util.NoSuchElementException;

public class QueueList {

    private Node head;
    private Node tail;

    private static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    public void enQueue(Object element){
        if(head == null){
            tail = new Node(element);
            head=tail;
        }
        else {
            tail.next = new Node(element);
            tail=tail.next;
        }
    }

    public Object deQueue() {
        if (head==null) throw new NoSuchElementException();
        Node holder = head;
        head = head.next;
        return holder.data;
    }

    public void reverse(){
        Node previous = null;
        Node current = head;
        Node next;

        while (current!=null){
            next = current.next;
            current.next = previous;
            previous=current;
            current=next;
        }
        tail=head;
        head=previous;

    }
}
