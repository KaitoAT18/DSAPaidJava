package net.braniumacademy.lesson14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercises13 {
    public static void main(String[] args) {
        int[][] arr;
        int row, col;
        String inputFile = "src/net/braniumacademy/lesson14/input12.1.txt";
        String inputFile2 = "src/net/braniumacademy/lesson14/input12.2.txt";
        Scanner input;
        try { // thay bằng input của bạn. Sinh data từ bài tập số 11 rồi pate vào nhé!
            input = new Scanner(new File(inputFile2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return; // end game
        }
        // đọc input từ file
        row = input.nextInt();
        col = input.nextInt();
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        // hiển thị kết quả theo dạng ma trận xoắn ốc
        int rowEnd = arr.length;
        int colEnd = arr[0].length;
        int rowStart = 0, colStart = 0;
        /*  rowStart - starting row index
            rowEnd - ending row index
            colStart - starting column index
            colEnd - ending column index
        */
        printSpiralForm(arr, rowStart, rowEnd, colStart, colEnd);
    }

    /**
     * Phương thức dùng để hiển thị ma trận xoắn ốc cấp m x n.
     * B1: khởi tạo các biến rowStart-chỉ số hàng đầu, rowEnd-chỉ số hàng cuối,
     * colStart-cột đầu, colEnd-cột cuối.
     * B2: Lặp chừng nào tất cả các cạnh cấu thành ma trận xoắn ốc được duyệt:
     * B2.1: in ra hàng đầu tiên trong vùng đang xét của ma trận, tăng rowStart lên 1.
     * B2.2: in ra cột cuối cùng trong vùng đang xét của ma trận, giảm colEnd đi 1.
     * B2.3: in ra hàng cuối cùng trong vùng đang xét của ma trận, giảm rowEnd đi 1.
     * B2.4: in ra cột đầu tiên trong vùng đang xét của ma trận, tăng colStart lên 1.
     *
     * @param a        ma trận kết quả cấp m x n
     * @param rowStart vị trí hàng bắt đầu của lần duyệt hiện tại
     * @param rowEnd   vị trí hàng cuối của lần duyệt hiện tại
     * @param colStart vị trí cột bắt đầu của lần duyệt hiện tại
     * @param colEnd   vị trí hàng cột cuối của lần duyệt hiện tại
     */
    static void printSpiralForm(int[][] a, int rowStart, int rowEnd,
                                int colStart, int colEnd) {
        if (rowStart >= rowEnd || colStart >= colEnd) {
            return; // điểm dừng
        }
        // gán giá trị cho hàng đầu trong số các hàng còn lại
        for (int i = colStart; i < colEnd; ++i) { // c
            System.out.print(a[rowStart][i] + " ");
        }
        rowStart++; // chuyển đến hàng kế tiếp ở lần duyệt tới
        // gán giá trị cho cột cuối trong số các cột còn lại
        for (int i = rowStart; i < rowEnd; ++i) {
            System.out.print(a[i][colEnd - 1] + " ");
        }
        colEnd--; // chuyển tới cột liền trước ở lần duyệt tới
        // gán giá trị cho hàng cuối trong các hàng còn lại
        if (rowStart < rowEnd) {
            for (int i = colEnd - 1; i >= colStart; --i) {
                System.out.print(a[rowEnd - 1][i] + " ");
            }
            rowEnd--; // chuyển tới hàng liền trước ở lần duyệt tới
        }
        // gán giá trị cho cột đầu trong số các cột còn lại
        if (colStart < colEnd) {
            for (int i = rowEnd - 1; i >= rowStart; --i) {
                System.out.print(a[i][colStart] + " ");
            }
            colStart++; // chuyển đến cột kế tiếp ở lần duyệt tới
        }
        printSpiralForm(a, rowStart, rowEnd, colStart, colEnd);
    }
}
