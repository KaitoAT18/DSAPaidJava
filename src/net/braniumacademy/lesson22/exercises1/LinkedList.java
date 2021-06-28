package net.braniumacademy.lesson22.exercises1;

/**
 * Lớp mô tả danh sách liên kết chứa hai node head, tail
 *
 * @param <T> Kiểu dữ liệu của phần dữ liệu trong mỗi node
 */
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
    }

    // thêm node vào trước node có giá trị bằng x
    public void insertBeforeX(T data, T x) {
        if (isEmpty()) {
            return;
        }
        if (head.data == x) { // nếu node cần tìm là head,
            insertHead(data); // chèn node mới vào đầu dslk
        } else { // ngược lại, xét các vị trí khác
            Node<T> nodeX = head;
            Node<T> nodeBeforeX = head;
            // tìm node có giá trị bằng x
            while (nodeX != null) {
                if (nodeX.data == x) {
                    break; // tìm thấy node có giá trị bằng x, dừng việc tìm kiếm
                }
                // nếu không, tiếp tục tìm, đánh dấu node trước nodeX lại
                nodeBeforeX = nodeX; // trước khi cập nhật nodeX
                nodeX = nodeX.next;
            }
            // kiểm tra lại nếu nodeX khác null == tìm thấy node có giá trị bằng x
            if (nodeX != null) {
                Node<T> p = new Node<>(data);
                p.next = nodeX; // cập nhật next của p
                nodeBeforeX.next = p; // cập nhật node trước nodeX
            } else { // trường hợp không tìm thấy node có giá trị bằng X
                System.out.println("Không tìm thấy node có giá trị bằng " + x);
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    // chèn node mới sau node có giá trị x
    public void insertAfterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
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

    // chèn node sau node có vị trí k
    public void insertAfterK(T data, int k) {
        if (isEmpty()) {
            System.out.println("Danh sách liên kết rỗng!");
        } else if (k > 0) {
            int count = 1;
            Node<T> node = head;
            while (node != null) {
                if (count == k) {
                    break;
                }
                count++;
                node = node.next;
            }
            if (node != null) { // nếu tìm thấy node thứ k
                Node<T> p = new Node<>(data);
                p.next = node.next;
                node.next = p;
            } else {
                System.out.println("Không tìm thấy node thứ " + k);
            }
        } else {
            System.out.println("Giá trị vị trí k = " + k + " không hợp lệ.");
        }
    }

    // tìm node giữa của danh sách liên kết
    private Node<T> findMidNode() {
        Node<T> currentNode = head;
        Node<T> midNode = head;
        while (currentNode != null && currentNode.next != null && currentNode.next.next != null) {
            currentNode = currentNode.next.next;
            midNode = midNode.next;
        }
        return midNode;
    }

    // tìm node chính giữa của danh sách liên kết
    public T findMidNodeData() {
        Node<T> midNode = findMidNode();
        return midNode == null ? null : midNode.data;
    }

    // thêm node vào sau node giữa danh sách liên kết
    public void insertAfterMidNode(T data) {
        Node<T> midNode = findMidNode();
        Node<T> p = new Node<>(data);
        p.next = midNode.next;  // cập nhật next của p
        midNode.next = p;       // cập nhật next của node giữa
    }

    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }
}
