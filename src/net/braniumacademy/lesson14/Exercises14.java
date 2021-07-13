package net.braniumacademy.lesson14;

import java.util.Scanner;

public class Exercises14 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    /**
     * Phương thức giải bài toán tháp Hà Nội. Các bước thực hiện:
     * B1: Nếu n == 1, chuyển n từ cọc A sang cọc C. Kết thúc.
     * B2: gọi đệ quy, chuyển n-1 đĩa từ cọc A sang cọc B.
     * B3: chuyển đĩa dưới cùng sang cọc C.
     * B4: chuyển n-1 đĩa từ cọc B sang cọc C.
     * Sau khi chuyển, đọc ngược giá trị tại cột C từ dưới lên
     * với điều kiện giá trị đọc trước nhỏ hơn giá trị đọc sau
     * sẽ được kết quả xét từ trên xuống(1-n).
     *
     * @param n       số đĩa cần chuyển, ban đầu chúng được sắp theo thứ tự từ nhỏ đến lớn
     *                trên cộc A, xét từ trên đỉnh xuống đáy.
     * @param fromRod cọc A
     * @param toRod   cọc B
     * @param tmpRod  cọc C
     */
    private static void towerOfHanoi(int n, char fromRod, char toRod, char tmpRod) {
        if (n == 1) {
            System.out.println("Chuyển " + n + " từ cọc " + fromRod + " đến cọc " + toRod);
            return;
        }
        towerOfHanoi(n - 1, fromRod, tmpRod, toRod);
        System.out.println("Chuyển " + n + " từ cọc " + fromRod + " đến cọc " + toRod);
        towerOfHanoi(n - 1, tmpRod, toRod, fromRod);
    }
}
