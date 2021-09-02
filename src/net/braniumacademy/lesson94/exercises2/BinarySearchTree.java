package net.braniumacademy.lesson94.exercises2;

public class BinarySearchTree {
    private Node root;

    static class Node {
        private int data;
        private int occurent;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
            occurent = 1;
        }
    }

    public void add(int data) {
        root = add(root, data);
    }

    private Node add(Node r, int data) {
        if (r == null) {
            return new Node(data);
        }
        if (r.data == data) {
            r.occurent++;
        } else if (r.data > data) {
            r.leftNode = add(r.leftNode, data);
        } else {
            r.rightNode = add(r.rightNode, data);
        }
        return r;
    }

    public int search(int x) {
        return search(root, x);
    }

    private int search(Node r, int x) {
        if (r == null) {
            return 0;
        }
        if (r.data - x == 0) {
            return r.occurent;
        } else if (r.data - x > 0) {
            return search(r.leftNode, x);
        } else {
            return search(r.rightNode, x);
        }
    }
}
