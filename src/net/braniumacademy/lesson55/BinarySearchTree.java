package net.braniumacademy.lesson55;

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

    public void add(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> r, T t) {
        if (r == null) {
            return new Node<>(t);
        } else if (r.data.compareTo(t) >= 0) {
            r.leftNode = insert(r.leftNode, t);
        } else {
            r.rightNode = insert(r.rightNode, t);
        }
        return r;
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

    // tìm kiếm node có giá trị x
    public boolean search(T x) {
        return search(root, x);
    }

    private boolean search(Node<T> r, T x) {
        if (r == null) { // nếu r không tồn tại
            return false; // return false
        }
        if (x.compareTo(r.data) == 0) { // nếu tìm thấy node có giá trị bằng x
            return true;
        }
        if (r.data.compareTo(x) < 0) { // nếu r.data < x
            return search(r.rightNode, x); // tìm x bên cây con phải
        }
        if (r.data.compareTo(x) > 0) { // nếu r.data > x
            return search(r.leftNode, x); // tìm x bên cây con trái
        }
        return false; // mặc định không tìm thấy x
    }


}
