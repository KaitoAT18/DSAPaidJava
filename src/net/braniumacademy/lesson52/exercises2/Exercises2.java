package net.braniumacademy.lesson52.exercises2;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
    public static void main(String[] args) {
        System.out.println("Nhập vào một chuỗi kí tự: ");
        var input = new Scanner(System.in);
        var str = input.nextLine();
        var words = str.split("\\s+"); // tách từ tại vị trí có 1 hoặc nhiều dấu cách
        // \\s+ là biểu thức chính quy, bạn có thể xem lại trong khóa học lập trình java
        // hoặc google search nhé, ahihi..
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        for (var e : words) {
            tree.add(e);
        }
        System.out.println("Các từ sau khi sắp xếp: ");
        tree.inOrder();
    }
}
