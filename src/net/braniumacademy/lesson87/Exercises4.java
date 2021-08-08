package net.braniumacademy.lesson87;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see  <a href="https://braniumacademy.net/">Branium</a>
 */

public class Exercises4 {
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
            var words = str.split("\\s+");
            quickSort(words, 0, words.length - 1);
            printResult(words);
            t--;
        }
    }
}
