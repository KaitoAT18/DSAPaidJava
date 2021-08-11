package net.braniumacademy.lesson110;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */
public class Exercises4 {
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
    public static void generate(int[] arr, int k) {
        int count = 0;
        for (int i = 1; i <= arr.length; i++) {
            int[] combins = new int[i];
            // khởi tạo cấu hình đầu tiên
            for (int j = 0; j < i; j++) {
                combins[j] = j + 1;
            }
            boolean isFinalConfig = false;
            while (!isFinalConfig) {
                if (sum(arr, combins) == k) {
                    output(arr, combins);
                    count++;
                }
                isFinalConfig = nextCombination(combins, arr.length);
            }
        }
        if (count == 0) {
            System.out.println("NO RESULT");
        }
    }

    private static int sum(int[] arr, int[] combins) {
        int result = 0;
        for (int i = 0; i < combins.length; i++) {
            result += arr[combins[i] - 1];
        }
        return result;
    }

    private static void output(int[] arr, int[] combins) {
        for (int i = 0; i < combins.length; i++) {
            System.out.printf("%d ", arr[combins[i] - 1]);
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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            System.out.printf("Test %d: \n", count++);
            generate(arr, k);
        }
    }
}
