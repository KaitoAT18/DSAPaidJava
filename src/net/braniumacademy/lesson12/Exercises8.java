package net.braniumacademy.lesson12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises8 {
    public static void main(String[] args) {
        // nhập vào ma trận
        var matrix = getMatrix();
        // tìm giá trị max
        int max = findMax(matrix);
        System.out.println("Các phần tử trong ma trận là: ");
        onScreen(matrix);
        // hiển thị giá trị max và vị trí
        System.out.println("Giá trị max trong ma trận: " + max);
        System.out.println("Các vị trí xuất hiện max: ");
        showPosition(matrix, max);
    }

    /**
     * Phương thức hiện vị trí các phần tử max trong ma trận
     *
     * @param matrix ma trận đầu vào
     * @param max    giá trị max tìm được trong ma trận
     */
    private static void showPosition(int[][] matrix, int max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == max) {
                    System.out.printf("(%d, %d); ", i, j);
                }
            }
        }
        System.out.println();
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
     * Phương thức tìm giá trị lớn nhất trong ma trận.
     *
     * @param matrix ma trận đầu vào
     * @return giá trị lớn nhất trong ma trận
     */
    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Phương thức dùng để nhập vào các phần tử cho mảng hai chiều và trả
     * về mảng sau khi nhập
     *
     * @return mảng sau khi nhập
     */
    private static int[][] getMatrix() {
        var input = new Scanner(System.in);
        System.out.println("Nhập cấp ma trận: ");
        var m = input.nextInt();
        var n = input.nextInt();
        var matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }
}
