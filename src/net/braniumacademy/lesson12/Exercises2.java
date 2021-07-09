package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @website https://braniumacademy.net/
 * @version 2021.07
 */

public class Exercises2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập chiều cao tam giác: ");
        var h = input.nextInt();
        // mảng lưu kết quả
        var triangle = new String[h][h];
        // vẽ tam giác
        fillTriangle(triangle);
        // hiện kết quả lên màn hình
        onScreen(triangle);
    }

    /**
     * Phương thức vẽ lên màn hình các giá trị trong mảng
     *
     * @param triangle mảng chứa dữ liệu cần hiển thị lên màn hình
     */
    private static void onScreen(String[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle.length - i; j++) {
                System.out.print(triangle[i][j]); // in ra giá trị trong mảng
            }
            System.out.println(); // in xuống dòng
        }
    }

    /**
     * Phương thức điền kí tự * và khoảng trắng vào mảng
     *
     * @param triangle mảng chứa hình tam giác vuông cần vẽ
     */
    private static void fillTriangle(String[][] triangle) {
        // vẽ hình
        // vẽ tam giác theo hướng: hàng thứ 1 in ra h dấu *
        // từ hàng thứ 2 bắt đầu giảm đi mỗi hàng 1 dấu *
        // so với hàng trước nó
        var h = triangle.length; // chiều cao tam giác bằng số hàng
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= h - i + 1; j++) {
                triangle[i - 1][j - 1] = " * ";
            }
        }
    }
}
