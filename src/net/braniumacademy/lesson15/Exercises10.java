package net.braniumacademy.lesson15;

import java.util.Scanner;

public class Exercises10 {
    private static long r[] = new long[1000000]; // tối đa 100k phần tử

    private static long coin(long n) {
        if (n == 0) { // trường hợp cơ sở
            return 0;
        } else if (n < 12) { // trường hợp cơ sở
            return n;
        } else {
            if (n < 1000000) {
                if (r[(int) n] > 0) return r[(int) n];
            }
            long m = Math.max(n, coin(n / 2) + coin(n / 3) + coin(n / 4));
            if (n < 1000000) {
                r[(int) n] = m;
            }
            return m;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) { // đọc các bộ test chừng nào chưa hết các bộ test
            long n = sc.nextLong();
            System.out.println(coin(n));
        }
    }
}
