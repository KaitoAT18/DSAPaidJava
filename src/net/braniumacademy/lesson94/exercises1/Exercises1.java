package net.braniumacademy.lesson94.exercises1;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt(); // số bộ test t
        var testCount = 1;
        while (t-- > 0) {
            var n = scanner.nextInt();
            var x = scanner.nextFloat();
            BinarySearchTree tree = new BinarySearchTree();
            for (int i = 0; i < n; i++) { // đọc các phần tử của mảng
                var value = scanner.nextFloat();
                tree.add(value);
            }
            var result = tree.search(x);
            System.out.printf("Test %d: ", testCount++);
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
