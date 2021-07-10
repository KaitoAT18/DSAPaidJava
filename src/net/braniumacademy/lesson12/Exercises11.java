package net.braniumacademy.lesson12;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises11 {
    public static void main(String[] args) {
        int[][] arr;
        int row, col;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số hàng, cột: ");
        row = input.nextInt();
        col = input.nextInt();
        arr = new int[row][col];
        createSpiralMatrix(arr);
        showResult(arr);
    }

    private static void showResult(int[][] arr) {
        for (var row : arr) {
            for (var e : row) {
                System.out.printf("%5d", e);
            }
            System.out.println("\n");
        }
    }

    /**
     * Phương thức dùng để vẽ ma trận xoắn ốc cấp m x n.
     * B1: khởi tạo các biến rowStart-chỉ số hàng đầu, rowEnd-chỉ số hàng cuối,
     * colStart-cột đầu, colEnd-cột cuối.
     * B2: Lặp chừng nào tất cả các cạnh cấu thành ma trận xoắn ốc được duyệt:
     * B2.1: in ra hàng đầu tiên trong vùng đang xét của ma trận, tăng rowStart lên 1.
     * B2.2: in ra cột cuối cùng trong vùng đang xét của ma trận, giảm colEnd đi 1.
     * B2.3: in ra hàng cuối cùng trong vùng đang xét của ma trận, giảm rowEnd đi 1.
     * B2.4: in ra cột đầu tiên trong vùng đang xét của ma trận, tăng colStart lên 1.
     *
     * @param a ma trận kết quả cấp m x n
     */
    static void createSpiralMatrix(int a[][]) {
        int rowEnd = a.length;
        int colEnd = a[0].length;
        int rowStart = 0, colStart = 0;
        int value = 1;
        /*  rowStart - starting row index
            rowEnd - ending row index
            colStart - starting column index
            colEnd - ending column index
        */
        while (rowStart < rowEnd && colStart < colEnd) {
            // gán giá trị cho hàng đầu trong số các hàng còn lại
            for (int i = colStart; i < colEnd; ++i) { // c
                a[rowStart][i] = value++;
            }
            rowStart++; // chuyển đến hàng kế tiếp ở lần duyệt tới
            // gán giá trị cho cột cuối trong số các cột còn lại
            for (int i = rowStart; i < rowEnd; ++i) {
                a[i][colEnd - 1] = value++;
            }
            colEnd--; // chuyển tới cột liền trước ở lần duyệt tới
            // gán giá trị cho hàng cuối trong các hàng còn lại
            if (rowStart < rowEnd) {
                for (int i = colEnd - 1; i >= colStart; --i) {
                    a[rowEnd - 1][i] = value++;
                }
                rowEnd--; // chuyển tới hàng liền trước ở lần duyệt tới
            }
            // gán giá trị cho cột đầu trong số các cột còn lại
            if (colStart < colEnd) {
                for (int i = rowEnd - 1; i >= rowStart; --i) {
                    a[i][colStart] = value++;
                }
                colStart++; // chuyển đến cột kế tiếp ở lần duyệt tới
            }
        }
    }
}
