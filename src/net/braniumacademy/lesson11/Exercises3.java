package net.braniumacademy.lesson11;

import java.util.Arrays;
import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        int t;
        String str;
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        input.nextLine();
        while (t > 0) {
            str = input.nextLine();
            result(str);
            t--;
        }
    }

    private static void result(String str) {
        String[] words = str.split("\\s+");
        Arrays.sort(words);
        for (var e : words) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
