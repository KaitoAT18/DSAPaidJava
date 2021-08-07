package net.braniumacademy.lesson55;

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("One");
        tree.add("One");
        tree.add("One");
        tree.add("Four");
        tree.add("Two");
        tree.add("Two");
        tree.add("Five");
        tree.add("Five");
        tree.add("Seven");
        tree.add("Eight");
        tree.add("Nine");
        Scanner input = new Scanner(System.in);
        System.out.println("Các node trong cây: ");
        tree.inOrder();
        System.out.println("Các node có số lần xuất hiện nhiều nhất trong cây: ");
        tree.showMaxOccurrent();
        System.out.println("Các node có số lần xuất hiện ít nhất trong cây: ");
        tree.showMinOccurrent();
        System.out.println("Nhập biên dưới: ");
        int from = input.nextInt();
        System.out.println("Nhập biến trên: ");
        int to = input.nextInt();
        System.out.printf("Các node có số lần xuất hiện trong [%d, %d]:\n", from, to);
        tree.showNode(from, to);
        System.out.println();
    }

    static class BinarySearchTree<T extends Comparable<T>> {
        private Node<T> root;

        static class Node<T> {
            private Node<T> leftNode;
            private Node<T> rightNode;
            private T data;
            private int countNode;

            public Node(T data) {
                this.data = data;
                countNode = 1; // khởi tạo số lần xuất hiện của 1 node
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
            } else {
                r.countNode++; // nếu node này tồn tại trước đó, tăng số lần xuất hiện của nó lên
            }
            return r;
        }

        public void showNode(int from, int to) {
            showNode(root, from, to);
        }

        private void showNode(Node<T> r, int from, int to) {
            if (r != null) {
                showNode(r.leftNode, from, to);
                if (r.countNode >= from && r.countNode <= to) {
                    System.out.println(r.data + " - " + r.countNode);
                }
                showNode(r.rightNode, from, to);
            }
        }

        // in-order
        public void inOrder() {
            inOrder(root);
        }

        private void inOrder(Node<T> r) {
            if (r != null) {
                inOrder(r.leftNode);
                System.out.println(r.data + " - " + r.countNode);
                inOrder(r.rightNode);
            }
        }

        private int findMinOccurrent(Node<T> r) {
            if (r == null) {
                return 1;
            }
            int count = r.countNode;
            int countLeft = findMinOccurrent(r.leftNode);
            int countRight = findMinOccurrent(r.rightNode);
            return Math.min(count, Math.min(countRight, countLeft));
        }

        private void inOrderMinOccurent(Node<T> r, int min) {
            if (r != null) {
                inOrderMinOccurent(r.leftNode, min);
                if (r.countNode == min) {
                    System.out.println(r.data + " - " + r.countNode);
                }
                inOrderMinOccurent(r.rightNode, min);
            }
        }

        private void inOrderMaxOccurent(Node<T> r, int max) {
            if (r != null) {
                inOrderMaxOccurent(r.leftNode, max);
                if (r.countNode == max) {
                    System.out.println(r.data + " - " + r.countNode);
                }
                inOrderMaxOccurent(r.rightNode, max);
            }
        }

        // tìm kiếm node có giá trị x
        public boolean search(T x) {
            return search(root, x);
        }

        public void showMaxOccurrent() {
            if(root != null) {
                int maxOcc = findMaxOccurrent(root);
                inOrderMaxOccurent(root, maxOcc);
            }
        }

        public void showMinOccurrent() {
            if (root != null) {
                int min = findMinOccurrent(root);
                inOrderMinOccurent(root, min);
            }
        }

        private int findMaxOccurrent(Node<T> r) {
            if (r == null) {
                return 0;
            }
            int count = r.countNode;
            int countLeft = findMaxOccurrent(r.leftNode);
            int countRight = findMaxOccurrent(r.rightNode);
            return Math.max(count, Math.max(countRight, countLeft));
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

}
