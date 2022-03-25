package net.braniumacademy.lesson25.exercises2;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }

    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if(head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if(head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }
    // chèn vào sau node có giá trị x
    public void insertAfterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX != null) {
            if(nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        if(nodeX != null) {
            p.next = nodeX.next;
            nodeX.next = p;
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    /**
     * Phương thức cập nhật dữ liệu cho node
     * @param target node chứa dữ liệu mục tiêu cần tìm
     * @param newData dữ liệu mới cần cập nhật vào node
     * @return true nếu cập nhật thành công và false nếu ngược lại
     */
    public boolean updateNodeData(Node target, T newData) {
        for (var node = head; node != null; node = node.next) {
            if(node.data.equals(target.data)) {
                node.data = newData;
                return true;
            }
        }
        return false; // cập nhật thất bại
    }

    /**
     * Phương thức xóa một node khỏi danh sách liên kết đơn.
     * @param data dữ liệu của node cần xóa
     * @return true nếu xóa thành công và false nếu ngược lại
     */
    public boolean removeNode(T data) {
        Node<T> x = head;
        Node<T> prevX = head;
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        if (x != null) {
            // xóa x, x là node head
            if (x == head) {
                head = x.next;
                x.next = null;
            } else if (x == tail) { // xóa x, x là node tail
                prevX.next = x.next;
                tail = prevX;
            } else { // xóa x, x là node khác head, tail
                prevX.next = x.next;
                x.next = null;
            }
            return true; // xóa node thành công
        } else {
            return false; // xóa thất bại
        }
    }
}
