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


    public void push(Object element){
        if(head == null){
            head = new Node(element);
        }
        else {
            Node next = head;
            head = new Node(element);
            head.next=next;
        }
    }

    public Object pop(){
        if (head==null) throw new EmptyStackException();
        Node holder = head;
        head=head.next;
        return holder.data;

    }

}
