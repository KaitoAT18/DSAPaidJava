package net.braniumacademy.lesson15;

public class Exercises3 {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120, 200 };
        int weight[] = new int[] { 10, 20, 30, 20 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, weight, val, n));
    }

    // trả về giá trị lớn nhất có thể bỏ vào túi giới hạn khối lượng W
    // chiến lược bottom-up
    static int knapSack(int W, int[] weight, int[] value, int n) {
        int[][] result = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    result[i][j] = Math.max(value[i - 1] + result[i - 1][j - weight[i - 1]], result[i - 1][j]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[n][W]; // trả về kết quả
    }
}
