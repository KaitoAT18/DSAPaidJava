package net.braniumacademy.lesson27.exercises2;

public class DoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkedList.Node<T> head;
    private DoublyLinkedList.Node<T> tail;

    static class Node<T> {
        private T data;
        private DoublyLinkedList.Node<T> next;
        private DoublyLinkedList.Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void insertHead(T data) {
        DoublyLinkedList.Node<T> p = new DoublyLinkedList.Node<>(data);
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
        DoublyLinkedList.Node<T> p = new DoublyLinkedList.Node<>(data);
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
        DoublyLinkedList.Node<T> p = new DoublyLinkedList.Node<>(data);
        DoublyLinkedList.Node<T> nodeX = head;
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
        for (DoublyLinkedList.Node<T> node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public void traversalFromTail() {
        for (DoublyLinkedList.Node<T> node = tail; node != null; node = node.prev) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public boolean removeNode(T data) {
        DoublyLinkedList.Node<T> x = head;
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

    private void remove(DoublyLinkedList.Node<T> x) {
        DoublyLinkedList.Node<T> prevX = x.prev;
        DoublyLinkedList.Node<T> nextX = x.next;
        prevX.next = x.next;
        nextX.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void removeTail(DoublyLinkedList.Node<T> x) {
        DoublyLinkedList.Node<T> prevX = x.prev;
        prevX.next = null;
        tail = prevX;
        x.prev = null;
    }

    private void removeHead(DoublyLinkedList.Node<T> x) {
        DoublyLinkedList.Node<T> nextX = x.next;
        nextX.prev = null;
        head = nextX;
        x.next = null;
    }

    /**
     * Phương thức sắp xếp danh sách liên kết theo thứ tự tăng dần.
     */
    public void sortList() {
        Node<T> current  = head;
        Node<T> index = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if(current.data.compareTo(index.data) > 0) {
                    T tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    /**
     * Phương thức sắp xếp danh sách liên kết theo thứ tự giảm dần.
     */
    public void sortListDESC() {
        Node<T> current  = head;
        Node<T> index = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if(current.data.compareTo(index.data) < 0) {
                    T tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}
