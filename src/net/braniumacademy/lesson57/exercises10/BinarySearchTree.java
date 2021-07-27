package net.braniumacademy.lesson57.exercises10;

public class BinarySearchTree<T extends Number> {
    private Node<T> root;

    public int removeNodes() {
        var leftmost = leftmostLeafNode(root.leftNode);
        var rightmost = rightmostLeafNode(root.rightNode);
        if (leftmost != null) {
            remove(leftmost);
        }
        if (rightmost != null) {
            remove(rightmost);
        }
        var count = 0;
        if (leftmost != null && rightmost != null) {
            count = 2;
        } else if (leftmost != null || rightmost != null) {
            count = 1;
        }
        return count;
    }

    private T rightmostLeafNode(Node<T> r) {
        if (r == null) {
            return null; // end game
        }
        if (r.leftNode == null && r.rightNode == null) {
            return r.data;
        }
        return leftmostLeafNode(r.rightNode);
    }

    private T leftmostLeafNode(Node<T> r) {
        if (r == null) {
            return null; // end game
        }
        if (r.leftNode == null && r.rightNode == null) {
            return r.data;
        }
        return leftmostLeafNode(r.leftNode);
    }

    static class Node<T extends Number> {
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
        } else if (r.data.intValue() - t.intValue() > 0) {
            r.leftNode = add(r.leftNode, t);
        } else if (r.data.intValue() - t.intValue() < 0) {
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
        if (x.intValue() - r.data.intValue() < 0) {
            r.leftNode = remove(r.leftNode, x);
        } else if (x.intValue() - r.data.intValue() > 0) {
            r.rightNode = remove(r.rightNode, x);
        } else {
            if (r.leftNode == null) {
                r = r.rightNode;
            } else if (r.rightNode == null) {
                r = r.leftNode;
            } else {
                r.data = findMinNode(r.rightNode);
                r.rightNode = remove(r.rightNode, r.data);
            }
        }
        return r;
    }

    private T findMinNode(Node<T> r) {
        while (r.leftNode != null) {
            r = r.leftNode;
        }
        return r.data;
    }
}
