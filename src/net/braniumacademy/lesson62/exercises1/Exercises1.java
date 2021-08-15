package net.braniumacademy.lesson62.exercises1;

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(String.class, 100);
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
                    String element = input.next();
                    heap.add(element);
                    break;
                case 2:
                    System.out.println("Các phần tử trong heap: ");
                    heap.showElements();
                    break;
                case 3:
                    System.out.println("Phần tử lớn nhất: " + heap.max());
                    break;
                case 4:
                    System.out.println("Số phần tử trong heap: " + heap.size());
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
