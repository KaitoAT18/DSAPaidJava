package net.braniumacademy.lesson14;

import java.util.Scanner;

public class Exercises12 {
    public static void main(String[] args) {
        int[][] arr;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số hàng, cột: ");
        int row = input.nextInt();
        arr = new int[row][row];
        int centerRowIndex = (row - 1) / 2;
        int centerColIndex = (row - 1) / 2;
        int rowNext = centerRowIndex + 1;
        int colNext = centerColIndex + 1;
        int rowPrev = centerRowIndex;
        int colPrev = centerColIndex;
        int value = 1;
        arr[centerColIndex][centerRowIndex] = value++;
        int bound = row * row;
        createSpiralMatrix(arr, rowPrev, rowNext, colPrev, colNext, value, bound);
        showResult(arr);
    }

    /**
     * Phương thức hiển thị các phần tử mảng hai chiều.
     *
     * @param arr mảng chứa nội dung cần hiển thị.
     */
    private static void showResult(int[][] arr) {
        for (var row : arr) {
            for (var e : row) {
                System.out.printf("%5d", e);
            }
            System.out.println("\n");
        }
    }

    /**
     * Phương thức dùng để vẽ ma trận xoắn ốc cấp m x m.
     *
     * @param a       ma trận kết quả cấp m x n
     * @param rowPrev chỉ số hàng trên top
     * @param rowNext chỉ số hàng bottom
     * @param colPrev chỉ số cột left
     * @param colNext chỉ số cột right
     * @param value   giá trị để gán cho từng phần tử trong ma trận
     * @param bound   biên giới hạn giá trị gán cho phần tử ma trận xoắn ốc
     */
    static void createSpiralMatrix(int[][] a, int rowPrev, int rowNext,
                                   int colPrev, int colNext, int value, int bound) {
        if (value >= bound) {
            return;
        }
        for (int i = colPrev + 1; i <= colNext; ++i) { // vẽ hàng top
            if (rowPrev >= 0 && i < a.length)
                a[rowPrev][i] = value++;
        }
        colPrev--;
        if (colNext < a.length) {
            for (int i = rowPrev + 1; i <= rowNext; ++i) { // vẽ cột right
                if (i < a.length)
                    a[i][colNext] = value++;
            }
        }
        rowPrev--;
        if (rowNext < a.length) {
            for (int i = colNext - 1; i >= colPrev; --i) { // vẽ hàng bottom
                if (i >= 0)
                    a[rowNext][i] = value++;
            }
        }
        colNext++;
        if (colPrev >= 0) {
            for (int i = rowNext - 1; i >= rowPrev; --i) { // vẽ cột left
                if (i >= 0)
                    a[i][colPrev] = value++;
            }
        }
        rowNext++;
        createSpiralMatrix(a, rowPrev, rowNext, colPrev, colNext, value, bound);
    }
}
