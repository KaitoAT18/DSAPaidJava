package net.braniumacademy.lesson19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">...</a>
 */

public class Exercises4 {
    // sinh hoán vị kế tiếp
    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] > arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int k = arr.length - 1;
            while (arr[i] > arr[k]) {
                k--;
            }
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            int r = i + 1;
            int s = arr.length - 1;
            while (r < s) {
                int t = arr[r];
                arr[r] = arr[s];
                arr[s] = t;
                r++;
                s--;
            }
            return false;
        } else {
            return true;
        }
    }

    // thuật toán sinh hoán vị chính tắc
    public static void generatePermutation(String[] names) {
        var arr = new int[names.length];
        // khởi tạo
        for (int i = 0; i < names.length; i++) {
            arr[i] = i + 1;
        }
        var isFinalConfig = false;
        while (!isFinalConfig) {
            output(names, arr);
            isFinalConfig = nextPermutation(arr);
        }
    }

    private static void output(String[] names, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", names[arr[i] - 1]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        var input = new Scanner(new File("./src/net/braniumacademy/lesson19/CONTEST.INP"));
        var t = input.nextInt();
        input.nextLine();
        var count = 1;
        while (t-- > 0) {
            var test = input.nextLine(); // đọc n
            var names = test.split("\\s+"); // tạo mảng với các giá trị mặc định
            System.out.printf("Test %d: \n", count++);
            generatePermutation(names);
        }
        input.close();
    }
}
