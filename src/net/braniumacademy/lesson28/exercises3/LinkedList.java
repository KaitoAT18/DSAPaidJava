package net.braniumacademy.lesson28.exercises3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public class LinkedList implements Iterable<Student> { // cho phép sử dụng foreach với đối tượng của lớp
    private Node<Student> head;
    private Node<Student> tail;

    @Override
    public Iterator<Student> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Student> {
        private Node<Student> node = head;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Student next() {
            Node<Student> p = node;
            node = node.next;
            return p.data;
        }
    }

    static class Node<Student> {
        private Student data;
        private Node<Student> next;

        public Node(Student data) {
            this.data = data;
            this.next = null;
        }

        public Student getData() {
            return data;
        }
    }

    public void insertHead(Student data) {
        Node<Student> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertTail(Student data) {
        Node<Student> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    // chèn vào sau node có giá trị x
    public void insertAfterX(Student data, Student x) {
        Node<Student> p = new Node<>(data);
        Node<Student> nodeX = head;
        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null) {
            p.next = nodeX.next;
            nodeX.next = p;
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10d%-15.2f\n",
                    node.getData().getId(), node.getData().getLastName(),
                    node.getData().getMidName(), node.getData().getFirstName(),
                    node.getData().getAddress(), node.getData().getEmail(),
                    node.getData().getAge(), node.getData().getGpa());
        }
    }

    /**
     * Phương thức cập nhật dữ liệu cho node
     *
     * @param target  node chứa dữ liệu mục tiêu cần tìm
     * @param newData dữ liệu mới cần cập nhật vào node
     * @return true nếu cập nhật thành công và false nếu ngược lại
     */
    public boolean updateNodeData(Node<Student> target, Student newData) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)) {
                node.data = newData;
                return true;
            }
        }
        return false; // cập nhật thất bại
    }

    /**
     * Phương thức xóa một node khỏi danh sách liên kết đơn.
     *
     * @param data dữ liệu của node cần xóa
     * @return true nếu xóa thành công và false nếu ngược lại
     */
    public boolean removeNode(Student data) {
        Node<Student> x = head;
        Node<Student> prevX = head;
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
            } else { // xóa x, x là node (head, tail)
                prevX.next = x.next;
                x.next = null;
            }
            return true; // xóa node thành công
        } else {
            return false; // xóa thất bại
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Phương thức sắp xếp danh sách liên kết theo thứ tự tăng dần.
     */
    public void sortList(Comparator<Student> comparator) {
        Node<Student> current = head;
        Node<Student> index = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (comparator.compare(current.data, index.data) > 0) {
                    Student tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public Student search(String id) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                return node.data;
            }
        }
        return null;
    }
}
