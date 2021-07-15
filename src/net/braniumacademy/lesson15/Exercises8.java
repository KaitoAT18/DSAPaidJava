package net.braniumacademy.lesson15;

import java.util.Scanner;

public class Exercises8 {
    private static int MAX = 2000;
    static boolean[][] subset = new boolean[MAX][MAX];

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        System.out.println("Nhập tổng cần xét: ");
        int sum = new Scanner(System.in).nextInt();
        if (isSubsetSum(set, set.length, sum)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    /**
     * th1: tập chứa phần tử cuối, tổng cần xét bằng tổng mục tiêu - giá trị phần tử cuối.
     * th2: tập không chứa phần tử cuối, tổng cần xét = tổng mục tiêu.
     */
    static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) { // nếu tổng == 0 -> true vì có 1 cách không chọn phần tử nào trong tập hợp
            return true;
        }
        if (n == 0) { // nếu n == 0 fase vì không thể tạo tổng sum từ 0 phần tử khi sum != 0
            return false;
        }
        if (subset[n - 1][sum]) { // nếu giá trị tại vị trí n đã được tính, trả về giá trị đó
            return subset[n - 1][sum];
        }
        if (set[n - 1] > sum) { // nếu giá trị cuối trong tập đang xét tại vị trí n-1 > tổng sum,
            return subset[n - 1][sum] = isSubsetSum(set, n - 1, sum); // gọi đệ quy tính giá trị kế tiếp
        }
        // nếu không thỏa các điều kiện trên, tiếp tục đệ quy trong 2 trường hợp xét đến sự góp mặt
        // hoặc không có mặt của phần tử cuối tập đang xét tại vị trí n-1
        return subset[n - 1][sum] = isSubsetSum(set, n - 1, sum) // không có mặt phần tử cuối tập đang xét
                || isSubsetSum(set, n - 1, sum - set[n - 1]); // có mặt phần tử cuối tập đang xét
    }
}
