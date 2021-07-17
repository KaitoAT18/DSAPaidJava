package net.braniumacademy.lesson33.exercises6;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class LinkedList<T> {
    private Node<T> head;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T data) {
        Node<T> p = new Node<>(data);
        p.next = head;
        head = p;
    }

    public T remove() {
        if (!isEmpty()) {
            T tmp = head.data;
            head = head.next;
            return tmp;
        }
        return null;
    }

    public T front() {
        return isEmpty() ? null : head.data;
    }
}
