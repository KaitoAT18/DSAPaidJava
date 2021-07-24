package net.braniumacademy.lesson45.exercises1;

import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E> {
    private Node<E> head;

    public void minPriorityElements() {
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
        } else {
            int minPriority = head.priority;
            for (var p = head; p != null; p = p.next) {
                if (p.priority < minPriority) {
                    minPriority = p.priority;
                }
            }
            for (var p = head; p != null; p = p.next) {
                if (p.priority == minPriority) {
                    System.out.print(p.data + " ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MIterator();
    }

    class MIterator implements Iterator<E> {
        private Node<E> p;

            public MIterator() {
                Node<E> beforeHead = new Node<>(null, 0);
                beforeHead.next = head;
                head.prev = beforeHead;
                p = beforeHead;
            }

            @Override
            public boolean hasNext() {
            return p.next != null;
        }

            @Override
            public E next() {
            return p.data;
            }
    }

    static class Node<E> {
        private E data;
        private int priority;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, int priority) {
            this.data = data;
            this.priority = priority;
            next = null;
            prev = null;
        }
    }

    public void add(E e, int priority) {
        Node<E> p = new Node<>(e, priority);
        if (isEmpty()) {
            head = p;
        } else if (p.priority > head.priority) {
            p.next = head;
            head.prev = p;
            head = p;
        } else {
            var r = head;
            for (var q = head.next; q != null; q = q.next) {
                if (q.priority < p.priority) {
                    break;
                }
                r = q;
            }
            if(r == head) {
                head.next = p;
                p.prev = head;
            } else {
                p.next = r.next;
                r.next.prev = p;
                r.next = p;
                p.prev = r;
            }
        }
    }

    public E remove() {
        if (!isEmpty()) {
            E tmp = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return tmp;
        }
        return null;
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    private boolean isEmpty() {
        return head == null;
    }
}
