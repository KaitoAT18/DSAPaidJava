package net.braniumacademy.lesson65.exercises2;

/**
 * @author Branium Academy
 * @version 2021.08
 * @see <a href="https://braniumacademy.net/">Branium Academy</a>
 */

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        PriorityQueue<Student> queue = new PriorityQueue<>(100);
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 sinh viên vào hàng đợi.");
            System.out.println("2. Hiển thị các phần tử trong hàng đợi.");
            System.out.println("3. Tìm sinh viên theo mã.");
            System.out.println("4. Peek node đầu hàng đợi.");
            System.out.println("5. Pop node đầu hàng đợi.");
            System.out.println("6. Kiểm tra xem hàng đợi có rỗng không.");
            System.out.println("7. Kiểm tra xem hàng đợi đã đầy chưa.");
            System.out.println("8. Cho biết kích thước hiện thời của queue.");
            System.out.println("9. Thoát chương trình.");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Mã sinh viên: ");
                    var id = input.nextLine();
                    System.out.println("Họ: ");
                    var last = input.nextLine();
                    System.out.println("Đệm: ");
                    var mid = input.nextLine();
                    System.out.println("Tên: ");
                    var first = input.nextLine();
                    System.out.println("Điểm TB: ");
                    var gpa = Float.parseFloat(input.nextLine());
                    System.out.println("Thứ tự ưu tiên: ");
                    var priority = Integer.parseInt(input.nextLine());
                    queue.add(new Student(id, first, last, mid, gpa), priority);
                    break;
                case 2:
                    if(queue.isEmpty()) {
                        System.err.println("Hàng đợi rỗng.");
                    } else {
                        System.out.println("Các phần tử trong hàng đợi: ");
                        queue.showElements();
                    }
                    break;
                case 3:
                    if(queue.isEmpty()) {
                        System.err.println("Hàng đợi rỗng.");
                    } else {
                        System.out.println("Nhập mã sinh viên: ");
                        id = input.nextLine();
                        var student = new Student(id);
                        int findXIndex = queue.search(student);
                        if (findXIndex != -1) {
                            System.out.printf("Sinh viên mã \"%s\" tồn tại trong hàng đợi.\n", student.getId());
                        } else {
                            System.out.printf("Sinh viên mã \"%s\" không tồn tại trong hàng đợi.\n", student.getId());
                        }
                    }
                    break;
                case 4:
                    var peekNode = queue.peek();
                    if (peekNode != null) {
                        System.out.printf("Phần đầu hàng đợi: %s(%d)\n",
                                peekNode.getValue(), peekNode.getPriority());
                    } else {
                        System.err.println("Hàng đợi rỗng.");
                    }
                    break;
                case 5:
                    var removedNode = queue.pop();
                    if (removedNode != null) {
                        System.out.printf("Phần đã bị xóa bỏ: %s(%d)\n",
                                removedNode.getValue(), removedNode.getPriority());
                    } else {
                        System.err.println("Hàng đợi rỗng.");
                    }
                    break;
                case 6:
                    System.out.println("Hàng đợi rỗng? " + queue.isEmpty());
                    break;
                case 7:
                    System.out.println("Hàng đợi đầy? " + queue.isFull());
                    break;
                case 8:
                    System.out.println("Kích thước của hàng đợi: " + queue.size());
                    break;
                case 9:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.err.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 9);
    }
}
