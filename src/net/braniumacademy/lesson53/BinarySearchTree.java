package net.braniumacademy.lesson53;

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
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = insert(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = insert(r.rightNode, t);
        }
        return r;
    }

    // pre-order
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preOrder(r.leftNode);
            preOrder(r.rightNode);
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

    // duyệt node RNL
    public void inOrderRNL() {
        inOrderRNL(root);
    }

    private void inOrderRNL(Node<T> r) {
        if (r != null) {
            inOrder(r.rightNode);
            System.out.print(r.data + " ");
            inOrder(r.leftNode);
        }
    }

    // duyệt node LRN
    public void traversalLRN() {
        traversalLRN(root);
    }

    private void traversalLRN(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            inOrder(r.rightNode);
            System.out.print(r.data + " ");
        }
    }

    // duyệt node RLN
    public void traversalRLN() {
        traversalRLN(root);
    }

    private void traversalRLN(Node<T> r) {
        if (r != null) {
            inOrder(r.rightNode);
            inOrder(r.leftNode);
            System.out.print(r.data + " ");
        }
    }

    // duyệt node NLR
    public void traversalNLR() {
        traversalNLR(root);
    }

    private void traversalNLR(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            inOrder(r.leftNode);
            inOrder(r.rightNode);
        }
    }

    // duyệt node NRL
    public void traversalNRL() {
        traversalNRL(root);
    }

    private void traversalNRL(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            inOrder(r.rightNode);
            inOrder(r.leftNode);
        }
    }

    // post-order
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> r) {
        if (r != null) {
            postOrder(r.leftNode);
            postOrder(r.rightNode);
            System.out.print(r.data + " ");
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
        if (x == r.data) { // nếu tìm thấy node có giá trị bằng x
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

    public int countNode() {
        return countNode(root);
    }

    private int countNode(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNode(r.leftNode) + countNode(r.rightNode);
    }

    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node<T> r) {
        if (r == null) {
            return 0;
        }
        if (r.leftNode == null && r.rightNode == null) {
            return 1;
        }
        return countLeafNodes(r.leftNode) + countLeafNodes(r.rightNode);
    }
}
