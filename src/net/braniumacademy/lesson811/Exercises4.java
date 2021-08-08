package net.braniumacademy.lesson811;

import java.util.*;

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
            var listStr = new ArrayList<String>(Arrays.stream(words).toList());
            Collections.sort(listStr, (str1, str2) -> str2.compareTo(str1));
            printResult(listStr);
            t--;
        }
    }

    private static <T> void printResult(List<String> words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }
}
