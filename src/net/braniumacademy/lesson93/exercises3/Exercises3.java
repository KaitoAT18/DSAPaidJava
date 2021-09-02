package net.braniumacademy.lesson93.exercises3;

/**
 * @author Branium Academy
 * @version 2021.08
 * @website https://braniumacademy.net/
 */

import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var t = scanner.nextInt(); // số bộ test t
        while (t-- > 0) {
            var x = scanner.next().toLowerCase();
            scanner.nextLine(); // đọc bỏ dòng thừa
            var str = scanner.nextLine();
            // viết thường các từ, sau đó tách từ tại vị trí có 1 hoặc nhiều dấu cách
            var words = str.toLowerCase().split("\\s+");
            quickSort(words, 0, words.length - 1);
            var result = countX(words, x);
            System.out.printf("%d\n", result);
        }
        scanner.close();
    }

    private static void quickSort(String[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            var p = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, p - 1);
            quickSort(arr, p + 1, rightIndex);
        }
    }

    private static int partition(String[] arr, int left, int right) {
        var pivot = arr[right];
        var i = left;
        for (int j = left; j <= right; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                var tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        var tmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tmp;
        return i;
    }

    private static int countX(String[] arr, String x) {
        int counter = 0;
        // tìm vị trí trái cùng xuất hiện x
        int startPos = leftMostX(arr, 0, arr.length - 1, x);
        if (startPos == -1) { // không tìm thấy x
            return counter;
        }
        // tìm vị trí phải củng xuất hiện x
        int endPos = rightMostX(arr, 0, arr.length - 1, x);
        return endPos - startPos + 1;
    }

    private static int leftMostX(String[] arr, int left, int right, String x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || arr[mid - 1].compareTo(x) < 0 && arr[mid].compareTo(x) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(x) <= 0) { // tìm phía bên phải
                return leftMostX(arr, mid + 1, right, x);
            } else { // tìm phía trái
                return leftMostX(arr, left, mid - 1, x);
            }
        }
        return -1;
    }

    private static int rightMostX(String[] arr, int left, int right, String x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == arr.length - 1 || arr[mid + 1].compareTo(x) > 0 && arr[mid].compareTo(x) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(x) <= 0) { // tìm phía bên phải
                return rightMostX(arr, mid + 1, right, x);
            } else { // tìm phía trái
                return rightMostX(arr, left, mid - 1, x);
            }
        }
        return -1;
    }
}
