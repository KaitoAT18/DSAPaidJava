package net.braniumacademy.lesson103.exercises3;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private Node<T> next;
        private final T data;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T t) {
        Node<T> p = new Node<>(t);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public T remove() {
        if (!isEmpty()) {
            T t = head.data;
            head = head.next;
            return t;
        }
        return null;
    }

    public T front() {
        return isEmpty() ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
