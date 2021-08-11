package net.braniumacademy.lesson18;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */

public class Exercises4 {
    /**
     * Phương thức chuyển đổi chuỗi nhị phân sang giá trị số ở hệ 10
     *
     * @param arr mảng chứa chuỗi nhị phân
     * @return giá trị số tính được từ chuỗi nhị phân cho trước ở hệ 10
     */
    public static int convertBinaryToDecimal(int[] arr) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number += arr[i] * Math.pow(2, arr.length - 1 - i);
        }
        return number;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        input.nextLine();
        var count = 1;
        while (t-- > 0) {
            var testCase = input.nextLine(); // đọc cả dòng
            var elements = testCase.split("\\s+"); // tách các phần tử
            System.out.printf("Test %d: ", count++); // in ra đầu dòng kết quả
            var arr = new int[elements.length]; // tạo mảng chứa n phần tử, n = số phần tử trong chuỗi input
            for (int i = 0; i < arr.length; i++) { //
                arr[i] = Integer.parseInt(elements[i]); // chuyển từ String sang giá trị int
            }
            var result = convertBinaryToDecimal(arr);
            System.out.println(result);
        }
    }
}
