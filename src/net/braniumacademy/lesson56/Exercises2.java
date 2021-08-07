package net.braniumacademy.lesson56;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        int choice;
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        var input = new Scanner(System.in);
        do {
            System.out.println("====================== MENU ======================");
            System.out.println("1. Đọc các node từ file.");
            System.out.println("2. Duyệt cây theo thứ tự in-order.");
            System.out.println("3. Liệt kê các node lá của cây.");
            System.out.println("4. Liệt kê các node cành cây.");
            System.out.println("5. Liệt kê các node có 2 cây con.");
            System.out.println("6. Liệt kê các node có 1 cây con.");
            System.out.println("7. Liệt kê các node chỉ có cây con trái.");
            System.out.println("8. Liệt kê các node chỉ có cây con phải.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn?");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) { // biểu thức switch, hỗ trợ từ phiên bản java 12+
                case 0 -> System.out.println("<== Phiên làm việc kết thúc ==>");
                case 1 -> {
                    System.out.println("Nhập tên file đầu vào: ");
                    String fileName = input.nextLine();
                    tree = new BinarySearchTree<>(); // new một cây nhị phân tìm kiếm mới
                    readInputFile(tree, fileName);
                }
                case 2 -> {
                    System.out.println("Các node của cây nhị phân tìm kiếm: ");
                    tree.inOrder();
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Số node lá trên cây: " + tree.countLeafNodes());
                    System.out.println("Các node lá: ");
                    tree.listLeafNodes();
                }

                case 4 -> {
                    System.out.println("Số lượng node cành trên cây: " + tree.countBranchNodes());
                    System.out.println("Các node cành: ");
                    tree.listBranchNodes();
                }
                case 5 -> {
                    System.out.println("Số lượng node có 2 cây con: " + tree.countTwoSubtreeNodes());
                    System.out.println("Các node cành có 2 cây con: ");
                    tree.listNodeHave2Children();
                }
                case 6 -> {
                    System.out.println("Các node có 1 cây con: ");
                    tree.listNodeHaveOnly1Child();
                }
                case 7 -> {
                    System.out.println("Các node chỉ có cây con trái: ");
                    tree.listNodeHaveOnlyLeftChild();
                }
                case 8 -> {
                    System.out.println("Các node chỉ có cây con phải: ");
                    tree.listNodeHaveOnlyRightChild();
                }
                default -> System.out.println("<== Sai chức năng, vui lòng kiểm tra lại ==>");
            }
        } while (choice != 0);
    }

    private static void readInputFile(BinarySearchTree<Integer> tree, String fileName) {
        // sử dụng try-with-resource
        try (var fileReader = new Scanner(new File(fileName))) {
            var n = fileReader.nextInt();
            for (int i = 0; i < n; i++) {
                var x = fileReader.nextInt();
                tree.add(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
