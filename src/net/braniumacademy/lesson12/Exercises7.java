package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises7 {
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
     * @param triangle mảng chứa hình tam giác số đối xứng cần vẽ
     */
    private static void fillTriangle(String[][] triangle) {
        // vẽ tam giác cân đặc bằng các chữ số theo nguyên lý:
        // lấy đối xứng qua cột h, j, i bắt đầu từ 1
        // trên hàng thứ i vẽ số tại các vị trí từ h-i+1 đến h+i-1
        // giá trị in ra trên cột j là i-|h-j|. Các vị trí còn lại
        // vẽ khoảng trắng
        var h = triangle.length;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < 2 * h; j++) {
                if (j >= h - i + 1 && j <= h + i - 1) {
                    triangle[i - 1][j - 1] = " " + (i - Math.abs(h - j)) + " ";
                } else {
                    triangle[i - 1][j - 1] = "   ";
                }
            }
        }
    }
}
