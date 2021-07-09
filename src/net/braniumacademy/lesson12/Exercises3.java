package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @website https://braniumacademy.net/
 * @version 2021.07
 */

public class Exercises3 {
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
            for (int j = 0; j < triangle.length; j++) {
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
        // vẽ tam giác theo hướng: trên hàng thứ i in ra i-1 khoảng trắng
        // sau đó trên hàng thứ i in ra h-i+1 dấu *. Do vuông góc phải trên
        // nên ta in ra giá trị dấu cách nếu chỉ số cột < chỉ số hàng
        var h = triangle.length;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= h; j++) {
                if (j < i) {
                    triangle[i - 1][j - 1] = "   ";
                } else {
                    triangle[i - 1][j - 1] = " * ";
                }
            }
        }
    }
}
