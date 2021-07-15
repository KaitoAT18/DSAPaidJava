package net.braniumacademy.lesson15;

import java.util.Scanner;

/**
 * 1. Cấu trúc con tối ưu: để đi đến tọa độ (m, n), đường đi sẽ phải qua một trong các ô
 * tọa độ (m-1, n-1), (m-1, n), (m, n-1). Do đó chi phí nhỏ nhất để đi đến (m, n) là chi
 * phí nhỏ nhất trong 3 ô trên cộng thêm chi phí tại ô (m, n).
 * 2. Vấn đề chồng lấn nhau của các bài toán con: việc tìm chi phí nhỏ nhất để đi đến ô
 * tọa độ (i, j) lặp đi lặp lại đến khi ta đến đích.
 */
public class Exercises4 {
    public static void main(String[] args) {
        int row, col;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số hàng, cột: ");
        row = input.nextInt();
        col = input.nextInt();
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập giá trị tại vị trí (%d, %d): ", i, j);
                cost[i][j] = input.nextInt();
            }
        }
        System.out.println("Nhập tọa độ ô cần tới (x, y): ");
        int x = input.nextInt();
        int y = input.nextInt();
        int minCost = findMinCost(cost, x, y);
        System.out.printf("Chi phí nhỏ nhất: %d\n", minCost);
    }

    // chiến lược bottom-up
    private static int findMinCost(int[][] cost, int m, int n) {
        int[][] result = new int[m + 1][n + 1]; // mảng lưu chi phí đi đến từng ô (i, j) với i <=m và j <= n
        // gán giá trị cho phần tử đầu tiên trong result:
        result[0][0] = cost[0][0];
        // cập nhật hàng đầu tiên trong result:
        for (int i = 1; i <= n; i++) {
            result[0][i] = result[0][i - 1] + cost[0][i];
        }
        // cập nhật cột đầu tiên trong result:
        for (int i = 1; i <= m; i++) {
            result[i][0] = result[i - 1][0] + cost[i][0];
        }
        // cập nhật các phần tử ở các hàng khác:
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = Math.min(result[i - 1][j],
                        Math.min(result[i][j - 1], result[i - 1][j - 1])) + cost[i][j];
            }
        }
        return result[m][n];
    }
}
