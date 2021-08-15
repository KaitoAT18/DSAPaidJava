package net.braniumacademy.lesson63.exercises5;

import java.util.Scanner;

public class Exercises5 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(100);
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 phần tử.");
            System.out.println("2. Peek node đầu queue.");
            System.out.println("3. Pop node đầu queue.");
            System.out.println("4. Hiển thị các phần tử trong queue.");
            System.out.println("5. Tìm xem sinh viên x có tồn tại trong queue.");
            System.out.println("6. Thoát chương trình.");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập phần tử mới và thứ tự ưu tiên: ");
                    String element = input.next();
                    int priority = input.nextInt();
                    queue.add(element, priority);
                    break;
                case 2:
                    var peekNode = queue.peek();
                    if (peekNode != null) {
                        System.out.printf("Phần đầu hàng đợi: %s(%d)\n",
                                peekNode.getValue(), peekNode.getPriority());
                    } else {
                        System.out.println("Hàng đợi rỗng.");
                    }
                    break;
                case 3:
                    var removedNode = queue.pop();
                    if (removedNode != null) {
                        System.out.printf("Phần đã bị xóa bỏ: %s(%d)\n",
                                removedNode.getValue(), removedNode.getPriority());
                    } else {
                        System.out.println("Hàng đợi rỗng.");
                    }

                    break;
                case 4:
                    System.out.println("Các phần tử trong queue: ");
                    queue.showElements();
                    break;
                case 5:
                    System.out.println("Nhập giá trị cần tìm: ");
                    var key = input.next();
                    var resultIndex = queue.search(key);
                    if (resultIndex < 0) {
                        System.out.println("Giá trị cần tìm không tồn tại.");
                    } else {
                        System.out.println("Giá trị cần tìm tồn tại trong queue.");
                    }
                    break;
                case 6:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 6);
    }
}
