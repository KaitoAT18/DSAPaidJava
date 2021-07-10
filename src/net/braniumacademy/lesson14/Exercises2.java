package net.braniumacademy.lesson14;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập số nguyên dương n không quá 90: ");
        var n = input.nextInt();
        if (n < 0) {
            System.out.println("Nhập số nguyên dương n.");
        } else {
            System.out.println("F" + n + " = " + fiboN(n));
        }
    }

    // phương thức tìm số fibonacci thứ n
    public static long fiboN(int n) {
        if (n < 2) { // điểm dừng
            return n;
        } else { // bước đệ quy
            return fiboN(n - 1) + fiboN(n - 2);
        }
    }
}
