package net.braniumacademy.lesson16.exercises4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercises4 {
    private static final int N = 9;

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // kiểm tra xem trên hàng cần thêm số num đã tồn tại num chưa
        for (int c = 0; c < board.length; c++) {
            if (board[row][c] == num) { // nếu đã tồn tại
                return false; // trả về không đặt được num ở hàng này
            }
        }
        // kiểm tra trên cột hiện tại đã có giá trị num chưa
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false; // không đặt được num vào ô này
            }
        }
        // kiểm tra cụm 9 ô bao quanh ô (row, col) xem đã tồn tại giá trị num chưa
        int boxSize = 3;
        int boxRowStart = row - row % boxSize;
        int boxColStart = col - col % boxSize;
        for (int i = boxRowStart; i < boxRowStart + boxSize; i++) {
            for (int j = boxColStart; j < boxColStart + boxSize; j++) {
                if (board[i][j] == num) { // nếu đã tồn tại ô chứa giá trị num
                    return false; // không đặt được num vào ô này
                }
            }
        }
        // mặc định giá trị num chưa tồn tại trong phạm vi cần kiểm tra
        return true;
    }

    public static boolean solveSudoku(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }
        for (int num = 1; num <= N; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board)) {
                    return true;
                } else { // nếu không dẫn tới lời giải
                    board[row][col] = 0; // quay lui
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        int t;
        int testNumber = 1;
        var filePath = "./src/net/braniumacademy/lesson16/exercises4/input.txt";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            t = scanner.nextInt();
            while (t-- > 0) {
                readPresetData(board, scanner);
                System.out.printf("Test %d:\n", testNumber++);
                if (solveSudoku(board)) {
                    showResult(board);
                } else {
                    System.out.println("Không có lời giải!");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showResult(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }

    private static void readPresetData(int[][] board, Scanner scanner) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
    }
}
