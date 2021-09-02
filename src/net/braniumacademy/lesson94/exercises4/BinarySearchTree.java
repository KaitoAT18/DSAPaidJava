package net.braniumacademy.lesson94.exercises4;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }

    public void add(T data) {
        root = add(root, data);
    }

    private Node<T> add(Node<T> r, T data) {
        if (r == null) {
            return new Node<>(data);
        }
        if (r.data.compareTo(data) > 0) {
            r.leftNode = add(r.leftNode, data);
        } else if (r.data.compareTo(data) <= 0) {
            r.rightNode = add(r.rightNode, data);
        }
        return r;
    }

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
        } else {
            return search(r.rightNode, x);
        }
    }
}
