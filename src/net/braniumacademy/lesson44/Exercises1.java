package net.braniumacademy.lesson44;

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(10);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=========== MENU ===========");
            System.out.println("1. Thêm mới phần tử vào queue.");
            System.out.println("2. Xóa phần tử đầu queue.");
            System.out.println("3. Lấy phần tử đầu queue nhưng không xóa.");
            System.out.println("4. Lấy số lượng phần tử hiện tại của queue.");
            System.out.println("5. Hiển thị các phần tử có trong queue.");
            System.out.println("6. Kiểm tra queue rỗng không.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Xin mời chọn: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("<== Cảm ơn quý vị đã sử dụng dịch vụ! ==>");
                    break;
                case 1:
                    System.out.println("Nhập giá trị cần thêm vào hàng đợi: ");
                    int x = input.nextInt();
                    var result = queue.enqueue(x);
                    System.out.println(result ? "Thêm thành công." : "Thêm thất bại.");
                    break;
                case 2:
                    var headElement = queue.dequeue();
                    System.out.println("Giá trị phần tử đầu hàng đợi: " + headElement);
                    break;
                case 3:
                    System.out.println("Phần tử đầu hàng đợi: " + queue.peek());
                    break;
                case 4:
                    System.out.println("Số phần tử hiện có trong hàng đợi: " + queue.size());
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.out.println(queue.isEmpty() ? "Queue rỗng." : "Queue không rỗng.");
                    break;
            }
        } while (choice != 0);
    }
}
