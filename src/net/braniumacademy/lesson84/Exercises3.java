package net.braniumacademy.lesson84;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = Integer.parseInt(input.nextLine());
        while (t > 0) {
            var str = input.nextLine();
            var words = str.split("\\s+");
            insertionSort(words);
            printResult(words);
            t--;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T target = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(target) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }

    private static <T> void printResult(T[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }
}
