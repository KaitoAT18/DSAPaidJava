package net.braniumacademy.lesson16;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class NQueenProblem {
    private static final int N = 8;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        // giả sử ban đầu chưa đặt quân hậu nào, bàn cờ rỗng, tất cả các ô
        // nhận giá trị 0
        boolean result = solveNQueen(board, 0);
        if (result) {
            System.out.println("Một trong các lời giải là: ");
            showResult(board);
        } else {
            System.out.println("Không tìm thấy lời giải.");
        }
    }

    /**
     * Phương thức xử lý việc đặt hậu và tìm lời giải của bài toán
     *
     * @param board ma trận để lưu kết quả
     * @param col   cột đang xem xét đặt quân hậu
     * @return true nếu việc đặt hậu dẫn tới lời giải và false nếu ngược lại
     */
    private static boolean solveNQueen(int[][] board, int col) {
        if (col >= N) {
            return true;
        }
        // kiểm tra cột hiện tại và đặt hậu vào đúng vị trí
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // 1 == hậu được đặt tại vị trí đó
                if (solveNQueen(board, col + 1)) {
                    return true;
                } else {
                    board[i][col] = 0;
                }
            }
        }
        return false;
    }

    /**
     * Phương thức kiểm tra xem liệu việc đặt hậu tại vị trí (row, col) trên bàn cờ có
     * ok hay không. Do các quân hậu được đặt từ trái sang tính theo cột và đặt ngẫu nhiên
     * tính theo hàng. Chỉ cần xét các cột < col vì chúng đã có quân hậu được đặt.
     *
     * @param board bàn cờ 8*8
     * @param row   chỉ số hàng đang xem xét việc đặt hậu
     * @param col   chỉ số cột đang xem xét việc đặt hậu
     * @return true nếu có thể đặt hậu và false nếu không thể đặt hậu
     */
    private static boolean isSafe(int[][] board, int row, int col) {
        // kiểm tra hàng hiện thời xem ở phía bên trái đã có quân hậu nào chưa?
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // kiểm tra đường chéo trên của ô hiện thời xem có quân hậu nào chưa
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // kiểm tra đường chéo dưới của ô hiện thời xem có quân hậu nào chưa
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức hiển thị kết quả ma trận biểu diễn các vị trí đặt hậu(1) trên bàn cờ
     *
     * @param sol ma trận kết quả
     */
    private static void showResult(int[][] sol) {
        for (var row : sol) {
            for (var e : row) {
                System.out.printf("%3d", e);
            }
            System.out.println();
        }
    }
}
