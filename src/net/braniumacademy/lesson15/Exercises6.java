package net.braniumacademy.lesson15;

/**
 * @author Branium Academy
 * @version 2.0
 * @file Exercises6.java
 * @brief Update exercises 4 lesson 2.6
 * @date 2022-10-31
 * @copyright Copyright (c) Branium Academy 2022
 * @see <a href="https://braniumacademy.net">...</a>
 */

// chiến lược top-down tìm chuỗi con chung dài nhất
// giả sử ta có chuỗi str1 gồm m phần tử, str2 gồm n phần tử và lcs(str1, str2) là độ dài chuỗi con chung
// dài nhất của str1, str2. Sau đây là các bước đệ quy để tìm độ dài chuỗi con chung tối đa:
// 1. Nếu kí tự cuối của hai chuỗi trùng nhau, tức là str1[m-1] == str2[n-1] thì
//      lcs(str1, str2) = 1+ lcs(str1[0,.., m-2], str2[0,...,n-2]);
// 2. Nếu kí tự cuối của hai chuỗi khác nhau thì
//      lcs(str1[0,..., m-1], str2[0,..., n-1]) = max(lcs(str1[0,...,m-2], str2[0,...,n-1]), str1[0,...,m-1], str2[0,...,n-2]));
//
//                          lcs("AXYT", "AYZX")
//                            /              \
//              lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
//                 /       \                       /         \
// lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
// để tránh việc lặp lại tính toán, ta sử dụng mảng/vector lưu trữ kết quả tính toán từng bước
// sau đó tái sử dụng
public class Exercises6 {
    public static void main(String[] args) {
        String str1 = "AGGTAB"; // tạo chuỗi str1
        String str2 = "GXTXAYB"; // tạo chuỗi str2
        int m = str1.length();
        int n = str2.length();
        int[][] table = new int[m + 1][n + 1];
        int result = findLCS(str1, str2, m, n, table);
        System.out.println("Độ dài chuỗi con chung dài nhất: " + result);
    }

    private static int findLCS(String str1, String str2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return dp[m][n] = 1 + findLCS(str1, str2, m - 1, n - 1, dp);
        }
        if (dp[m][n] != 0) {
            return dp[m][n];
        }
        return dp[m][n] = Math.max(findLCS(str1, str2, m, n - 1, dp),
                findLCS(str1, str2, m - 1, n, dp));
    }
}
