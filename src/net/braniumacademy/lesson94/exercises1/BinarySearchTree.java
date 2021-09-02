package net.braniumacademy.lesson94.exercises1;

public class BinarySearchTree {
    private Node root;

    static class Node {
        private float data;
        private Node leftNode;
        private Node rightNode;

        public Node(float data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }

    public void add(float data) {
        root = add(root, data);
    }

    private Node add(Node r, float data) {
        if (r == null) {
            return new Node(data);
        }
        if (r.data > data) {
            r.leftNode = add(r.leftNode, data);
        } else if (r.data - data <= 0) {
            r.rightNode = add(r.rightNode, data);
        }
        return r;
    }

    public boolean search(float x) {
        return search(root, x);
    }

    private boolean search(Node r, float x) {
        if (r == null) {
            return false;
        }
        if (r.data - x == 0) {
            return true;
        } else if (r.data - x > 0) {
            return search(r.leftNode, x);
        } else {
            return search(r.rightNode, x);
        }
    }
}
