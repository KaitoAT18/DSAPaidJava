package net.braniumacademy.lesson110;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */
public class Exercises3 {
    // thuật toán sinh tổ hợp kế tiếp
    public static boolean nextCombination(int[] arr, int n) {
        int i = arr.length - 1;
        int k = arr.length;
        while (i >= 0 && arr[i] == n - k + i + 1) {
            i--;
        }
        if (i >= 0) {
            arr[i] = arr[i] + 1;
            for (int j = i + 1; j < k; j++) {
                arr[j] = arr[i] + j - i;
            }
            return false; // chưa phải cấu hình cuối cùng
        } else {
            return true; // đã là cấu hình cuối cùng
        }
    }

    // thuật toán sinh toàn bộ các tổ hợp chập k của n
    public static void generate(int[] arr, int n) {
        boolean isFinalConfig = nextCombination(arr, n);
        if (!isFinalConfig) {
            while (!isFinalConfig) {
                output(arr);
                isFinalConfig = nextCombination(arr, n);
            }
        } else {
            System.out.println("UNAVAILABLE");
        }
    }

    private static void output(int[] arr) {
        for (var e : arr) {
            System.out.printf("%d ", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int count = 1;
        while (t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = input.nextInt();
            }
            System.out.printf("Test %d: \n", count++);
            generate(arr, n);
        }
    }
}
