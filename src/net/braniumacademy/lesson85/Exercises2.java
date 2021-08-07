package net.braniumacademy.lesson85;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
    /**
     * Phương thức sắp xếp shell sort cho kiểu số nguyên
     *
     * @param arr mảng đầu vào
     */
    public static void shellSort(int[] arr) {
        int interval = 1;
        while (interval < arr.length / 3) {
            interval = interval * 3 + 1;
        }
        while (interval > 0) {
            for (int outer = interval; outer < arr.length; outer++) {
                int valueToInsert = arr[outer];
                int inner = outer;
                // điều kiện đổi chỗ: nếu phần tử bên trái nhỏ hơn phần tử bên phải cách nó 1 đoạn chỉ số = interval
                while (inner > interval - 1 && arr[inner - interval] <= valueToInsert) {
                    arr[inner] = arr[inner - interval];
                    inner = inner - interval;
                }
                arr[inner] = valueToInsert;
            }
            interval = (interval - 1) / 3;
        }
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            int n = input.nextInt();
            var arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            shellSort(arr);
            System.out.printf("Test %d:\n", test++);
            printResult(arr);
            t--;
        }
    }

    private static void printResult(int[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
