package net.braniumacademy.lesson16;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] weights = new int[]{15, 22, 14, 26, 32, 9, 16, 8};
        int target = 53; // tổng mục tiêu
        Arrays.sort(weights); // sắp xếp tăng dần tập đầu vào
        generateSubsets(weights, target); // tìm tất cả các tập con có tổng = target
    }
    // phương thức in tất cả các tập con có tổng == target
    private static void generateSubsets(int[] weights, int target) {
        int total = 0;
        int[] subsets = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
        }
        if (weights[0] <= target && total >= target) {
            subsetSum(weights, subsets, 0, 0, 0, target);
        }
    }

    /**
     * Phương thức tìm tổng tập con và hiển thị nó ra màn hình
     * @param weights tập đầu vào
     * @param subsets tập kết quả
     * @param subsetSize kích thước của tập kết quả
     * @param sum tổng hiện thời
     * @param current giá trị chỉ số đang xét hiện thời
     * @param target tổng mục tiêu
     */
    private static void subsetSum(int[] weights, int[] subsets,
                                  int subsetSize, int sum, int current, int target) {
        if (target == sum) { // nếu tổng hiện tại bằng tổng mục tiêu
            printSubset(subsets, subsetSize); // hiển thị tập kết quả
            // nếu chỉ số phần tử kế tiếp còn trong biên mảng tập đầu vào
            // và tổng hiện thời trừ phần tử đang xét + tổng phần tử kế tiếp nhỏ hơn tổng mục tiêu
            if (current + 1 < weights.length && sum - weights[current] + weights[current + 1] <= target) {
                // tiếp tục đệ quy để tìm tập kết quả tiếp theo, loại bỏ phần tử hiện tại
                subsetSum(weights, subsets, subsetSize - 1, sum - weights[current], current + 1, target);
            }
        } else {
            // kiểm tra ràng buộc chỉ số phần tử
            if (current < weights.length && sum + weights[current] <= target) {
                // sinh các node dọc theo chiều rộng của mảng đầu vào
                for (int i = current; i < weights.length; i++) {
                    subsets[subsetSize] = weights[i];
                    if (sum + weights[i] <= target) { // nếu tổng hiện thời với phần tử đang xét nhỏ hơn hoặc bằng mục tiêu
                        // xem xét tìm tổng tập con của level tiếp theo
                        subsetSum(weights, subsets, subsetSize + 1,
                                sum + weights[i], i + 1, target);
                    }
                }
            }
        }
    }

    private static void printSubset(int[] subsets, int subsetSize) {
        for (int i = 0; i < subsetSize; i++) {
            System.out.print(subsets[i] + " ");
        }
        System.out.println();
    }
}
