package net.braniumacademy.lesson87;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium</a>
 */

public class Exercises2 {

    public static <T extends Comparable<T>> void quickSort(T[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        var i = left;
        for (int j = left; j <= right; j++) {
            if (arr[j].compareTo(pivot) > 0) {
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        T tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        int test = 1;
        while (t > 0) {
            int n = input.nextInt();
            var arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            quickSort(arr, 0, arr.length - 1);
            System.out.printf("Test %d:\n", test++);
            printResult(arr);
            t--;
        }
    }

    private static <T> void printResult(T[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
