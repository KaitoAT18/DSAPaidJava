package net.braniumacademy.lesson94.exercises3;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    static class Node<T> {
        private T data;
        private int occurent;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
            occurent = 1;
        }
    }

    public void add(T data) {
        root = add(root, data);
    }

    private Node<T> add(Node<T> r, T data) {
        if (r == null) {
            return new Node<>(data);
        }
        if (r.data.compareTo(data) == 0) {
            r.occurent++;
        } else if (r.data.compareTo(data) > 0) {
            r.leftNode = add(r.leftNode, data);
        } else {
            r.rightNode = add(r.rightNode, data);
        }
        return r;
    }

    public int search(T x) {
        return search(root, x);
    }

    private int search(Node<T> r, T x) {
        if (r == null) {
            return 0;
        }
        if (r.data.compareTo(x) == 0) {
            return r.occurent;
        } else if (r.data.compareTo(x) > 0) {
            return search(r.leftNode, x);
        } else {
            return search(r.rightNode, x);
        }
    }
}
