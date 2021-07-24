package net.braniumacademy.lesson56;

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

    // thêm node vào cây
    public void add(T t) {
        root = add(root, t);
    }

    private Node<T> add(Node<T> r, T t) {
        if (r == null) {
            return new Node<>(t);
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = add(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = add(r.rightNode, t);
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
        if (r == null) {
            return false;
        }
        if (r.data.compareTo(x) == 0) {
            return true;
        } else if (r.data.compareTo(x) > 0) {
            return search(r.leftNode, x);
        } else if (r.data.compareTo(x) < 0) {
            return search(r.rightNode, x);
        }
        return false;
    }

    // đếm tổng số node trong cây BST
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNodes(r.leftNode) + countNodes(r.rightNode);
    }

    // đếm số lượng node lá của cây BST
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
