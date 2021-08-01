package net.braniumacademy.lesson86;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see  <a href="https://braniumacademy.net/">Branium</a>
 */

public class Exercises3 {
    // thuật toán sắp xếp trộn đệ quy, first, last: chỉ số phần tử đầu, cuối
    static void mergeSort(String[] arr, int first, int last) { // arr: mảng đầu vào
        if (first < last) {              // nếu first nhỏ hơn last
            int middle = (first + last) / 2;  // tìm chỉ số phần tử giữa
            mergeSort(arr, first, middle); // sắp xếp trộn nửa đầu mảng
            mergeSort(arr, middle + 1, last); // sắp xếp trộn nửa sau mảng
            merge(arr, first, middle, last);  // trộn hai nửa đã sắp xếp
        }
    }

    // thuật toán trộn hai mảng đã sắp xếp tăng dần
    private static void merge(String[] arr, int first, int middle, int last) {
        // xác định kích thước hai mảng con cần trộn
        int size1 = middle - first + 1; // kích thước mảng con trái
        int size2 = last - middle; // kích thước mảng con phải
        // tạo mảng con để lưu các phần tử để trộn
        String[] leftArr = new String[size1];
        String[] rightArr = new String[size2];
        // chép dữ liệu vào mảng con trái
        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[first + i];
        }
        // chép dữ liệu vào mảng con phải
        for (int j = 0; j < size2; j++) {
            rightArr[j] = arr[middle + j + 1];
        }
        // tiến hành trộn
        int i = 0, j = 0, k = first;
        while (i < size1 && j < size2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                // gán arr[k] = leftArr[i] sau đó tăng k, i
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++]; // gán sau đó tăng k, j
            }
        }
        // chép các phần tử còn lại của mảng trái vào mảng arr
        while (i < size1) {
            arr[k++] = leftArr[i++];
        }
        // chép các phần tử còn lại của mảng phải vào mảng arr
        while (j < size2) {
            arr[k++] = rightArr[j++];
        }
    }

    private static <T> void printResult(T[] words) {
        for (var e : words) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = Integer.parseInt(input.nextLine());
        while (t > 0) {
            var str = input.nextLine();
            var words = str.split("\\s+");
            mergeSort(words, 0, words.length - 1);
            printResult(words);
            t--;
        }
    }
}
