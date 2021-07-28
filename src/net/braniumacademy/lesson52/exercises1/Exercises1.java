package net.braniumacademy.lesson52.exercises1;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises1 {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        // thêm node mới sử dụng vòng lặp
        tree.addNewNodeUsingLoop("One");
        tree.addNewNodeUsingLoop("Two");
        tree.addNewNodeUsingLoop("Three");
        tree.addNewNodeUsingLoop("Four");
        tree.addNewNodeUsingLoop("Five");
        tree.addNewNodeUsingLoop("Six");
        // thêm node sử dụng đệ quy
        tree.add("Seven");
        tree.add("Eight");
        tree.add("Nine");
        // in ra kết quả
        System.out.println("Các node trong cây: ");
        tree.inOrder();
    }
}
