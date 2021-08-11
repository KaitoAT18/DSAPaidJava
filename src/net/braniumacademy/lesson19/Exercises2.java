package net.braniumacademy.lesson19;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */

public class Exercises2 {
    // sinh hoán vị kế tiếp
    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] > arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int k = arr.length - 1;
            while (arr[i] > arr[k]) {
                k--;
            }
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            int r = i + 1;
            int s = arr.length - 1;
            while (r < s) {
                int t = arr[r];
                arr[r] = arr[s];
                arr[s] = t;
                r++;
                s--;
            }
            return false;
        } else {
            return true;
        }
    }

    // thuật toán sinh hoán vị chính tắc
    public static void generatePermutation(int[] arr) {
        boolean isFinalConfig = nextPermutation(arr);
        if (!isFinalConfig) {
            output(arr);
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
        input.nextLine();
        var count = 1;
        while (t-- > 0) {
            var n = input.nextInt(); // đọc n
            var arr = new int[n]; // tạo mảng với các giá trị mặc định
            for (int i = 0; i < n; i++) { // đọc các phần tử của cấu hình cho trước
                arr[i] = input.nextInt();
            }
            System.out.printf("Test %d: \n", count++);
            generatePermutation(arr);
        }
        input.close();
    }
}
