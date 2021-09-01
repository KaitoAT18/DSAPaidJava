package net.braniumacademy.lesson92.exercises3;

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
        var testCount = 1;
        while (t-- > 0) {
            var c = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine(); // đọc bỏ dòng thừa
            var str = scanner.nextLine();
            // viết thường các từ, sau đó tách từ tại vị trí có 1 hoặc nhiều dấu cách
            var words = str.toLowerCase().split("\\s+");
            var result = 0;
            for (var w : words) { // đọc các phần tử của mảng
                if(w.charAt(0) == c) {
                    result++;
                }
            }
            System.out.printf("%d\n", result);
        }
        scanner.close();
    }

    /**
     * Phương thức đếm số lần xuất hiện của giá trị x trong mảng
     *
     * @param arr mảng đích
     * @param x   giá trị cần tìm
     * @return số lần x xuất hiện trong mảng
     */
    private static int countX(int[] arr, float x) {
        int counter = 0;
        for (var e : arr) {
            if (e == x) {
                counter++;
            }
        }
        return counter;
    }
}
