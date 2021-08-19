package net.braniumacademy.lesson77;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt();
        int count = 1;
        while (t > 0) {
            var n = scanner.nextInt();
            var arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextDouble();
            }
            bucketSort(arr, arr.length);
            System.out.printf("Test %d: \n", count++);
            showElements(arr);
            t--;
        }
        scanner.close();
    }

    private static void showElements(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bucketSort(double[] arr, int k) {
        if (k < 0) { // nếu n nhỏ hơn 0, kết thúc
            throw new RuntimeException("Số phân vùng không hợp lệ: " + k);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Double>[] buckets = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) { // khởi tạo k danh sách rỗng
            buckets[i] = new ArrayList<>();
        }
        double max = findMax(arr); // tìm giá trị lớn nhất trong mảng
        // phân phối các phần tử vào các danh sách khác nhau
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) (arr[i] * k / max);
            buckets[bucketIndex].add(arr[i]);
        }
        for (int i = 0; i <= k; i++) { // sắp xếp các danh sách
            buckets[i].sort(null); // sắp xếp tăng dần
        }
        // gộp các phần tử lại mảng gốc
        int index = 0; // khởi tạo vị trí index
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    private static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
