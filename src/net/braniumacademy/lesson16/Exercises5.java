package net.braniumacademy.lesson16;

/**
 * @author Branium Academy
 * @version 2.0
 * @file Exercises4.cpp
 * @brief Update exercises 4 lesson 2.6
 * @date 2022-11-01
 * @copyright Copyright (c) Branium Academy 2022
 * @see <a href="https://braniumacademy.net">...</a>
 */

// Sau đây là các bước thực hiện giải bài toán sử dụng quay lui:
//
//    Tạo một hàm đệ quy nhận vào đồ thị, vị trí hiện tại, mảng màu đầu ra.
//    Nếu vị trí hiện tại bằng với số đỉnh đồ thị, in ra cấu hình màu tìm được.
//    Gán từng màu cho mỗi đỉnh từ 1 đến m
//    Khi gán màu, kiểm tra xem việc tô màu có thỏa mãn không(2 đỉnh kề phải khác màu).
//    Lặp lại lời gọi đệ quy với chỉ số tiếp theo của đỉnh kế tiếp.
//    Nếu bất kì hàm đệ quy nào trả về true, thoát vòng lặp và return true
//    Nếu không có hàm đệ quy nào trả về true, ta return false.

public class Exercises5 {
    public static void main(String[] args) {
        boolean[][] graph = new boolean[][]{
                {false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false}
        };
        int m = 3; // số lượng các màu cần thử tô
        // gọi hàm
        if (!graphColoring(graph, m)) {
            System.out.println("Không tồn tại lời giải.");
        }
    }

    private static boolean isSafe(int vertex, boolean[][] graph, int[] colors, int color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] && colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    // hàm đệ quy thực hiện tô màu đồ thị
    private static boolean graphColoringUtil(boolean[][] graph, int m, int[] colors, int vertex) {
        // nếu tất cả các đỉnh đã đc gán màu => return true
        if (vertex == graph.length) {
            return true;
        }
        // thử tô màu khác cho đỉnh vertex
        for (int c = 1; c <= m; c++) {

            // kiểm tra việc tô màu c cho đỉnh vertex có ok không
            if (isSafe(vertex, graph, colors, c)) {
                colors[vertex] = c;
                // lặp lại việc gán màu cho các đỉnh còn lại của đồ thị
                if (graphColoringUtil(graph, m, colors, vertex + 1)) {
                    return true;
                }
                // nếu việc gán màu c cho đỉnh vertex không dẫn tới lời giải => xóa bỏ việc gán màu
                colors[vertex] = 0;
            }
        }
        // nếu không màu nào có thể gán cho đỉnh này, return false
        return false;
    }

    private static boolean graphColoring(boolean[][] graph, int m) {
        int[] colors = new int[graph.length];
        if (!graphColoringUtil(graph, m, colors, 0)) {
            System.out.println("Không có lời giải.");
            return false;
        }
        printSolution(colors);
        return true;
    }

    // hàm hiển thị 1 kết quả tìm được
    private static void printSolution(int[] colors) {
        System.out.println("Sau đây là một lời giải: ");
        for (int color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();
    }
}
