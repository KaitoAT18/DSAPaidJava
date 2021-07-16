package net.braniumacademy.lesson33.exercises2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
    public static void main(String[] args) {
        Stack<String> words = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào một câu bạn muốn nói: ");
        var str = input.nextLine();
        var elements = str.split("\\s+"); // tách từ
        System.out.println(Arrays.deepToString(elements));
        reverseWords(words, elements); // đảo từ
        showResult(words); // hiện kết quả
    }

    private static void showResult(Stack<String> words) {
        while (!words.isEmpty()) {
            System.out.print(words.peek() + " ");
            words.pop();
        }
    }

    private static void reverseWords(Stack<String> words, String[] elements) {
        for (var e : elements) {
            words.push(e);
        }
    }
}
