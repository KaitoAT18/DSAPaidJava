package net.braniumacademy.lesson85;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = Integer.parseInt(input.nextLine());
        while (t > 0) {
            var str = input.nextLine();
            var words = str.split("\\s+");
            shellSort(words);
            printResult(words);
            t--;
        }
    }

    /**
     * Phương thức sắp xếp shell sort cho kiểu số nguyên
     *
     * @param arr mảng đầu vào
     */
    public static <T extends Comparable<T>> void shellSort(T[] arr) {
        int interval = 1;
        while (interval < arr.length / 3) {
            interval = interval * 3 + 1;
        }
        while (interval > 0) {
            for (int outer = interval; outer < arr.length; outer++) {
                T valueToInsert = arr[outer];
                int inner = outer;
                while (inner > interval - 1 && arr[inner - interval].compareTo(valueToInsert) <= 0) {
                    arr[inner] = arr[inner - interval];
                    inner = inner - interval;
                }
                arr[inner] = valueToInsert;
            }
            interval = (interval - 1) / 3;
        }
    }

    private static <T> void printResult(T[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }
}
