package net.braniumacademy.lesson63.exercises3;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

import java.util.Scanner;

public class Exercises3 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap(Integer.class, 100);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 phần tử.");
            System.out.println("2. Hiển thị các phần tử trong heap.");
            System.out.println("3. Tìm xem node có giá trị x có tồn tại không.");
            System.out.println("4. Xóa node có giá trị x khỏi heap.");
            System.out.println("5. Cho biết phần tử nhỏ nhất trong heap.");
            System.out.println("6. Cho biết kích thước của heap hiện thời.");
            System.out.println("7. Thoát chương trình.");
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
                    System.out.println("Nhập node cần tìm: ");
                    int x = input.nextInt();
                    int findXIndex = heap.findNode(x);
                    if (findXIndex != -1) {
                        System.out.printf("%s tồn tại trong heap.\n", x);
                    } else {
                        System.out.printf("%s không tồn tại trong heap.\n", x);
                    }
                    break;
                case 4:
                    System.out.println("Nhập giá trị cần xóa: ");
                    x = input.nextInt();
                    boolean removeX = heap.remove(x);
                    if (removeX) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Xóa thất bại!");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Phần tử nhỏ nhất: " + heap.min());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Kích thước của heap: " + heap.size());
                    break;
                case 7:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 7);
    }
}
