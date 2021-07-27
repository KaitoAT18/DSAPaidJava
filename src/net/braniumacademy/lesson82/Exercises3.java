package net.braniumacademy.lesson82;

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
            bubbleSortOpt(words);
            printResult(words);
            t--;
        }
    }

    public static <T extends Comparable<T>> void bubbleSortOpt(T[] arr) {
        boolean isSwapped;
        int i = arr.length - 1;
        while (i > 0) {
            isSwapped = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            } else {
                i--;
            }
        }
    }

    private static <T> void printResult(T[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }
}
