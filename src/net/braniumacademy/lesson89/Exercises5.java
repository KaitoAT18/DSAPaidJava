package net.braniumacademy.lesson89;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises5 {
    // thuật toán couting sort
    public static void countingSort(String[] input, int index) {
        int n = input.length;
        int k = 'z' - 'A' + 1;
        int[] count = new int[k + 1];
        String[] output = new String[n];
        for (int i = 0; i < n; i++) {
            int j = (input[i].length() - 1 < index) ? 0 : ((input[i].charAt(index) - 'A') + 1);
            count[j]++;
        }
        // sắp xếp tăng dần
        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }
        // đưa các phần tử vào đúng vị trí của nó
        for (int i = n - 1; i >= 0; i--) {
            int j = (input[i].length() - 1 < index) ? 0 : ((input[i].charAt(index) - 'A') + 1);
            count[j]--;
            output[count[j]] = input[i];
        }
        // sao chép các phần tử trong mảng output vào mảng gốc input
        for (int i = 0; i < n; i++) {
            input[i] = output[i];
        }
    }

    // thuật toán radix sort
    public static void radixSort(String[] arr) {
        int max = findMax(arr);
        for (int i = max - 1; i >= 0; i--) {
            countingSort(arr, i);
        }
    }

    // thuật toán tìm max trong mảng
    private static int findMax(String[] arr) {
        int max = arr[0].length();
        for (var e : arr) {
            if (e.length() > max) {
                max = e.length();
            }
        }
        return max;
    }

    private static <T> void printResult(T[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = Integer.parseInt(input.nextLine());
        while (t > 0) {
            var str = input.nextLine();
            var words = str.split("[\\s,.?!;]+");
            radixSort(words);
            printResult(words);
            t--;
        }
    }
}
