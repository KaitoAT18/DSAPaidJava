package net.braniumacademy.lesson34.exercises6;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */
// test case đặc biệt: ((25-(38/60))*((77/19)-3) phải cho kết quả là: 25 38 60 / - 77 19 / 3 - *

public class Exercises6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int test = input.nextInt();
        input.nextLine();
        while (test > 0) {
            var str = input.nextLine();
            str = addSpace(str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            var revStr = stringBuilder.reverse().toString();
            var postfix = infixToPostfix(revStr);
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(postfix);
            var infix = stringBuilder.reverse().toString();
            System.out.println(infix);
            test--;
        }
    }

    /**
     * Phương thức kiểm tra thứ tự ưu tiên của toán tử.
     *
     * @param operator toán tử cần lấy thứ tự ưu tiên.
     * @return thứ tự ưu tiên của toán tử đang xét trong đề bài.
     */
    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> 0;
        };
    }

    /**
     * Phương thức thêm dấu cách vào trước và sau các dấu ngoặc và phép toán.
     * Mục đích nhằm dễ dàng cho việc phân tách biểu thức thành từng phần tử đơn.
     *
     * @param input biểu thức trung tố đầu vào
     * @return input sau khi đã thêm dấu cách vào trước và sau dấu ngoặc, phép toán.
     */
    private static String addSpace(String input) {
        input = input.replaceAll("\\^", " ^ ");
        input = input.replaceAll("\\(", " ( ");
        input = input.replaceAll("\\)", " ) ");
        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("-", " - ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("/", " / ");
        return input;
    }

    /**
     * Phương thức chuyển đổi từ trung tố sang hậu tố.
     *
     * @param str chuỗi chứa biểu thức trung tố.
     * @return biểu thức hậu tố tương ứng.
     */
    private static String infixToPostfix(String str) {
        var infixElements = str.split("\\s+");
        var result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (var e : infixElements) {
            if (precedence(e) > 0) { // e là toán tử
                while (!stack.isEmpty() && precedence(e) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(e);
            } else if (e.equals(")")) { // là dấu ngoặc đóng
                String operator = null;
                if (!stack.isEmpty()) {
                    operator = stack.pop();
                }
                while (operator != null && !operator.equals("(")) {
                    result.append(operator).append(" ");
                    operator = stack.pop();
                }
            } else if (e.equals("(")) { // là dấu ngoặc mở
                stack.push(e);
            } else { // nếu là toán hạng, push vào stack
                result.append(e).append(" ");
            }
        }
        // pop các phần tử còn lại của stack
        while (!stack.isEmpty()) {
            var operator = stack.pop();
            if (!operator.equals("(")) {
                result.append(operator).append(" ");
            }
        }
        return result.toString();
    }
}
