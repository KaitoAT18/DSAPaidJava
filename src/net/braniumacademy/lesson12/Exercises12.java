package net.braniumacademy.lesson12;

import java.util.Scanner;

public class Exercises12 {
    public static void main(String[] args) {
        int[][] arr;
        int row;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số hàng, cột: ");
        row = input.nextInt();
        arr = new int[row][row];
        createSpiralMatrix(arr);
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
     * @param a ma trận kết quả cấp m x n
     */
    static void createSpiralMatrix(int a[][]) {
        int row = (a.length - 1) / 2;
        int col = (a.length - 1) / 2;
        int rowNext = row + 1;
        int colNext = col + 1;
        int rowPrev = row;
        int colPrev = col;
        int value = 1;
        a[row][col] = value++;
        int bound = a.length * a.length;
        while (value < bound) {
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
        }
    }
}
