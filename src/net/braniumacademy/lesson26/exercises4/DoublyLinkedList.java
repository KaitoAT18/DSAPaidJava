package net.braniumacademy.lesson26.exercises4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    static class Node {
        private BankAccount data;
        private Node next;
        private Node prev;

        public Node(BankAccount data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public BankAccount getData() {
            return data;
        }

        public void setData(BankAccount data) {
            this.data = data;
        }
    }

    public void insertHead(BankAccount data) {
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

    public void insertTail(BankAccount data) {
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

    public void insertAfterX(BankAccount data, BankAccount x) {
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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (Node node = head; node != null; node = node.next) {
            System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20d\n",
                    node.data.getOwner(), node.data.getCardNumber(),
                    node.data.getAccountNumber(), node.data.getCardType(),
                    node.data.getBankName(), format.format(node.data.getStartDate()),
                    format.format(node.data.getEndDate()), node.data.getBallance());
        }
        System.out.println("null");
    }

    public void traversalFromTail() {
        for (Node node = tail; node != null; node = node.prev) {
            System.out.println(node.data);
        }
    }

    // xóa tài khoản theo số dư
    public boolean removeByBallance(long ballance) {
        Node x = head;
        while (x != null) {
            if (x.data.getBallance() < (ballance)) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }

    // xóa sinh tài khoản hết hạn vào ngày hôm nay
    public boolean removeByEndDate() {
        Date endDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String endDateString = format.format(endDate);
        Node x = head;
        while (x != null) {
            if (format.format(x.data.getEndDate()).equals(endDateString)) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }

    // xóa tài khoản theo tên ngân hàng
    public boolean removeByBankName(String bankName) {
        Node x = head;
        while (x != null) {
            if (x.data.getBankName().equals(bankName)) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }
    // xóa tài khoản theo số tài khoản hoặc số thẻ
    public boolean removeNode(BankAccount data) {
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
        if (x == null) {
            return false;
        } else {
            if (x == head) {
                removeHead(x);
            } else if (x == tail) {
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
        if (nextX != null) {
            nextX.prev = null;
        }
        head = nextX;
        x.next = null;
    }
}
