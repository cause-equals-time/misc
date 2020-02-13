package com.company;


public class ArrList {

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



    public int length() {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }



    private Node getTail() {
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }



    public void add(Object element){

        if(head == null){
            head = new Node(element);
        }
        else {
            getTail().next = new Node(element);
        }
    }



    private Node getNode(int index){
        Node current = head;

        for (int i = 1; i <= index; i++){
            current = current.next;
        }

        return current;
    }



    public Object get(int index){

        return getNode(index).data;

    }



    public void insert(int index, Object element){
        Node current = head;

        if (index == 0){
            head = new Node(element);
            head.next = current;
        }else{
            Node previous = null;

            for (int i = 1; i <= index; i++){
                previous = current;
                current = current.next;
            }

            Node holder = new Node(element);
            previous.next = holder;
            holder.next = current;
        }
    }



    public Object replace(int index, Object element){
        Node current = head;
        Object holder = current.data;

        if (index == 0) {
            head.data = element;
            return holder;
        }

        current = getNode(index);
        holder = current.data;
        current.data = element;

        return holder;
    }



    public void replaceAll(Object element, Object replacement){
        Node current = head;

        while (current != null){
            if (current.data.equals(element)){
                current.data = replacement;
            }
            current = current.next;
        }
    }



    public void remove(Object element){
        Node current = head;

        if (current.data.equals(element)){
            head = head.next;
        }else{
            Node previous = null;

            while (!(current.data.equals(element)) && current.next != null) {
                previous = current;
                current = current.next;
            }

            if (current.data.equals(element)) previous.next = current.next;
        }
    }



    public Object remove(int index){
        Node current = head;

        if (index == 0) {
            head = head.next;
            return current.data;
        }

        Node previous = null;
        for (int i = 1; i <= index; i++){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;

        return current.data;
    }



    public void removeAll(Object element) {
        Node current = head;

        if (current.data.equals(element)){

            while (current.data.equals(element)) {
                current = current.next;
            }

            head = current;
        }

        Node previous = null;

        while (current != null) {
            if (!current.data.equals(element)) {
                previous = current;
            }
            if (current.data.equals(element)) {
                previous.next = current.next;
            }
            current = current.next;
        }
    }



    public void reverse(){
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }



    public boolean isEmpty(){
        return length() == 0;
    }



    @Override
    public String toString() {
        if (head == null) return ("[]");
        Node current = head;
        StringBuilder print = new StringBuilder("[");
        while (current != null){
            print.append(current.data).append(", ");
            current = current.next;
        }
        print.setLength(print.length()-2);
        print.append("]");
        return print.toString();
    }



}
