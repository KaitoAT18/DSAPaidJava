package net.braniumacademy.lesson25.exercises3;

public class LinkedList {
    private Node<Student> head;
    private Node<Student> tail;

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

    public boolean isEmpty() {
        return head == null;
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
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    /**
     * Phương thức cập nhật dữ liệu cho node
     *
     * @param target  node chứa dữ liệu mục tiêu cần tìm
     * @param newData dữ liệu mới cần cập nhật vào node
     * @return true nếu cập nhật thành công và false nếu ngược lại
     */
    public boolean updateNodeData(Node target, Student newData) {
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
        return removeSwitcher(x, prevX);
    }

    // xóa sinh viên có tên name
    public boolean removeStudentByName(String name) {
        Node<Student> x = head;
        Node<Student> prevX = head;
        while (x != null) {
            if (x.data.getFullName().equals(name)) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    // xóa sinh viên có điểm < gpa
    public boolean removeStudentByGPA(float gpa) {
        Node<Student> x = head;
        Node<Student> prevX = head;
        while (x != null) {
            if (x.data.getGpa() < gpa) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    // xóa sinh viên có tuổi bằng x
    public boolean removeStudentByAge(int age) {
        Node<Student> x = head;
        Node<Student> prevX = head;
        while (x != null) {
            if (x.data.getAge() == age) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    private boolean removeSwitcher(Node<Student> x, Node<Student> prevX) {
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
}
