package net.braniumacademy.lesson15;
// tìm số xấu xí thứ n

import java.util.Scanner;

/**
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … là các số xấu xí, ta chia chúng thành 3 nhóm:
 * 1) tích của 2 với các số xấu xí:1*2, 2*2, 3*2, 4*2, 5*2, ...
 * 2) tích của 3 với các số xấu xí:1*3, 2*3, 3*3, 4*3, 5*3, ...
 * 3) tích của 5 với các số xấu xí:1*5, 2*5, 3*5, 4*5, 5*5, ...
 * sau đó ta dùng phương thức trộn giống sắp xếp trộn để trộn các phần tử 3 nhóm này.
 * Tại mỗi bước ta lấy phần tử nhỏ nhất, tiếp tục đến hết.
 */
public class Exercises9 {
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương n: ");
        int n = new Scanner(System.in).nextInt();
        System.out.printf("Số xấu xí thứ %d = %d\n", n, findNthUglyNumber(n));
    }

    /**
     * Phương thức dùng để tìm số xấu xí thứ n.
     * B1. Khai báo một mảng số xấu xí gồm n phần tử: ugly[n]
     * B2. Khởi tạo số xấu xí đầu tiên: ugly[0] = 1;
     * B3. khởi tạo 3 chỉ số mảng i2, i3, i5 để trỏ tới phần tử thứ nhất trong mảng ugly: i2 = i3 = i5 = 0;
     * B4. khởi tạo 3 lựa chọn cho số xấu xí kế tiếp:
     *      nextMultilpleOf2 = ugly[i2] * 2;
     *      nextMultilpleOf3 = ugly[i3] * 3;
     *      nextMultilpleOf5 = ugly[i5] * 5;
     * B5. Bây giờ lặp để điền tất cả các số xấu xí đến n:
     *  for i in [1, n - 1]:
     *      nextUglyNumber = min(nextMultilpleOf2, nextMultilpleOf3, nextMultilpleOf5);
     *      ugly[i] = nextUglyNumber;
     *      if(nextUglyNumber == nextMultilpleOf2):
     *          i2++;
     *          nextMultilpleOf2 = ugly[i2] * 2;
     *      if(nextUglyNumber == nextMultilpleOf3):
     *          i3++;
     *          nextMultilpleOf3 = ugly[i3] * 3;
     *      if(nextUglyNumber == nextMultilpleOf5):
     *          i5++;
     *          nextMultilpleOf5 = ugly[i5] * 5;
     * B6. trả về số xấu xí thứ n
     *
     * @param n thứ tự số xấu xí cần tìm
     * @return số xấu xí thứ n
     */
    private static int findNthUglyNumber(int n) {
        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultilpleOf2 = 2;
        int nextMultilpleOf3 = 3;
        int nextMultilpleOf5 = 5;
        int nextUglyNumber = 1;
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(nextMultilpleOf2, Math.min(nextMultilpleOf3, nextMultilpleOf5));
            ugly[i] = nextUglyNumber;
            if (nextUglyNumber == nextMultilpleOf2) {
                i2++;
                nextMultilpleOf2 = ugly[i2] * 2;
            }
            if (nextUglyNumber == nextMultilpleOf3) {
                i3++;
                nextMultilpleOf3 = ugly[i3] * 3;
            }
            if (nextUglyNumber == nextMultilpleOf5) {
                i5++;
                nextMultilpleOf5 = ugly[i5] * 5;
            }
        }
        return nextUglyNumber;
    }
}
