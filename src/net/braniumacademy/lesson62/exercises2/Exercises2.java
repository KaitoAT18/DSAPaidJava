package net.braniumacademy.lesson62.exercises2;

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        Heap heap = new Heap(100);
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 phần tử.");
            System.out.println("2. Hiển thị các phần tử trong heap.");
            System.out.println("3. Cho biết phần tử lớn nhất trong heap.");
            System.out.println("4. Cho biết kích thước của heap hiện thời.");
            System.out.println("5. Thoát chương trình.");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập phần tử mới: ");
                    int element = input.nextInt();
                    heap.add(element);
                    break;
                case 2:
                    System.out.println("Các phần tử trong heap: ");
                    heap.showElements();
                    break;
                case 3:
                    try {
                        System.out.println("Phần tử lớn nhất: " + heap.max());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Phần tử nhỏ nhất: " + heap.min());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 5);
    }
}
