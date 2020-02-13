package com.company;

import java.util.EmptyStackException;

public class StackList {

    private Node head;

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


    private Node getTail() {
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public void push(Object element){
        if(head == null){
            head = new Node(element);
        }
        else {
            getTail().next = new Node(element);
        }
    }

    public Object pop(){
        if (head==null) throw new EmptyStackException();
        if (head.next==null){
            Object holder=head.data;
            head=null;
            return holder;
        }
        Node tail = head.next;
        Node previous = head;
        while (tail.next != null) {
            previous=tail;
            tail = tail.next;
        }
        previous.next=null;
        return tail;

    }

}
