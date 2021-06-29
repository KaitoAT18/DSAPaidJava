package net.braniumacademy.lesson26.exercises2;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            p.next = head; // next của p chính là head cũ
            head.prev = p; // prev của head cũ là p
            head = p;      // cập nhật head mới
        }
    }

    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            tail.next = p;  // next của tail cũ là p
            p.prev = tail;  // prev của p là tail cũ
            tail = p;       // cập nhật lại tail mới
        }
    }

    public void insertAfterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        // tìm node có giá trị dữ liệu == x
        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null && nodeX == tail) {
            insertTail(data);
        } else if (nodeX != null) {
            p.next = nodeX.next; // cập nhật next của p
            p.prev = nodeX;      // cập nhật prev của p
            nodeX.next.prev = p; // cập nhật prev của node sau p
            nodeX.next = p;      // cập nhật next của nodeX
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void traversalFromHead() {
        for (Node<T> node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public void traversalFromTail() {
        for (Node<T> node = tail; node != null; node = node.prev) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public boolean removeNode(T data) {
        Node<T> x = head;
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            x = x.next;
        }
        // kiểm tra
        if(x == null) {
            return false;
        } else {
            if(x == head) {
                removeHead(x);
            } else if(x ==tail) {
                removeTail(x);
            } else {
                remove(x);
            }
            return true;
        }
    }

    private void remove(Node<T> x) {
        Node<T> prevX = x.prev;
        Node<T> nextX = x.next;
        prevX.next = x.next;
        nextX.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void removeTail(Node<T> x) {
        Node<T> prevX = x.prev;
        prevX.next = null;
        tail = prevX;
        x.prev = null;
    }

    private void removeHead(Node<T> x) {
        Node<T> nextX = x.next;
        nextX.prev = null;
        head = nextX;
        x.next = null;
    }
}
