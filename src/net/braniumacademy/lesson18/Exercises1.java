package net.braniumacademy.lesson18;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */

public class Exercises1 {
    public static void generate(int[] arr) { // thuật toán sinh tất cả các xâu
        boolean isFinal = false;
        while (!isFinal) {
            output(arr);
            isFinal = nextBinaryString(arr);
        }
    }

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

    private static void output(int[] arr) { // hiển thị kết quả
        for (var e : arr) {
            System.out.printf("%-5d", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        var count = 1;
        while (t-- > 0) {
            var n = input.nextInt();
            System.out.printf("Test %d: \n", count++);
            generate(new int[n]);
        }
        input.close();
    }
}
