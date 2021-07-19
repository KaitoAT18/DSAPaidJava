package net.braniumacademy.lesson44;

import net.braniumacademy.lesson28.exercises3.Student;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {
        private Node<E> node = head;

        @Override
        public boolean hasNext() {
            return node != tail;
        }

        @Override
        public E next() {
            Node<E> p = node;
            node = node.next;
            return p.data;
        }
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(E e) {
        Node<E> p = new Node<>(e);
        p.next = head;
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public E remove() {
        if (!isEmpty()) {
            E tmp = head.data;
            head = head.next;
            if (tail != null) {
                tail.next = head;
            }
            return tmp;
        }
        return null;
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public E back() {
        return isEmpty() ? null : tail.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}