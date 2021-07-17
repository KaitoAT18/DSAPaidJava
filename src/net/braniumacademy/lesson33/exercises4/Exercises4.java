package net.braniumacademy.lesson33.exercises4;

import java.util.Scanner;

public class Exercises4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int test = input.nextInt();
        input.nextLine();
        while (test > 0) {
            var str = input.nextLine();
            str = addSpace(str);
            var result = calculateResult(str);
            System.out.println(result);
            test--;
        }
    }

    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") ||
                input.equals("/") || input.equals("^");
    }

    /**
     * Phương thức tính toán giá trị biểu thức dạng hậu tố
     *
     * @param str biểu thức hậu tố đầu vào
     * @return kết quả tính toán được
     */
    private static double calculateResult(String str) {
        double result;
        Stack<String> stack = new Stack<>();
        String[] words = str.split("\\s+"); // tách biểu thức tại vị trí có 1 hoặc nhiều dấu cách
        for (var e : words) {
            if (isOperator(e)) {
                double b = Double.parseDouble(stack.pop());
                double a = Double.parseDouble(stack.pop());
                result = makeResult(a, b, e);
                stack.push(result + "");
            } else {
                stack.push(e);
            }
        }
        return Double.parseDouble(stack.pop());
    }

    /**
     * Phương thức tính toán kết quả a operator b.
     *
     * @param a toán hạng đầu
     * @param b toán hạng sau
     * @param e toán tử
     * @return giá trị đạt được
     */
    private static double makeResult(double a, double b, String e) {
        return switch (e) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "^" -> Math.pow(a, b);
            default -> 0;
        };
    }

    /**
     * Phương thức thêm dấu cách vào trước và sau các phép toán.
     * Mục đích nhằm dễ dàng cho việc phân tách biểu thức thành từng phần tử đơn.
     *
     * @param input biểu thức trung tố đầu vào
     * @return input sau khi đã thêm dấu cách vào trước và sau phép toán.
     */
    private static String addSpace(String input) {
        input = input.replaceAll("\\^", " ^ ");
        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("-", " - ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("/", " / ");
        return input;
    }
}
