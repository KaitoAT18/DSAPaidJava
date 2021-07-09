package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập chiều cao tam giác: ");
        var h = input.nextInt();
        // mảng lưu kết quả
        var triangle = new String[h][2 * h - 1];
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
            for (int j = 0; j < 2 * triangle.length - 1; j++) {
                System.out.print(triangle[i][j]); // in ra giá trị trong mảng
            }
            System.out.println(); // in xuống dòng
        }
    }

    /**
     * Phương thức điền kí tự * và khoảng trắng vào mảng
     *
     * @param triangle mảng chứa hình tam giác cân rỗng cần vẽ
     */
    private static void fillTriangle(String[][] triangle) {
        // vẽ tam giác cân rỗng bằng các dấu *
        // nguyên lý: vẽ dấu * đối xứng qua cột h, i, j bắt đầu từ 1
        // trên hàng thứ i vẽ dấu * tại vị trí h-i+1 và h+i-1
        // các vị trí còn lại vẽ khoảng trắng. Riêng hàng cuối vẽ dấu *
        var h = triangle.length;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < 2 * h; j++) {
                if (i == h || j == h - i + 1 || j == h + i - 1) {
                    triangle[i - 1][j - 1] = " * ";
                } else {
                    triangle[i - 1][j - 1] = "   ";
                }
            }
        }
    }
}
