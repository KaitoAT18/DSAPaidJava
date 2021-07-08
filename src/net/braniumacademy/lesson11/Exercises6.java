package net.braniumacademy.lesson11;

import java.util.Scanner;

public class Exercises6 {
    public static void main(String[] args) {
        int t; // số bộ test
        int n; // số phần tử của từng bộ test
        int[] arr;
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        while (t > 0) {
            n = input.nextInt();
            arr = new int[n]; // chừa ra một chỗ để chèn phần tử mới
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            long result = sumElements(arr);
            System.out.println(result);
            t--;
        }
    }

    private static long sumElements(int[] arr) {
        long sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                sum += arr[i];
            }
        }
        return sum;
    }
}
