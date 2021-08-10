package net.braniumacademy.lesson18;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */

public class Exercises3 {
    public static boolean nextBinaryString(int[] arr) { // thuật toán sinh xâu kế tiếp
        int i = arr.length - 1;
        while (i >= 0 && arr[i] != 0) {
            arr[i] = 0;
            i--;
        }
        if (i >= 0) {
            arr[i] = 1;
            return false;
        } else {
            return true;
        }
    }

    public static void generate(int[] arr) { // thuật toán sinh tất cả các xâu
        boolean isFinal = false;
        isFinal = nextBinaryString(arr);
        if (isFinal) {
            System.out.println("UNAVAILABLE");
        } else {
            while (!isFinal) {
                output(arr);
                isFinal = nextBinaryString(arr);
            }
        }

    }

    private static void output(int[] arr) { // hiển thị kết quả
        for (var e : arr) {
            System.out.printf("%-2d", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        var count = 1;
        while (t-- > 0) {
            var n = input.nextInt(); // đọc n
            var arr = new int[n]; // tạo mảng với các giá trị mặc định
            for (int i = 0; i < n; i++) { // đọc các phần tử của cấu hình cho trước
                arr[i] = input.nextInt();
            }
            System.out.printf("Test %d: \n", count++);
            generate(arr);
        }
        input.close();
    }
}
