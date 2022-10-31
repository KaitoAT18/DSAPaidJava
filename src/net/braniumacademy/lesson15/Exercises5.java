package net.braniumacademy.lesson15;

/**
 * @author Branium Academy
 * @version 2.0
 * @file Exercises4.cpp
 * @brief Update exercises 5 lesson 2.6
 * @date 2022-10-31
 * @copyright Copyright (c) Branium Academy 2022
 * @see <a href="https://braniumacademy.net">...</a>
 */

// giải pháp:
// từ phần tử đầu, gọi đệ quy tới tất cả các phần tử có thể đi tới từ phần tử đầu tiên.
// Số lượng tối thiểu các bước nhảy từ đầu tới cuối mảng có thể được tính toán sử dụng giá trị tối thiểu
// từ các lời gọi đệ quy.
// tức là: minJump(start, end) = min(minJump(k, end)) với mọi k có thể tới được từ đầu mảng.

public class Exercises5 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int result = minJump(arr);
        if (result == Integer.MAX_VALUE) {
            System.out.println("==> Không có giải pháp.");
        } else {
            System.out.println("Số bước nhảy tối thiểu: " + result);
        }
    }

    private static // tìm số bước nhảy nhỏ nhất có thể
    int minJump(int[] arr) {
        int n = arr.length;
        int[] jumps = new int[n];
        if (n == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }
        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }
}
