package net.braniumacademy.lesson33.exercises5;

import java.util.Scanner;

public class Exercises5 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int test = input.nextInt();
        input.nextLine();
        while (test > 0) {
            var str = input.nextLine();
            str = addSpace(str);
            var infix = postfixToInfix(str);
            System.out.println(infix);
            test--;
        }
    }

    /**
     * Phương thức kiểm tra xem liệu tham số nhận được có phải là toán tử hay không
     *
     * @param input tham số đầu vào
     * @return kết luận true nếu input là toán tử và false nếu ngược lại
     */
    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") ||
                input.equals("/") || input.equals("^");
    }

    /**
     * Phương thức chuyển đổi từ hậu tố sang trung tố.
     *
     * @param str biểu thức hậu tố đầu vào
     * @return biểu thức trung tố
     */
    private static String postfixToInfix(String str) {
        var elements = str.split("\\s+");
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (var e : elements) {
            if (isOperator(e)) {
                var b = stack.pop();
                var a = stack.pop();
                stack.push("(" + a + " " + e + " " + b + ")");
            } else {
                stack.push(e);
            }
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
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

}
