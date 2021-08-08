package net.braniumacademy.lesson811;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

public class Exercises3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = Integer.parseInt(input.nextLine());
        while (t > 0) {
            var str = input.nextLine();
            var words = str.split("\\s+");
            var listStr = new ArrayList<String>(Arrays.stream(words).toList());
            listStr.sort(null);
            printResult(listStr);
            t--;
        }
    }

    private static <T> void printResult(List<T> words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }
}
