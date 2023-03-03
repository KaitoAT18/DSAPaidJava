package net.braniumacademy.lesson55;

/**
 * @author Branium Academy
 * @version 2023.03
 * @see https://braniumacademy.net
 */

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.add("One");
        tree.add("One");
        tree.add("Four");
        tree.add("Four");
        tree.add("Two");
        tree.add("Two");
        tree.add("Five");
        tree.add("Five");
        tree.add("Seven");
        tree.add("Seven");
        tree.add("Eight");
        tree.add("Eight");
        tree.add("Nine");
        tree.add("Nine");
        Scanner input = new Scanner(System.in);
        System.out.println("Các node trong cây: ");
        tree.inOrder();
        System.out.println("Các node có số lần xuất hiện nhiều nhất trong cây: ");
        tree.showMaxOccurrence();
        System.out.println("Các node có số lần xuất hiện ít nhất trong cây: ");
        tree.showMinOccurrence();
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
            private final T data;
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

        private int findMinOccurrence(Node<T> r) {
            if (r == null) {
                return 0;
            } else if (r.leftNode == null && r.rightNode == null) {
                return r.countNode;
            } else {
                int count = r.countNode;
                int countLeft = count;
                if (r.leftNode != null) {
                    countLeft = findMinOccurrence(r.leftNode);
                }
                int countRight = count;
                if (r.rightNode != null) {
                    countRight = findMinOccurrence(r.rightNode);
                }
                return Math.min(count, Math.min(countRight, countLeft));
            }
        }

        private void inOrderMinOccurrence(Node<T> r, int min) {
            if (r != null) {
                inOrderMinOccurrence(r.leftNode, min);
                if (r.countNode == min) {
                    System.out.println(r.data + " - " + r.countNode);
                }
                inOrderMinOccurrence(r.rightNode, min);
            }
        }

        private void inOrderMaxOccurrence(Node<T> r, int max) {
            if (r != null) {
                inOrderMaxOccurrence(r.leftNode, max);
                if (r.countNode == max) {
                    System.out.println(r.data + " - " + r.countNode);
                }
                inOrderMaxOccurrence(r.rightNode, max);
            }
        }

        public void showMaxOccurrence() {
            if (root != null) {
                int maxOcc = findMaxOccurrence(root);
                inOrderMaxOccurrence(root, maxOcc);
            }
        }

        public void showMinOccurrence() {
            if (root != null) {
                int min = findMinOccurrence(root);
                inOrderMinOccurrence(root, min);
            }
        }

        private int findMaxOccurrence(Node<T> r) {
            if (r == null) { // nếu cây rỗng => không có gì cả
                return 0;
            } else if (r.leftNode == null && r.rightNode == null) { // nếu node r là node lá
                return r.countNode;
            } else {
                int count = r.countNode;
                int countLeft = count;
                if (r.leftNode != null) { // nếu có cành trái
                    countLeft = findMaxOccurrence(r.leftNode); // tìm max ở cành trái
                }
                int countRight = count;
                if (r.rightNode != null) { // nếu có cành phải
                    countRight = findMaxOccurrence(r.rightNode); // tìm max ở cành phải
                }
                return Math.max(count, Math.max(countRight, countLeft));
            }
        }
    }
}
