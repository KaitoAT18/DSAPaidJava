package net.braniumacademy.lesson94.exercises3;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt(); // số bộ test t
        while (t-- > 0) {
            var x = scanner.next().toLowerCase();
            scanner.nextLine(); // đọc bỏ dòng thừa
            var str = scanner.nextLine();
            // viết thường các từ, sau đó tách từ tại vị trí có 1 hoặc nhiều dấu cách
            var words = str.toLowerCase().split("\\s+");
            var tree = new BinarySearchTree<String>();
            for (var e : words) {
                tree.add(e);
            }
            var result = tree.search(x);
            System.out.printf("%d\n", result);
        }
        scanner.close();
    }
}
