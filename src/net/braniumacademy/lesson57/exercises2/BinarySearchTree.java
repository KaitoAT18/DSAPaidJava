package net.braniumacademy.lesson57.exercises2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public int removeLeafNodes() {
        List<T> leafNodes = new ArrayList<>();
        findLeafNodes(root, leafNodes);
        for (var e : leafNodes) {
            remove(e);
        }
        return leafNodes.size();
    }

    private void findLeafNodes(Node<T> r, List<T> leafNodes) {
        if (r == null) {
            return; // end game
        }
        if (r.leftNode == null && r.rightNode == null) {
            leafNodes.add(r.data);
        }
        findLeafNodes(r.leftNode, leafNodes);
        findLeafNodes(r.rightNode, leafNodes);
    }

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

    public boolean isEmpty() {
        return root == null;
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

    // xóa node có giá trị bằng x
    public void remove(T x) {
        root = remove(root, x);
    }

    private Node<T> remove(Node<T> r, T x) {
        if (r == null) {
            return null;
        }
        if (x.compareTo(r.data) < 0) {
            r.leftNode = remove(r.leftNode, x);
        } else if (x.compareTo(r.data) > 0) {
            r.rightNode = remove(r.rightNode, x);
        } else {
            if (r.leftNode == null) {
                r = r.rightNode;
            } else if (r.rightNode == null) {
                r = r.leftNode;
            } else {
                r.data = findMinNode(r.rightNode, x);
                r.rightNode = remove(r.rightNode, r.data);
            }
        }
        return r;
    }

    private T findMinNode(Node<T> r, T x) {
        while (r.leftNode != null) {
            r = r.leftNode;
        }
        return r.data;
    }
}
