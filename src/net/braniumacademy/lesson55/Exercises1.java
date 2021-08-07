package net.braniumacademy.lesson55;

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("========= MENU ========");
            System.out.println("1. Thêm mới 1 node.");
            System.out.println("2. Duyệt cây");
            System.out.println("3. Tìm giá trị trong cây");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn? ");
            choice = input.nextInt();
            switch (choice) {
                case 0 -> System.out.println("<== Chương trình kết thúc. ==>");
                case 1 -> {
                    System.out.println("Nhập giá trị mới: ");
                    String str = input.next();
                    tree.add(str);
                }
                case 2 -> {
                    System.out.println("Các phần tử trong cây: ");
                    tree.inOrder();
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Nhập giá trị cần tìm: ");
                    String key = input.next();
                    if (tree.search(key)) {
                        System.out.println("Tìm thấy giá trị " + key + " trong cây.");
                    } else {
                        System.out.println("Không tồn tại giá trị " + key + " trong cây.");
                    }
                }
                default -> System.out.println("Sai chức năng, vui lòng chọn lại.");
            }
        } while (choice != 0);
    }
}
