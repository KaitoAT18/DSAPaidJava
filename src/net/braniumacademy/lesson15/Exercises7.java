package net.braniumacademy.lesson15;

/**
 * @author Branium Academy
 * @version 2.0
 * @file Exercises4.cpp
 * @brief Update exercises 4 lesson 2.6
 * @date 2022-10-31
 * @copyright Copyright (c) Branium Academy 2022
 * @see <a href="https://braniumacademy.net">...</a>
 */

public class Exercises7 {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 30, 27, 45, 41, 62, 87};
        int size = arr.length;
        // mảng lưu kết quả tạm thời
        int[][] dp = new int[size + 1][size + 1];
        int result = findMax(0, -1, size, arr, dp);
        System.out.println("Do dai chuoi tang: " + result);
    }

    private static int findMax(int index, int prevIndex, int n, int[] arr, int[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][prevIndex + 1] != 0) {
            return dp[index][prevIndex + 1];
        }
        int first = findMax(index + 1, prevIndex, n, arr, dp);
        int second = -1;
        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            second = 1 + findMax(index + 1, index, n, arr, dp);
        }
        return dp[index][prevIndex + 1] = Math.max(second, first);
    }
}
