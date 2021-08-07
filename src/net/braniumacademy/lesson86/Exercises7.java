package net.braniumacademy.lesson86;

import java.util.Scanner;

public class Exercises7 {
    // thuật toán trộn hai mảng đã sắp xếp tăng dần
    private static double[] merge(double[] first, double[] second) {
        // tạo mảng output có số phần tử bằng với tổng số phần tử của hai mảng thành phần
        double[] output = new double[first.length + second.length];
        // tiến hành trộn
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                // gán output[k] = leftArr[i] sau đó tăng k, i
                output[k++] = first[i++];
            } else {
                output[k++] = second[j++]; // gán sau đó tăng k, j
            }
        }
        // chép các phần tử còn lại của mảng trái vào mảng output
        while (i < first.length) {
            output[k++] = first[i++];
        }
        // chép các phần tử còn lại của mảng phải vào mảng output
        while (j < second.length) {
            output[k++] = second[j++];
        }
        return output;
    }

    public static void main(String[] args) {
        int t, count = 1;
        var input = new Scanner(System.in);
        t = input.nextInt();
        while (t > 0) {
            int size1 = input.nextInt();
            double[] first = new double[size1];
            for (int i = 0; i < size1; i++) {
                first[i] = input.nextDouble();
            }
            int size2 = input.nextInt();
            double[] second = new double[size2];
            for (int i = 0; i < size2; i++) {
                second[i] = input.nextDouble();
            }
            // tiến hành trộn
            var resultArray = merge(first, second);
            // show kết quả
            System.out.printf("Test: %d\n", count++);
            printResult(resultArray);
            t--;
        }
    }

    private static void printResult(double[] arr) {
        for (var e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
