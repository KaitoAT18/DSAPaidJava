package net.braniumacademy.lesson26.exercises3;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    static class Node {
        private Student data;
        private Node next;
        private Node prev;

        public Node(Student data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Student getData() {
            return data;
        }

        public void setData(Student data) {
            this.data = data;
        }
    }

    public void insertHead(Student data) {
        Node p = new Node(data);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            p.next = head; // next của p chính là head cũ
            head.prev = p; // prev của head cũ là p
            head = p;      // cập nhật head mới
        }
    }

    public void insertTail(Student data) {
        Node p = new Node(data);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            tail.next = p;  // next của tail cũ là p
            p.prev = tail;  // prev của p là tail cũ
            tail = p;       // cập nhật lại tail mới
        }
    }

    public void insertAfterX(Student data, Student x) {
        Node p = new Node(data);
        Node nodeX = head;
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
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public void traversalFromTail() {
        for (Node node = tail; node != null; node = node.prev) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }
    // xóa sinh viên có tên name
    public boolean removeStudentByName(String name) {
        Node x = head;
        while (x != null) {
            if (x.data.getFullName().equals(name)) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }
    // xóa sinh viên có điểm < gpa
    public boolean removeStudentByGPA(float gpa) {
        Node x = head;
        while (x != null) {
            if(x.data.getGpa() < gpa) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }
    // xóa sinh viên có tuổi bằng x
    public boolean removeStudentByAge(int age) {
        Node x = head;
        while (x != null) {
            if(x.data.getAge() == age) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }

    public boolean removeNode(Student data) {
        Node x = head;
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            x = x.next;
        }
        // kiểm tra
        return removeSwitcher(x);
    }

    private boolean removeSwitcher(Node x) {
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

    private void remove(Node x) {
        Node prevX = x.prev;
        Node nextX = x.next;
        prevX.next = x.next;
        nextX.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void removeTail(Node x) {
        Node prevX = x.prev;
        prevX.next = null;
        tail = prevX;
        x.prev = null;
    }

    private void removeHead(Node x) {
        Node nextX = x.next;
        if(nextX != null) {
            nextX.prev = null;
        }
        head = nextX;
        x.next = null;
    }
}
