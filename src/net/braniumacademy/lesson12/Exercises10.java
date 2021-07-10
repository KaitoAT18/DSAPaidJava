package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 *
 */

public class Exercises10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập cấp ma trận: ");
        var m = input.nextInt();
        var n = input.nextInt();
        var matrix = new int[m][n];
        fillMatrix(matrix);
        System.out.println("Ma trận A: ");
        onScreen(matrix);
    }

    /**
     * Phương thức hiển thị ma trận lên màn hình
     *
     * @param matrix ma trận chứa các phần tử cần hiển thị
     */
    private static void onScreen(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Phương thức điền giá trị cho ma trận. Nhận thấy rằng
     * phần tử tại vị trí [i, j] trong ma trận là phần dư của (i + j) % 2
     *
     * @return mảng 2 chiều sau khi nhập
     */
    private static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + j) % 2;
            }
        }
    }
}
