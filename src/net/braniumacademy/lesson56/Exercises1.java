package net.braniumacademy.lesson56;

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        int choice;
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        var input = new Scanner(System.in);
        do {
            System.out.println("====================== MENU ======================");
            System.out.println("1. Đọc các node từ file.");
            System.out.println("2. Duyệt cây theo thứ tự in-order.");
            System.out.println("3. Tìm giá trị x có tồn tại trong cây hay không.");
            System.out.println("4. Đếm tổng số node có trên cây.");
            System.out.println("5. Đếm số node lá có trên cây.");
            System.out.println("6. Đếm số lượng node cành của cây.");
            System.out.println("7. Đếm số lượng node có 2 cây con.");
            System.out.println("8. Xác định độ sâu của node x.");
            System.out.println("9. Xác định chiều cao của cây.");
            System.out.println("10. Xác định bậc của một node x nhập từ bàn phím.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn?");
            choice = input.nextInt();
            switch (choice) { // biểu thức switch, hỗ trợ từ phiên bản java 12+
                case 0 -> System.out.println("<== Phiên làm việc kết thúc ==>");
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> {

                }
                case 8 -> {

                }
                case 9 -> {

                }
                case 10 -> {

                }
                default -> System.out.println("<== Sai chức năng, vui lòng kiểm tra lại ==>");
            }
        } while (choice != 0);
    }
}
