package net.braniumacademy.lesson56;

import java.io.File;
import java.io.FileNotFoundException;
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
                    System.out.println("Nhập giá trị cần tìm: ");
                    int x = input.nextInt();
                    System.out.println((tree.search(x) ? "Tìm thấy " : "Không tìm thấy ") + x);
                }
                case 4 -> System.out.println("Tổng số node của cây: " + tree.countNodes());
                case 5 -> System.out.println("Số node lá trên cây: " + tree.countLeafNodes());
                case 6 -> System.out.println("Số lượng node cành trên cây: " + tree.countBranchNodes());
                case 7 -> System.out.println("Số lượng node có 2 cây con: " + tree.countTwoSubtreeNodes());
                case 8 -> {
                    System.out.println("Nhập giá trị node x: ");
                    int x = input.nextInt();
                    System.out.println("Độ sâu của node x: " + tree.deepOfX(x));
                }
                case 9 -> System.out.println("Chiều cao của cây: " + tree.height());
                case 10 -> {
                    System.out.println("Nhập giá trị node x: ");
                    int x = input.nextInt();
                    System.out.println("Bậc của node x: " + tree.levelOfNode(x));
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
