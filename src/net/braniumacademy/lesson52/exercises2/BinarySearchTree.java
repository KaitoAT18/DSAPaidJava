package net.braniumacademy.lesson52.exercises2;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    static class Node<T> {
        private Node<T> leftNode;
        private Node<T> rightNode;
        private T data;

        public Node(T data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    // thêm node, sử dụng đệ quy
    public void add(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> r, T t) {
        if (r == null) {
            return new Node<>(t);
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = insert(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = insert(r.rightNode, t);
        }
        return r;
    }

    // thêm node sử dụng vòng lặp
    public void addNewNodeUsingLoop(T t) {
        Node<T> newNode = new Node<>(t);
        if (root == null) { // nếu cây rỗng
            root = newNode;
        } else { // nếu cây k rỗng
            Node<T> p = root;
            while (true) { // lặp chừng nào chưa tìm được vị trí của node mới
                if (p.data.compareTo(t) <= 0) { // nếu node mới nằm bên phải
                    if (p.rightNode != null) {
                        p = p.rightNode;
                    } else { // tìm được vị trí của node mới
                        p.rightNode = newNode; // gán node mới vào
                        break; // kết thúc
                    }
                } else {
                    if (p.leftNode != null) {
                        p = p.leftNode;
                    } else { // gán node mới vào đúng vị trí,
                        p.leftNode = newNode;
                        break; // kết thúc
                    }
                }
            }
        }
    }

    // in-order
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            System.out.print(r.data + " ");
            inOrder(r.rightNode);
        }
    }
}
